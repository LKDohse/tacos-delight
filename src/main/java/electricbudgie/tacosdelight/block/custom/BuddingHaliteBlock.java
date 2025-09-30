package electricbudgie.tacosdelight.block.custom;

import com.mojang.serialization.MapCodec;
import electricbudgie.tacosdelight.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingHaliteBlock extends Block {
    public static final MapCodec<BuddingHaliteBlock> CODEC = createCodec(BuddingHaliteBlock::new);
    public static final int GROW_CHANCE = 2;
    private static final Direction[] DIRECTIONS = Direction.values();

    public MapCodec<BuddingHaliteBlock> getCodec() {
        return CODEC;
    }

    public BuddingHaliteBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(GROW_CHANCE) != 0) return;

        Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
        BlockPos targetPos = pos.offset(direction);
        BlockState targetState = world.getBlockState(targetPos);
        Block blockToPlace = null;

        if (canGrowIn(targetState)) {
            blockToPlace = ModBlocks.SMALL_HALITE_BUD;
        } else {
            Direction budFacing = targetState.getBlock() instanceof HaliteClusterBlock ? targetState.get(HaliteClusterBlock.FACING) : null;

            if (budFacing != null) {
                if (targetState.isOf(ModBlocks.SMALL_HALITE_BUD) && budFacing == direction) {
                    blockToPlace = ModBlocks.MEDIUM_HALITE_BUD;
                } else if (targetState.isOf(ModBlocks.MEDIUM_HALITE_BUD)  && budFacing == direction) {
                    blockToPlace = ModBlocks.LARGE_HALITE_BUD;
                } else if (targetState.isOf(ModBlocks.LARGE_HALITE_BUD) && budFacing == direction) {
                    blockToPlace = ModBlocks.HALITE_CLUSTER;
                }
            }
        }

        if (blockToPlace != null) {
            BlockState newState = blockToPlace.getDefaultState().with(HaliteClusterBlock.FACING, direction).with(HaliteClusterBlock.WATERLOGGED, targetState.getFluidState().getFluid() == Fluids.WATER);
            world.setBlockState(targetPos, newState, 3);
        }


    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}
