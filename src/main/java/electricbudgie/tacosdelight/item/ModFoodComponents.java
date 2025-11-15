package electricbudgie.tacosdelight.item;

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
        CHEESE
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
        };
    }

    public static FoodComponent BuildQuesadillaProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(10).saturationModifier(12F);
        builder.statusEffect(GetFillingEffect(type, 20), 0.45f);
        return builder.build();
    }

    public static FoodComponent BuildTacoProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(12).saturationModifier(14F);
        builder.statusEffect(GetFillingEffect(type, 25), 0.30F);
        return builder.build();
    }

    public static FoodComponent BuildBurritoProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(14).saturationModifier(16F);
        builder.statusEffect(GetFillingEffect(type, 30), 0.80F);
        return builder.build();
    }

    public static FoodComponent BuildCrunchwrapProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(16).saturationModifier(18F);
        builder.statusEffect(GetFillingEffect(type, 35), 1F);
        return builder.build();
    }

    public static FoodComponent BuildNachoServingProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(10).saturationModifier(10F);
        builder.statusEffect(GetFillingEffect(type, 20), 0.30F);
        return builder.build();
    }

    public static final FoodComponent BASIC_INGREDIENT_PROPERTIES = new FoodComponent.Builder().nutrition(1).snack().build();
    public static final FoodComponent RAW_INGREDIENT_PROPERTIES = new FoodComponent.Builder().nutrition(2).saturationModifier(1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA), 0.03F).build();
    public static final FoodComponent RAW_MEAT_PROPERTIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA), 0.07F).build();
    public static final FoodComponent MEAT_PROPERTIES = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F).build();
    public static final FoodComponent UNFINISHED_FOOD_PROPERTIES = new FoodComponent.Builder().nutrition(3).saturationModifier(1.2F).build();

    //Basic Ingredients
    public static final Item.Settings DICED_TOMATOES_SETTINGS =  new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings DRIED_CHILI_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings DRIED_ONION_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings FLOUR_TORTILLA_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings NACHO_CHEESE_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16);
    public static final Item.Settings SHREDDED_CHEESE_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings DICED_POTATO_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings SOUR_CREAM_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16);
    public static final Item.Settings RAW_TORTILLA_CHIPS_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings UNCOOKED_FIESTA_POTATOES_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings FRIED_FIESTA_POTATOES_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings TACO_SEASONING_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS), 0.03F).build());
    public static final Item.Settings TORTILLA_CHIPS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings FLOUR_TOSTADA = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings SALT = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Settings CHEESE_WEDGE = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES);

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

    //Sides
    public static final Item.Settings NACHOS_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.BOWL).maxCount(16);
    public static final Item.Settings CHEESY_FIESTA_POTATOES_SETTINGS = new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.BOWL).maxCount(16);

    //Special Nachos
    public static final Item.Settings CHEESY_NACHO_PLATTER_SERVING_SETTINGS = new Item.Settings().food(BuildNachoServingProperties(FillingType.CHEESE)).recipeRemainder(Items.BOWL).maxCount(4);
    public static final Item.Settings CHICKEN_NACHO_PLATTER_SERVING_SETTINGS = new Item.Settings().food(BuildNachoServingProperties(FillingType.CHICKEN)).recipeRemainder(Items.BOWL).maxCount(4);
    public static final Item.Settings BEEF_NACHO_PLATTER_SERVING_SETTINGS = new Item.Settings().food(BuildNachoServingProperties(FillingType.BEEF)).recipeRemainder(Items.BOWL).maxCount(4);

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

    //Crops
    public static final Item.Settings LIME_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.WITHER), 0.1F).build());
    public static final Item.Settings HOT_PEPPER_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE), 0.1F).build());
    public static final Item.Settings BLUE_RASPBERRY_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().build());
}
