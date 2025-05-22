package electricbudgie.tacosdelight.block.custom;

import com.mojang.serialization.MapCodec;
import electricbudgie.tacosdelight.item.ModItems;
import electricbudgie.tacosdelight.registry.ModDamageSources;
import electricbudgie.tacosdelight.tags.ModTags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;

public class BlueRaspberryBushBlock extends PlantBlock implements Fertilizable {
    public static final MapCodec<BlueRaspberryBushBlock> CODEC = createCodec(BlueRaspberryBushBlock::new);
    private static final int MAX_AGE = 6;
    private static final TagKey<Biome> GROWABLE_BIOMES = ModTags.IS_SNOWY;
    public static final IntProperty AGE = IntProperty.of("age", 0, 6);

    public BlueRaspberryBushBlock(Settings settings) {
        super(settings);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < MAX_AGE;
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (world.getBiome(pos).isIn(GROWABLE_BIOMES) && i < MAX_AGE && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState blockState = state.with(AGE, i + 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }

    }

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.slowMovement(state, new Vec3d(0.800000011920929, 0.75, 0.800000011920929));
            if (!world.isClient && state.get(AGE) > 0 && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);
                if (d >= 0.003000000026077032 || e >= 0.003000000026077032) {
                    DamageSource damageSource = new DamageSource(
                            world.getRegistryManager()
                                    .get(RegistryKeys.DAMAGE_TYPE)
                                    .entryOf(ModDamageSources.BLUE_RASPBERRY_BUSH));
                    entity.damage(damageSource, 1.0F);
                }
            }

        }
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean bl = i == 3;
        return !bl && stack.isOf(Items.BONE_MEAL) ? ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean bl = i == 4;
        if (i >= MAX_AGE) {
            int j = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(ModItems.BLUE_RASPBERRY, j + (bl ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = state.with(AGE, 4);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hit);
        }
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return CODEC;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return state.get(AGE) < MAX_AGE;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return world.getBiome(pos).isIn(GROWABLE_BIOMES);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(MAX_AGE, state.get(AGE) + 1);
        world.setBlockState(pos, state.with(AGE, i), 2);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
