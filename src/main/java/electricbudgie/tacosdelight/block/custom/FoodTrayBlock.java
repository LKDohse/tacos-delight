package electricbudgie.tacosdelight.block.custom;

import net.minecraft.item.Item;
import net.minecraft.state.property.IntProperty;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public abstract class FoodTrayBlock extends FeastBlock {
    public static final int MAX_SERVINGS = 6;

    public FoodTrayBlock(Settings properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }
}
