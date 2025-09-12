package electricbudgie.tacosdelight.block.custom;

import electricbudgie.tacosdelight.item.ModFoodComponents;
import electricbudgie.tacosdelight.item.ModItemSuppliers;
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class CravingsBoxBlock extends FoodTrayBlock {
    public static final IntProperty CRAVINGS_SERVINGS = IntProperty.of("servings", 0, 8);
    public static int MAX_SERVINGS = 8;

    protected static final VoxelShape PLATE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape FOOD_SHAPE = VoxelShapes.union(
            PLATE_SHAPE,
            Block.createCuboidShape(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D)
    );

    private final List<Supplier<Item>> cravingsBoxServings = new ArrayList<>();
    private static Supplier<Item> cravingsSupplier(ModFoodComponents.FillingType fillingType) {
        return ModItemSuppliers.get(ModFoodComponents.FoodType.QUESADILLA, fillingType);
    }

    public CravingsBoxBlock(Settings properties, ModFoodComponents.FillingType fillingType, boolean hasLeftovers) {
        super(properties, cravingsSupplier(fillingType), hasLeftovers);
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.QUESADILLA, fillingType));
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.TACO, fillingType));
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.BURRITO, fillingType));
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.CRUNCHWRAP, fillingType));
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.QUESADILLA, fillingType));
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.TACO, fillingType));
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.BURRITO, fillingType));
        cravingsBoxServings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.CRUNCHWRAP, fillingType));

        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(CRAVINGS_SERVINGS, 8));
    }
    @Override
    public IntProperty getServingsProperty() {
        return CRAVINGS_SERVINGS;
    }

    @Override
    public int getMaxServings() {
        return 8;
    }

    @Override
    public ItemStack getServingItem(BlockState state) {
        int servings = state.get(getServingsProperty());
        if (servings > 0 && servings <= cravingsBoxServings.size()) {
            return new ItemStack(cravingsBoxServings.get(servings - 1).get());
        }
        return ItemStack.EMPTY;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, CRAVINGS_SERVINGS);
    }

}


