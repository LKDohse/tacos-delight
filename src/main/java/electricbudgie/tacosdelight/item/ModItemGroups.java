package electricbudgie.tacosdelight.item;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
                       for (Item item : ModItems.CREATIVE_MODE_TAB){
                           entries.add(item);
                       }
                       for (Block block: ModBlocks.CREATIVE_TAB_BLOCKS){
                           entries.add(block);
                       }
    }).build());

    public static void registerItemGroups(){
        TacosDelight.LOGGER.info("Registering Item Groups for " + TacosDelight.MOD_ID);
    }
}
