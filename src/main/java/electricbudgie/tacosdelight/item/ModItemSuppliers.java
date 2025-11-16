package electricbudgie.tacosdelight.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItemSuppliers {
    private static final Map<ModFoodComponents.FoodType, Map<ModFoodComponents.FillingType, Supplier<Item>>> SUPPLIERS =
            new EnumMap<>(ModFoodComponents.FoodType.class);

    static{
        // Tacos
        Map<ModFoodComponents.FillingType, Supplier<Item>> tacos = new EnumMap<>(ModFoodComponents.FillingType.class);
        tacos.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_TACO);
        tacos.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_TACO);
        tacos.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_TACO);
        tacos.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.POTATO_TACO);
        SUPPLIERS.put(ModFoodComponents.FoodType.TACO, tacos);

        Map<ModFoodComponents.FillingType, Supplier<Item>> burritos = new EnumMap<>(ModFoodComponents.FillingType.class);
        burritos.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_BURRITO);
        burritos.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_BURRITO);
        burritos.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_BURRITO);
        burritos.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.POTATO_BURRITO);
        SUPPLIERS.put(ModFoodComponents.FoodType.BURRITO, burritos);

        Map<ModFoodComponents.FillingType, Supplier<Item>> quesadillas = new EnumMap<>(ModFoodComponents.FillingType.class);
        quesadillas.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_QUESADILLA);
        quesadillas.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_QUESADILLA);
        quesadillas.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_QUESADILLA);
        quesadillas.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.CHEESE_QUESADILLA);
        SUPPLIERS.put(ModFoodComponents.FoodType.QUESADILLA, quesadillas);

        Map<ModFoodComponents.FillingType, Supplier<Item>> crunchwraps = new EnumMap<>(ModFoodComponents.FillingType.class);
        crunchwraps.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_CRUNCHWRAP);
        crunchwraps.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_CRUNCHWRAP);
        crunchwraps.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_CRUNCHWRAP);
        SUPPLIERS.put(ModFoodComponents.FoodType.CRUNCHWRAP, crunchwraps);


        Map<ModFoodComponents.FillingType, Supplier<Item>> nachos = new EnumMap<>(ModFoodComponents.FillingType.class);
        //nachos.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_NACHO_PLATTER_SERVING);
        //nachos.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_NACHO_PLATTER_SERVING);
        //nachos.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_NACHO_PLATTER_SERVING);
        //nachos.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.NACHO_PLATTER_SERVING);
        SUPPLIERS.put(ModFoodComponents.FoodType.NACHOS, nachos);

    }
    public static Supplier<Item> get(ModFoodComponents.FoodType foodType, ModFoodComponents.FillingType fillingType){
        return SUPPLIERS
                .getOrDefault(foodType, Map.of())
                .getOrDefault(fillingType, () -> Items.AIR);
    }
}
