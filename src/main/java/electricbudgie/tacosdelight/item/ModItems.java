package electricbudgie.tacosdelight.item;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> CREATIVE_MODE_TAB = new ArrayList<>();

    //Ores and Ore-related Items
    public static final Item SALT = registerItemViaSettings("salt", ModFoodComponents.SALT);
    public static final Item ROCK_SALT_CRYSTALS = registerItem("rock_salt_crystals", new Item(new Item.Settings()));

    //Basic Ingredients
    public static final Item DICED_TOMATOES = registerItemViaSettings("diced_tomatoes", ModFoodComponents.DICED_TOMATOES_SETTINGS);
    public static final Item DRIED_CHILI = registerItemViaSettings("dried_chili", ModFoodComponents.DRIED_CHILI_SETTINGS);
    public static final Item DRIED_ONION = registerItemViaSettings("dried_onion", ModFoodComponents.DRIED_ONION_SETTINGS);
    public static final Item FLOUR_TORTILLA = registerItemViaSettings("flour_tortilla", ModFoodComponents.FLOUR_TORTILLA_SETTINGS);
    public static final Item NACHO_CHEESE = registerItemViaSettings("nacho_cheese", ModFoodComponents.NACHO_CHEESE_SETTINGS);
    public static final Item SHREDDED_CHEESE = registerItemViaSettings("shredded_cheese", ModFoodComponents.SHREDDED_CHEESE_SETTINGS);
    public static final Item DICED_POTATO = registerItemViaSettings("diced_potato", ModFoodComponents.DICED_POTATO_SETTINGS);
    public static final Item SOUR_CREAM = registerItemViaSettings("sour_cream", ModFoodComponents.SOUR_CREAM_SETTINGS);
    public static final Item RAW_TORTILLA_CHIPS = registerItemViaSettings("raw_tortilla_chips", ModFoodComponents.RAW_TORTILLA_CHIPS_SETTINGS);
    public static final Item UNCOOKED_FIESTA_POTATOES = registerItemViaSettings("uncooked_fiesta_potatoes", ModFoodComponents.UNCOOKED_FIESTA_POTATOES_SETTINGS);
    public static final Item FRIED_FIESTA_POTATOES = registerItemViaSettings("fried_fiesta_potatoes", ModFoodComponents.FRIED_FIESTA_POTATOES_SETTINGS);
    public static final Item TACO_SEASONING = registerItemViaSettings("taco_seasoning", ModFoodComponents.TACO_SEASONING_SETTINGS);
    public static final Item TORTILLA_CHIPS = registerItemViaSettings("tortilla_chips", ModFoodComponents.TORTILLA_CHIPS);
    public static final Item FLOUR_TOSTADA = registerItemViaSettings("flour_tostada", ModFoodComponents.FLOUR_TOSTADA);
    public static final Item CHEESE_WEDGE = registerItemViaSettings("cheese_wedge", ModFoodComponents.CHEESE_WEDGE);
    public static final Item HAND_PIE_CRUST = registerItemViaSettings("hand_pie_crust", ModFoodComponents.HAND_PIE_CRUST_SETTINGS);

    //Raw Ingredients
    public static final Item RAW_TACO_BEEF = registerItemViaSettings("raw_taco_beef", ModFoodComponents.RAW_TACO_BEEF_SETTINGS);
    public static final Item RAW_TACO_CHICKEN = registerItemViaSettings("raw_taco_chicken", ModFoodComponents.RAW_TACO_CHICKEN_SETTINGS);
    public static final Item TORTILLA_DOUGH = registerItemViaSettings("tortilla_dough", ModFoodComponents.TORTILLA_DOUGH_SETTINGS);
    public static final Item CURDS_AND_WHEY = registerItemViaSettings("curds_and_whey", ModFoodComponents.CURDS_AND_WHEY_SETTINGS);

    //Cooked Ingredients
    public static final Item TACO_BEEF = registerItemViaSettings("taco_beef", ModFoodComponents.TACO_BEEF_SETTINGS);
    public static final Item TACO_CHICKEN = registerItemViaSettings("taco_chicken", ModFoodComponents.TACO_CHICKEN_SETTINGS);

    //Unfinished Foods
    public static final Item UNCOOKED_CHEESE_QUESADILLA = registerItemViaSettings("uncooked_cheese_quesadilla", ModFoodComponents.UNCOOKED_CHEESE_QUESADILLA_SETTINGS);
    public static final Item UNCOOKED_CHICKEN_QUESADILLA = registerItemViaSettings("uncooked_chicken_quesadilla", ModFoodComponents.UNCOOKED_CHICKEN_QUESADILLA_SETTINGS);
    public static final Item UNCOOKED_BEEF_QUESADILLA = registerItemViaSettings("uncooked_beef_quesadilla", ModFoodComponents.UNCOOKED_BEEF_QUESADILLA_SETTINGS);
    public static final Item UNCOOKED_POTATO_QUESADILLA = registerItemViaSettings("uncooked_potato_quesadilla", ModFoodComponents.UNCOOKED_POTATO_QUESADILLA_SETTINGS);
    public static final Item UNCOOKED_CHICKEN_CRUNCHWRAP = registerItemViaSettings("uncooked_chicken_crunchwrap", ModFoodComponents.UNCOOKED_CHICKEN_CRUNCHWRAP_SETTINGS);
    public static final Item UNCOOKED_BEEF_CRUNCHWRAP = registerItemViaSettings("uncooked_beef_crunchwrap", ModFoodComponents.UNCOOKED_BEEF_CRUNCHWRAP_SETTINGS);
    public static final Item UNCOOKED_POTATO_CRUNCHWRAP = registerItemViaSettings("uncooked_potato_crunchwrap", ModFoodComponents.UNCOOKED_POTATO_CRUNCHWRAP_SETTINGS);
    public static final Item TORTILLA_WITH_CHEESE= registerItemViaSettings("tortilla_with_cheese", ModFoodComponents.TORTILLA_WITH_CHEESE_SETTINGS);
    public static final Item UNCOOKED_CHEESY_POTATO_GRILLER= registerItemViaSettings("uncooked_cheesy_potato_griller", ModFoodComponents.UNCOOKED_CHEESY_POTATO_GRILLER_SETTINGS);
    public static final Item UNCOOKED_CHICKEN_TAQUITO = registerItemViaSettings("uncooked_chicken_taquito", ModFoodComponents.UNCOOKED_CHICKEN_TAQUITO_SETTINGS);
    public static final Item UNCOOKED_STEAK_TAQUITO = registerItemViaSettings("uncooked_steak_taquito", ModFoodComponents.UNCOOKED_STEAK_TAQUITO_SETTINGS);
    public static final Item UNCOOKED_CARAMEL_APPLE_EMPANADA = registerItemViaSettings("uncooked_caramel_apple_empanada", ModFoodComponents.UNCOOKED_CARAMEL_APPLE_EMPANADA);

    //Sides
    public static final Item NACHOS = registerItemViaSettings("nachos", ModFoodComponents.NACHOS_SETTINGS);
    public static final Item CHEESY_FIESTA_POTATOES = registerItemViaSettings("cheesy_fiesta_potatoes", ModFoodComponents.CHEESY_FIESTA_POTATOES_SETTINGS);
    public static final Item CARAMEL_APPLE_EMPANADA = registerItemViaSettings("caramel_apple_empanada", ModFoodComponents.CARAMEL_APPLE_EMPANADA_SETTINGS);

    //Roll-Ups
    public static final Item CHEESY_ROLL_UP = registerItemViaSettings("cheesy_roll_up", ModFoodComponents.CHEESY_ROLL_UP_SETTINGS);
    public static final Item CHEESY_POTATO_GRILLER = registerItemViaSettings("cheesy_potato_griller", ModFoodComponents.CHEESY_POTATO_GRILLER_SETTINGS);
    public static final Item CHICKEN_TAQUITO = registerItemViaSettings("chicken_taquito", ModFoodComponents.CHICKEN_TAQUITO_SETTINGS);
    public static final Item STEAK_TAQUITO = registerItemViaSettings("steak_taquito", ModFoodComponents.STEAK_TAQUITO_SETTINGS);

    //Tacos
    public static final Item POTATO_TACO = registerItemViaSettings("potato_taco", ModFoodComponents.POTATO_TACO_SETTINGS);
    public static final Item CHICKEN_TACO = registerItemViaSettings("chicken_taco", ModFoodComponents.CHICKEN_TACO_SETTINGS);
    public static final Item BEEF_TACO = registerItemViaSettings("beef_taco", ModFoodComponents.BEEF_TACO_SETTINGS);

    //Burritos
    public static final Item POTATO_BURRITO = registerItemViaSettings("potato_burrito", ModFoodComponents.POTATO_BURRITO_SETTINGS);
    public static final Item CHICKEN_BURRITO = registerItemViaSettings("chicken_burrito", ModFoodComponents.CHICKEN_BURRITO_SETTINGS);
    public static final Item BEEF_BURRITO = registerItemViaSettings("beef_burrito", ModFoodComponents.BEEF_BURRITO_SETTINGS);

    //Quesadillas
    public static final Item CHEESE_QUESADILLA = registerItemViaSettings("cheese_quesadilla", ModFoodComponents.CHEESE_QUESADILLA_SETTINGS);
    public static final Item CHICKEN_QUESADILLA = registerItemViaSettings("chicken_quesadilla", ModFoodComponents.CHICKEN_QUESADILLA_SETTINGS);
    public static final Item BEEF_QUESADILLA = registerItemViaSettings("beef_quesadilla", ModFoodComponents.BEEF_QUESADILLA_SETTINGS);
    public static final Item POTATO_QUESADILLA = registerItemViaSettings("potato_quesadilla", ModFoodComponents.POTATO_QUESADILLA_SETTINGS);

    //Crunchwraps
    public static final Item CHICKEN_CRUNCHWRAP = registerItemViaSettings("chicken_crunchwrap", ModFoodComponents.CHICKEN_CRUNCHWRAP_SETTINGS);
    public static final Item BEEF_CRUNCHWRAP = registerItemViaSettings("beef_crunchwrap", ModFoodComponents.BEEF_CRUNCHWRAP_SETTINGS);
    public static final Item POTATO_CRUNCHWRAP = registerItemViaSettings("potato_crunchwrap", ModFoodComponents.POTATO_CRUNCHWRAP_SETTINGS);

    //Crops
    public static final Item LIME = registerItem("lime", new AliasedBlockItem(ModBlocks.LIME_TREE, ModFoodComponents.LIME_SETTINGS));
    public static final Item BLUE_RASPBERRY = registerItem("blue_raspberry", new AliasedBlockItem(ModBlocks.BLUE_RASPBERRY_BUSH, ModFoodComponents.BLUE_RASPBERRY_SETTINGS));
    public static final Item HOT_PEPPER_SEEDS = registerItem("hot_pepper_seeds", new AliasedBlockItem(ModBlocks.HOT_PEPPER_CROP, new Item.Settings()));
    public static final Item HOT_PEPPER = registerItem("hot_pepper", new Item(ModFoodComponents.HOT_PEPPER_SETTINGS));

    //Drinks
    public static final Item BAJA_BLAST_SYRUP = registerItem("baja_blast_syrup", new DrinkableItem(ModFoodComponents.BAJA_BLAST_SYRUP_SETTINGS));
    public static final Item BAJA_BLAST = registerItem("baja_blast", new DrinkableItem(ModFoodComponents.BAJA_BLAST_SETTINGS));

    //Uncategorized
    public static final Item CARDBOARD_TRAY = registerItem("cardboard_tray", new Item(new Item.Settings()));

    public static Item registerItemViaSettings(String name, Item.Settings settings){
        var item = Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name), new Item(settings));
        CREATIVE_MODE_TAB.add(item);
        return item;
    }

    public static Item registerItem(String name, Item item) {
        var registeredItem = Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name), item);
        CREATIVE_MODE_TAB.add(registeredItem);
        return registeredItem;
    }

    public static void registerModItems() {
        TacosDelight.LOGGER.info("Registering Mod Items for " + TacosDelight.MOD_ID);
    }
}
