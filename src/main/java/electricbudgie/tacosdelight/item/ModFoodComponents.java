package electricbudgie.tacosdelight.item;

import electricbudgie.tacosdelight.effect.ModEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public enum FillingType{
        BEEF,
        CHICKEN,
        POTATO,
        CHEESE,
        FRUIT
    };

    public enum FoodType {
        QUESADILLA,
        TACO,
        BURRITO,
        CRUNCHWRAP,
        NACHOS
    }

    public static StatusEffectInstance GetFillingEffect(FillingType filling, int duration){
        return switch (filling) {
            case BEEF -> new StatusEffectInstance(StatusEffects.STRENGTH, duration);
            case CHICKEN -> new StatusEffectInstance(StatusEffects.HASTE, duration);
            case POTATO -> new StatusEffectInstance(StatusEffects.RESISTANCE, duration);
            case CHEESE -> new StatusEffectInstance(StatusEffects.REGENERATION, duration);
            case FRUIT -> new StatusEffectInstance(StatusEffects.ABSORPTION, duration);
        };
    }

    public static FoodComponent BuildSideProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F);
        builder.statusEffect(GetFillingEffect(type, 600), 0.7f);
        builder.statusEffect(new StatusEffectInstance(vectorwing.farmersdelight.common.registry.ModEffects.COMFORT, 600), 1f);
        builder.statusEffect(new StatusEffectInstance(ModEffects.GASSY, 400), 0.05f);
        return builder.build();
    }

    public static FoodComponent BuildRollupProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(8).saturationModifier(0.65F);
        builder.statusEffect(GetFillingEffect(type, 600), 0.4f);
        builder.statusEffect(new StatusEffectInstance(ModEffects.GASSY, 400), 0.05f);
        return builder.build();
    }

    public static FoodComponent BuildQuesadillaProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(10).saturationModifier(0.6F);
        builder.statusEffect(GetFillingEffect(type, 20), 0.45f);
        builder.statusEffect(new StatusEffectInstance(ModEffects.GASSY, 400), 0.05f);
        return builder.build();
    }

    public static FoodComponent BuildTacoProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(12).saturationModifier(0.65F);
        builder.statusEffect(GetFillingEffect(type, 25), 0.30F);
        builder.statusEffect(new StatusEffectInstance(ModEffects.GASSY, 400), 0.05f);
        return builder.build();
    }

    public static FoodComponent BuildBurritoProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(14).saturationModifier(0.7F);
        builder.statusEffect(GetFillingEffect(type, 30), 0.80F);
        builder.statusEffect(new StatusEffectInstance(ModEffects.GASSY, 400), 0.05f);
        return builder.build();
    }

    public static FoodComponent BuildCrunchwrapProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(14).saturationModifier(0.8F);
        builder.statusEffect(GetFillingEffect(type, 35), 0.85F);
        builder.statusEffect(new StatusEffectInstance(ModEffects.GASSY, 400), 0.05f);
        return builder.build();
    }

    public static final FoodComponent BASIC_INGREDIENT_PROPERTIES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3F).build();
    public static final FoodComponent SPICY_INGREDIENT_PROPERTIES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(ModEffects.SPICY, 200), 0.7F).build();
    public static final FoodComponent RAW_INGREDIENT_PROPERTIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.30F).build();
    public static final FoodComponent RAW_MEAT_PROPERTIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.70F).build();
    public static final FoodComponent MEAT_PROPERTIES = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).build();
    public static final FoodComponent UNFINISHED_FOOD_PROPERTIES = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.DISAPPOINTED, 200), 0.80F).build();
    public static final FoodComponent SYRUP_PROPERTIES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400), 0.50f).build();
    public static final FoodComponent BAJA_PROPERTIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 12000, 1),0.1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 2), 0.40F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 0.20F)
            .snack()
            .build();

    //Basic Ingredients
    public static final Item.Settings DICED_TOMATOES_SETTINGS =  new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings DRIED_ONION_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings FLOUR_TORTILLA_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings NACHO_CHEESE_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16);
    public static final Item.Settings SHREDDED_CHEESE_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings DICED_POTATO_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings SOUR_CREAM_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16);
    public static final Item.Settings RAW_TORTILLA_CHIPS_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings UNCOOKED_FIESTA_POTATOES_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings FRIED_FIESTA_POTATOES_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings TACO_SEASONING_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100), 0.10F).build());
    public static final Item.Settings TORTILLA_CHIPS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings FLOUR_TOSTADA = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings SALT = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings CHEESE_WEDGE = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings HAND_PIE_CRUST_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);

    //Raw Ingredients
    public static final Item.Settings RAW_TACO_BEEF_SETTINGS = new Item.Settings().food(RAW_MEAT_PROPERTIES);
    public static final Item.Settings RAW_TACO_CHICKEN_SETTINGS = new Item.Settings().food(RAW_MEAT_PROPERTIES);
    public static final Item.Settings TORTILLA_DOUGH_SETTINGS = new Item.Settings().food(RAW_INGREDIENT_PROPERTIES);
    public static final Item.Settings CURDS_AND_WHEY_SETTINGS = new Item.Settings().food(RAW_INGREDIENT_PROPERTIES).recipeRemainder(Items.BUCKET).maxCount(16);

    //Cooked Ingredients
    public static final Item.Settings TACO_BEEF_SETTINGS = new Item.Settings().food(MEAT_PROPERTIES);
    public static final Item.Settings TACO_CHICKEN_SETTINGS = new Item.Settings().food(MEAT_PROPERTIES);

    //Unfinished Foods
    public static final Item.Settings UNCOOKED_CHEESE_QUESADILLA_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_CHICKEN_QUESADILLA_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_BEEF_QUESADILLA_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_POTATO_QUESADILLA_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_CHICKEN_CRUNCHWRAP_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_BEEF_CRUNCHWRAP_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_POTATO_CRUNCHWRAP_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings TORTILLA_WITH_CHEESE_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_CHEESY_POTATO_GRILLER_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_CHICKEN_TAQUITO_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_STEAK_TAQUITO_SETTINGS = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Settings UNCOOKED_CARAMEL_APPLE_EMPANADA = new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES);


    //Sides
    public static final Item.Settings NACHOS_SETTINGS = new Item.Settings().food(BuildSideProperties(FillingType.CHEESE)).recipeRemainder(Items.BOWL).maxCount(16);
    public static final Item.Settings CHEESY_FIESTA_POTATOES_SETTINGS = new Item.Settings().food(BuildSideProperties(FillingType.POTATO)).recipeRemainder(Items.BOWL).maxCount(16);
    public static final Item.Settings CARAMEL_APPLE_EMPANADA_SETTINGS = new Item.Settings().food(BuildSideProperties(FillingType.FRUIT));

    //Roll-ups/Taquitos
    public static final Item.Settings CHEESY_ROLL_UP_SETTINGS = new Item.Settings().food(BuildRollupProperties(FillingType.CHEESE));
    public static final Item.Settings CHEESY_POTATO_GRILLER_SETTINGS = new Item.Settings().food(BuildRollupProperties(FillingType.POTATO));
    public static final Item.Settings CHICKEN_TAQUITO_SETTINGS = new Item.Settings().food(BuildRollupProperties(FillingType.CHICKEN));
    public static final Item.Settings STEAK_TAQUITO_SETTINGS = new Item.Settings().food(BuildRollupProperties(FillingType.BEEF));

    //Tacos
    public static final Item.Settings POTATO_TACO_SETTINGS = new Item.Settings().food(BuildTacoProperties(FillingType.POTATO));
    public static final Item.Settings CHICKEN_TACO_SETTINGS = new Item.Settings().food(BuildTacoProperties(FillingType.CHICKEN));
    public static final Item.Settings BEEF_TACO_SETTINGS = new Item.Settings().food(BuildTacoProperties(FillingType.BEEF));

    //Burritos
    public static final Item.Settings POTATO_BURRITO_SETTINGS = new Item.Settings().food(BuildBurritoProperties(FillingType.POTATO));
    public static final Item.Settings CHICKEN_BURRITO_SETTINGS = new Item.Settings().food(BuildBurritoProperties(FillingType.CHICKEN));
    public static final Item.Settings BEEF_BURRITO_SETTINGS = new Item.Settings().food(BuildBurritoProperties(FillingType.BEEF));

    //Quesadillas
    public static final Item.Settings CHEESE_QUESADILLA_SETTINGS = new Item.Settings().food(BuildQuesadillaProperties(FillingType.CHEESE));
    public static final Item.Settings CHICKEN_QUESADILLA_SETTINGS = new Item.Settings().food(BuildQuesadillaProperties(FillingType.CHICKEN));
    public static final Item.Settings BEEF_QUESADILLA_SETTINGS = new Item.Settings().food(BuildQuesadillaProperties(FillingType.BEEF));
    public static final Item.Settings POTATO_QUESADILLA_SETTINGS = new Item.Settings().food(BuildQuesadillaProperties(FillingType.POTATO));

    //Crunchwraps
    public static final Item.Settings CHICKEN_CRUNCHWRAP_SETTINGS = new Item.Settings().food(BuildCrunchwrapProperties(FillingType.CHICKEN));
    public static final Item.Settings BEEF_CRUNCHWRAP_SETTINGS = new Item.Settings().food(BuildCrunchwrapProperties(FillingType.BEEF));
    public static final Item.Settings POTATO_CRUNCHWRAP_SETTINGS = new Item.Settings().food(BuildCrunchwrapProperties(FillingType.POTATO));

    //Baja Be Thy Blast
    public static final Item.Settings BAJA_BLAST_SYRUP_SETTINGS = new Item.Settings().food(SYRUP_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE);
    public static final Item.Settings BAJA_BLAST_SETTINGS = new Item.Settings().food(BAJA_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE);

    //Special Ingredient Properties
    public static final Item.Settings DRIED_CHILI_SETTINGS = new Item.Settings().food(SPICY_INGREDIENT_PROPERTIES);

    //Crops
    public static final Item.Settings LIME_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 500), 0.1F).build());
    public static final Item.Settings HOT_PEPPER_SETTINGS = new Item.Settings().food(SPICY_INGREDIENT_PROPERTIES);
    public static final Item.Settings BLUE_RASPBERRY_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().build());
}
