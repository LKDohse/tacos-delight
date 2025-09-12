package electricbudgie.tacosdelight.block.custom;

import com.google.common.base.Suppliers;
import electricbudgie.tacosdelight.item.ModFoodComponents;
import electricbudgie.tacosdelight.item.ModItemSuppliers;
import electricbudgie.tacosdelight.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class TacoBoxBlock extends FoodTrayBlock {
    public static final IntProperty TACO_SERVINGS = IntProperty.of("servings", 0, 6);
    public static int MAX_SERVINGS = 6;

    protected static final VoxelShape PLATE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape FOOD_SHAPE = VoxelShapes.union(
            PLATE_SHAPE,
            Block.createCuboidShape(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D)
    );

    private final List<Supplier<Item>> tacoBoxServings = new ArrayList<>();
    private static Supplier<Item> tacoSupplier(ModFoodComponents.FillingType fillingType) {
        return ModItemSuppliers.get(ModFoodComponents.FoodType.TACO, fillingType);
    }

    public TacoBoxBlock(Settings properties, ModFoodComponents.FillingType fillingType, boolean hasLeftovers) {
        super(properties, tacoSupplier(fillingType), hasLeftovers);
        for (int i =0; i < MAX_SERVINGS; i++ ){
            tacoBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.TACO, fillingType));
        }
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(TACO_SERVINGS, 6));
    }
    @Override
    public IntProperty getServingsProperty() {
        return TACO_SERVINGS;
    }

    @Override
    public int getMaxServings() {
        return 6;
    }

    @Override
    public ItemStack getServingItem(BlockState state) {
        int servings = state.get(getServingsProperty());
        if (servings > 0 && servings <= tacoBoxServings.size()) {
            return new ItemStack(tacoBoxServings.get(servings - 1).get());
        }
        return ItemStack.EMPTY;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TACO_SERVINGS);
    }

}


