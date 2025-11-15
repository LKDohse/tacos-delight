package electricbudgie.tacosdelight.block.custom;

import com.mojang.serialization.MapCodec;
import electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import electricbudgie.tacosdelight.block.entity.custom.CheesePressBlockEntity;
import electricbudgie.tacosdelight.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CheesePressBlock extends BlockWithEntity {
    public static final MapCodec<CheesePressBlock> CODEC = createCodec(CheesePressBlock::new);
    public static final BooleanProperty PRESSING = BooleanProperty.of("pressing");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;


    public CheesePressBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(PRESSING, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PRESSING);
        builder.add(FACING);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.getItem() != ModItems.CURDS_AND_WHEY || state.get(PRESSING))
            return ItemActionResult.SUCCESS;
        if (world.getBlockEntity(pos)instanceof CheesePressBlockEntity blockEntity) {
            blockEntity.startPressing(pos, state);
            world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1f, 1f);
            stack.decrement(1);
        }
        return ItemActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.CHEESE_PRESS_BE, ((world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1)));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CheesePressBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

}
