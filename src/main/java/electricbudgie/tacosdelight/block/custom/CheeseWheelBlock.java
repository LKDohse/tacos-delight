package electricbudgie.tacosdelight.block.custom;

import com.mojang.serialization.MapCodec;
import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import electricbudgie.tacosdelight.block.entity.custom.CheeseWheelBlockEntity;
import electricbudgie.tacosdelight.components.ModComponents;
import electricbudgie.tacosdelight.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.List;

public class CheeseWheelBlock extends BlockWithEntity {

    public static final MapCodec<CheeseWheelBlock> CODEC = createCodec(CheeseWheelBlock::new);
    public static final IntProperty AGE = IntProperty.of("age", 0, 2);

    public CheeseWheelBlock(Settings settings) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.CHEESE_WHEEL_BE, ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1)));
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (itemCanCutTheCheese(stack) && state.get(AGE) >= 2) {
                ItemStack cheeseStack = new ItemStack(ModItems.CHEESE_WEDGE, 8);
                ItemEntity cheeseEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), cheeseStack);
                world.spawnEntity(cheeseEntity);
                world.syncWorldEvent(2001, pos, Block.getRawIdFromState(state));
                world.removeBlock(pos, false);
                world.playSound(
                        null,
                        pos,
                        state.getSoundGroup().getBreakSound(),
                        SoundCategory.BLOCKS,
                        1.0f,
                        1.0f
                );
            }
        }
        return ItemActionResult.SUCCESS;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onPlaced(world, pos, state, placer, stack);
        var storedAge = stack.get(ModComponents.AGE_COMPONENT);
        if (storedAge == null) return;

        world.setBlockState(pos, state.with(AGE, storedAge), Block.NOTIFY_ALL);
        var entity = world.getBlockEntity(pos);
        if (entity instanceof CheeseWheelBlockEntity cheeseEntity)
            cheeseEntity.setAge(storedAge);
    }

    @Override
    protected List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        ItemStack stack = new ItemStack(ModBlocks.CHEESE_WHEEL_BLOCK.asItem());
        stack.set(ModComponents.AGE_COMPONENT, state.get(AGE));
        return List.of(stack);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CheeseWheelBlockEntity(pos, state);
    }

    private boolean itemCanCutTheCheese(ItemStack stack) {
        return stack.isIn(ModTags.KNIVES);
    }
}
