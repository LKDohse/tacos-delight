package electricbudgie.tacosdelight.block.custom;

import com.mojang.serialization.MapCodec;
import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.item.ModItems;
import electricbudgie.tacosdelight.tags.ModTags;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;


public class LimeTreeBlock extends TallPlantBlock implements Fertilizable {
    public static final MapCodec<LimeTreeBlock> CODEC = createCodec(LimeTreeBlock::new);
    private static final TagKey<Biome> GROWABLE_BIOMES = ModTags.IS_WARM;
    public static final int HARVEST_AGE = 5;
    public static final int ADULT_AGE = 3;
    public static final IntProperty AGE = IntProperty.of("age", 0, 5);
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;


    public LimeTreeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(AGE, 0)
                .with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public MapCodec<LimeTreeBlock> getCodec() {
        return CODEC;
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean bl = i == 3;
        return !bl && stack.isOf(Items.BONE_MEAL) ? ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean bl = i == 3;
        if (i >= HARVEST_AGE) {
            int j = 2 + world.random.nextInt(3);
            dropStack(world, pos, new ItemStack(ModItems.LIME, j + (bl ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = state.with(AGE, ADULT_AGE);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            if (state.get(HALF) == DoubleBlockHalf.LOWER)
                world.setBlockState(pos.up(), blockState.with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_ALL);
            else
                world.setBlockState(pos.down(), blockState.with(HALF, DoubleBlockHalf.LOWER), Block.NOTIFY_ALL);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hit);
        }
    }

    protected boolean hasRandomTicks(BlockState state) {
        return state.get(HALF) == DoubleBlockHalf.LOWER && state.get(AGE) < HARVEST_AGE;
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < HARVEST_AGE && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            this.tryGrow(world, state, pos, i + 1);
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        LimeTreeBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        return lowerHalfContext != null && state.get(AGE) < HARVEST_AGE;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return super.canPlaceAt(state, world, pos);
        } else {
            BlockState blockState = world.getBlockState(pos.down());
            return blockState.isOf(this) && blockState.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isIn(BlockTags.SAND) || floor.isOf(Blocks.FARMLAND);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        LimeTreeBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        if (lowerHalfContext != null) {
            this.tryGrow(world, lowerHalfContext.state, lowerHalfContext.pos, state.get(AGE) + 1);
        }
    }

    private void tryGrow(ServerWorld world, BlockState state, BlockPos pos, int nextAge) {
        if (nextAge <= HARVEST_AGE && world.getBiome(pos).isIn(GROWABLE_BIOMES)) {
            BlockState blockState = state.with(AGE, nextAge);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.setBlockState(pos.up(), blockState.with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_ALL);
        } else if (!world.getBiome(pos).isIn(GROWABLE_BIOMES)) {
            ItemStack lime = new ItemStack(ModItems.LIME, 1);
            ItemEntity lime_entity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), lime);
            world.spawnEntity(lime_entity);
            world.syncWorldEvent(2001, pos, Block.getRawIdFromState(state));
            world.removeBlock(pos, false);
            world.playSound(
                    null,
                    pos,
                    state.getSoundGroup().getBreakSound(),
                    SoundCategory.BLOCKS,
                    0.5f,
                    1.0f
            );
        }
    }


@Nullable
private LimeTreeBlock.LowerHalfContext getLowerHalfContext(WorldView world, BlockPos pos, BlockState state) {
    if (isLowerHalf(state)) {
        return new LimeTreeBlock.LowerHalfContext(pos, state);
    } else {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return isLowerHalf(blockState) ? new LimeTreeBlock.LowerHalfContext(blockPos, blockState) : null;
    }
}

private static boolean isLowerHalf(BlockState state) {
    return state.isOf(ModBlocks.LIME_TREE) && state.get(HALF) == DoubleBlockHalf.LOWER;
}

@Override
public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
    return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
}

protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(AGE);
    builder.add(HALF);
}

@Override
protected BlockState getStateForNeighborUpdate(
        BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
) {
    DoubleBlockHalf doubleBlockHalf = state.get(HALF);
    if (direction.getAxis() != Direction.Axis.Y
            || doubleBlockHalf == DoubleBlockHalf.LOWER != (direction == Direction.UP)
            || neighborState.isOf(this) && neighborState.get(HALF) != doubleBlockHalf) {
        return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    } else {
        return Blocks.AIR.getDefaultState();
    }
}

@Override
protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return VoxelShapes.fullCube();
}

record LowerHalfContext(BlockPos pos, BlockState state) {
}
}
