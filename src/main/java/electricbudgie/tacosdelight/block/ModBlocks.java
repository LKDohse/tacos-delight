package electricbudgie.tacosdelight.block;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.custom.BlueRaspberryBushBlock;
import electricbudgie.tacosdelight.block.custom.HotPepperCropBlock;
import electricbudgie.tacosdelight.block.custom.LimeTreeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

   public static final Block BLUE_RASPBERRY_BUSH = registerBlockWithoutBlockItem("blue_raspberry_bush", new BlueRaspberryBushBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
   public static final Block LIME_TREE = registerBlockWithoutBlockItem("lime_tree", new LimeTreeBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
   public static final Block HOT_PEPPER_CROP = registerBlockWithoutBlockItem("hot_pepper_plant", new HotPepperCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TacosDelight.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TacosDelight.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        TacosDelight.LOGGER.info("Registering mod blocks for " + TacosDelight.MOD_ID);
    }
}
