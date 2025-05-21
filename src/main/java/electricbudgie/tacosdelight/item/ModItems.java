package electricbudgie.tacosdelight.item;

import electricbudgie.tacosdelight.TacosDelight;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LIME = registerItem("lime", new Item(new Item.Settings()));
    public static final Item BLUE_RASPBERRY = registerItem("blue_raspberry", new Item(new Item.Settings()));


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TacosDelight.LOGGER.info("Registering Mod Items for " + TacosDelight.MOD_ID);
    }
}
