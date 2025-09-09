package electricbudgie.tacosdelight.item;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    //Ingredients
    public static final Item DICED_TOMATOES = registerItem("diced_tomatoes", ModFoodComponents.DICED_TOMATOES);



    //Crops
    public static final Item LIME = registerItem("lime", new AliasedBlockItem(ModBlocks.LIME_TREE, ModFoodComponents.LIME_SETTINGS));
    public static final Item BLUE_RASPBERRY = registerItem("blue_raspberry", new AliasedBlockItem(ModBlocks.BLUE_RASPBERRY_BUSH, ModFoodComponents.BLUE_RASPBERRY_SETTINGS));
    public static final Item HOT_PEPPER_SEEDS = registerItem("hot_pepper_seeds", new AliasedBlockItem(ModBlocks.HOT_PEPPER_CROP, new Item.Settings()));
    public static final Item HOT_PEPPER = registerItem("hot_pepper", new Item(ModFoodComponents.HOT_PEPPER_SETTINGS));

    //Uncategorized
    public static final Item CARDBOARD_TRAY = registerItem("cardboard_tray", new Item(new Item.Settings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TacosDelight.LOGGER.info("Registering Mod Items for " + TacosDelight.MOD_ID);
    }
}
