package electricbudgie.tacosdelight.block.custom;

import electricbudgie.tacosdelight.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class HotPepperCropBlock extends CropBlock {
    public HotPepperCropBlock(Settings settings) {
        super(settings);
    }

    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = IntProperty.of("age", 0,5);

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HOT_PEPPER_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
