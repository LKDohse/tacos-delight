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

    public static StatusEffectInstance GetFillingEffect(FillingType filling, int duration){
        return switch (filling) {
            case BEEF -> new StatusEffectInstance(StatusEffects.STRENGTH, duration);
            case CHICKEN -> new StatusEffectInstance(StatusEffects.HASTE, duration);
            case POTATO -> new StatusEffectInstance(StatusEffects.RESISTANCE, duration);
            case CHEESE -> new StatusEffectInstance(StatusEffects.GLOWING, duration);
        };
    }

    public static FoodComponent BuildQuesadillaProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(10).saturationModifier(12F);
        builder.statusEffect(GetFillingEffect(type, 20), 0.45f);
        return builder.build();
    }

    public static FoodComponent BuildTacoProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(12).saturationModifier(14F);
        builder.statusEffect(GetFillingEffect(type, 30), 0.30F);
        return builder.build();
    }

    public static FoodComponent BuildBurritoProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(14).saturationModifier(16F);
        builder.statusEffect(GetFillingEffect(type, 45), 0.80F);
        return builder.build();
    }

    public static FoodComponent BuildCrunchwrapProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(16).saturationModifier(18F);
        builder.statusEffect(GetFillingEffect(type, 50), 1F);
        return builder.build();
    }

    public static FoodComponent BuildNachoServingProperties(FillingType type){
        var builder = new FoodComponent.Builder().nutrition(10).saturationModifier(10F);
        builder.statusEffect(GetFillingEffect(type, 50), 0.30F);
        return builder.build();
    }

    public static final FoodComponent BASIC_INGREDIENT_PROPERTIES = new FoodComponent.Builder().nutrition(1).snack().build();
    public static final FoodComponent RAW_INGREDIENT_PROPERTIES = new FoodComponent.Builder().nutrition(2).saturationModifier(1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA), 0.03F).build();
    public static final FoodComponent RAW_MEAT_PROPERTIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA), 0.07F).build();
    public static final FoodComponent MEAT_PROPERTIES = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F).build();
    public static final FoodComponent UNFINISHED_FOOD_PROPERTIES = new FoodComponent.Builder().nutrition(3).saturationModifier(1.2F).build();

    //Basic Ingredients
    public static final Item DICED_TOMATOES =  new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item DRIED_CHILI = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item DRIED_ONION = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item FLOUR_TORTILLA = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item NACHO_CHEESE = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16));
    public static final Item SHREDDED_CHEESE_PROPERTIES = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item DICED_POTATO = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item SOUR_CREAM = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16));
    public static final Item RAW_TORTILLA_CHIPS = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item UNCOOKED_FIESTA_POTATOES = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item FRIED_FIESTA_POTATOES = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES));
    public static final Item TACO_SEASONING = new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS), 0.03F).build()));

    //Raw Ingredients
    public static final Item RAW_TACO_BEEF = new Item(new Item.Settings().food(RAW_MEAT_PROPERTIES));
    public static final Item RAW_TACO_CHICKEN = new Item(new Item.Settings().food(RAW_MEAT_PROPERTIES));
    public static final Item TORTILLA_DOUGH = new Item(new Item.Settings().food(RAW_INGREDIENT_PROPERTIES));

    //Cooked Ingredients
    public static final Item TACO_BEEF = new Item(new Item.Settings().food(MEAT_PROPERTIES));
    public static final Item TACO_CHICKEN = new Item(new Item.Settings().food(MEAT_PROPERTIES));

    //Unfinished Foods
    public static final Item UNCOOKED_CHEESE_QUESADILLA = new Item(new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES));
    public static final Item UNCOOKED_CHICKEN_QUESADILLA = new Item(new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES));
    public static final Item UNCOOKED_BEEF_QUESADILLA = new Item(new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES));
    public static final Item UNCOOKED_CHICKEN_CRUNCHWRAP = new Item(new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES));
    public static final Item UNCOOKED_BEEF_CRUNCHWRAP = new Item(new Item.Settings().food(UNFINISHED_FOOD_PROPERTIES));

    //Sides
    public static final Item NACHOS = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.BOWL).maxCount(16));
    public static final Item CHEESY_FIESTA_POTATOES = new Item(new Item.Settings().food(BASIC_INGREDIENT_PROPERTIES).recipeRemainder(Items.BOWL).maxCount(16));

    //Special Nachos
    public static final Item NACHO_PLATTER_SERVING = new Item(new Item.Settings().food(BuildNachoServingProperties(FillingType.CHEESE)).recipeRemainder(Items.BOWL).maxCount(4));

    //Tacos
    public static final Item POTATO_TACO = new Item(new Item.Settings().food(BuildTacoProperties(FillingType.POTATO)));
    public static final Item CHICKEN_TACO = new Item(new Item.Settings().food(BuildTacoProperties(FillingType.CHICKEN)));
    public static final Item BEEF_TACO = new Item(new Item.Settings().food(BuildTacoProperties(FillingType.BEEF)));

    //Burritos
    public static final Item POTATO_BURRITO = new Item(new Item.Settings().food(BuildBurritoProperties(FillingType.POTATO)));
    public static final Item CHICKEN_BURRITO = new Item(new Item.Settings().food(BuildBurritoProperties(FillingType.CHICKEN)));
    public static final Item BEEF_BURRITO = new Item(new Item.Settings().food(BuildBurritoProperties(FillingType.BEEF)));

    //Quesadillas
    public static final Item CHEESE_QUESADILLA = new Item(new Item.Settings().food(BuildQuesadillaProperties(FillingType.CHEESE)));
    public static final Item CHICKEN_QUESADILLA = new Item(new Item.Settings().food(BuildQuesadillaProperties(FillingType.CHICKEN)));
    public static final Item BEEF_QUESADILLA = new Item(new Item.Settings().food(BuildQuesadillaProperties(FillingType.BEEF)));

    //Crunchwraps
    public static final Item CHICKEN_CRUNCHWRAP = new Item(new Item.Settings().food(BuildCrunchwrapProperties(FillingType.CHICKEN)));
    public static final Item BEEF_CRUNCHWRAP = new Item(new Item.Settings().food(BuildCrunchwrapProperties(FillingType.BEEF)));

    //Taco Boxes
    public static final Item BEEF_TACO_BOX = new Item(new Item.Settings());
    public static final Item CHICKEN_TACO_BOX = new Item(new Item.Settings());
    public static final Item POTATO_TACO_BOX = new Item(new Item.Settings());

    //Burrito Boxes
    public static final Item POTATO_BURRITO_BOX = new Item(new Item.Settings());
    public static final Item CHICKEN_BURRITO_BOX = new Item(new Item.Settings());
    public static final Item BEEF_BURRITO_BOX = new Item(new Item.Settings());

    // Cravings Boxes
    public static final Item POTATO_CRAVINGS_BOX = new Item(new Item.Settings());
    public static final Item CHICKEN_CRAVINGS_BOX = new Item(new Item.Settings());
    public static final Item BEEF_CRAVINGS_BOX = new Item(new Item.Settings());

    //Nacho Platters
    public static final Item CHEESY_NACHO_PLATTER = new Item(new Item.Settings());

    //Crops
    public static final Item.Settings LIME_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.WITHER), 0.1F).build());
    public static final Item.Settings HOT_PEPPER_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE), 0.1F).build());
    public static final Item.Settings BLUE_RASPBERRY_SETTINGS = new Item.Settings().food(new FoodComponent.Builder().nutrition(1).snack().build());
}
