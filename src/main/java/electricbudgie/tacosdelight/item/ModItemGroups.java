package electricbudgie.tacosdelight.item;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TACOS_DELIGHT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TacosDelight.MOD_ID, "tacos-delight"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.tacosdelight"))
                    .icon(() -> new ItemStack(ModItems.LIME)).entries((displayContext, entries)->{
                        entries.add(ModItems.LIME);
                        entries.add(ModItems.BLUE_RASPBERRY);
                        entries.add(ModItems.HOT_PEPPER);
                        entries.add(ModItems.HOT_PEPPER_SEEDS);
                        entries.add(ModBlocks.DEEP_FRYER_BLOCK);
    }).build());

    public static void registerItemGroups(){
        TacosDelight.LOGGER.info("Registering Item Groups for " + TacosDelight.MOD_ID);
    }
}
