package electricbudgie.tacosdelight.block;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.custom.*;
import electricbudgie.tacosdelight.components.ModComponents;
import electricbudgie.tacosdelight.item.ModFoodComponents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> CREATIVE_TAB_BLOCKS = new ArrayList<>();

    //Ores
    public static final Block HALITE = registerBasicBlockAndItem("halite", new PillarBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR)));
    public static final Block BUDDING_HALITE = registerBasicBlockAndItem("budding_halite", new BuddingHaliteBlock(AbstractBlock.Settings.create().ticksRandomly().strength(1.5F).requiresTool()));
    public static final Block HALITE_CLUSTER = registerBasicBlockAndItem("halite_cluster", new HaliteClusterBlock(7.0F, 3.0F, AbstractBlock.Settings.create().nonOpaque()));
    public static final Block SMALL_HALITE_BUD = registerBasicBlockAndItem("small_halite_bud", new HaliteClusterBlock(3.0f, 4.0f, AbstractBlock.Settings.copy(ModBlocks.HALITE_CLUSTER).nonOpaque()));
    public static final Block MEDIUM_HALITE_BUD = registerBasicBlockAndItem("medium_halite_bud", new HaliteClusterBlock(4.0f, 4.0f, AbstractBlock.Settings.copy(ModBlocks.HALITE_CLUSTER).nonOpaque()));
    public static final Block LARGE_HALITE_BUD = registerBasicBlockAndItem("large_halite_bud", new HaliteClusterBlock(5.0f, 4.0f, AbstractBlock.Settings.copy(ModBlocks.HALITE_CLUSTER).nonOpaque()));

    //Crops
    public static final Block BLUE_RASPBERRY_BUSH = registerItemlessBlock("blue_raspberry_bush", new BlueRaspberryBushBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block LIME_TREE = registerItemlessBlock("lime_tree", new LimeTreeBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block HOT_PEPPER_CROP = registerItemlessBlock("hot_pepper_plant", new HotPepperCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    //Feast Blocks
    public static final Block BEEF_TACO_BOX_BLOCK = registerBasicBlockAndItem("beef_taco_box", new TacoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.BEEF, true));
    public static final Block CHICKEN_TACO_BOX_BLOCK = registerBasicBlockAndItem("chicken_taco_box", new TacoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.CHICKEN, true));
    public static final Block POTATO_TACO_BOX_BLOCK = registerBasicBlockAndItem("potato_taco_box", new TacoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.POTATO, true));

    public static final Block BEEF_BURRITO_BOX_BLOCK = registerBasicBlockAndItem("beef_burrito_box", new BurritoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.BEEF, true));
    public static final Block CHICKEN_BURRITO_BOX_BLOCK = registerBasicBlockAndItem("chicken_burrito_box", new BurritoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.CHICKEN, true));
    public static final Block POTATO_BURRITO_BOX_BLOCK = registerBasicBlockAndItem("potato_burrito_box", new BurritoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.POTATO, true));

    public static final Block BEEF_CRAVINGS_BLOCK_BOX = registerBasicBlockAndItem("beef_cravings_box", new CravingsBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.BEEF, true));
    public static final Block CHICKEN_CRAVINGS_BLOCK_BOX = registerBasicBlockAndItem("chicken_cravings_box", new CravingsBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.CHICKEN, true));
    public static final Block POTATO_CRAVINGS_BLOCK_BOX = registerBasicBlockAndItem("potato_cravings_box", new CravingsBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.POTATO, true));

    //Entities
    public static final Block DEEP_FRYER_BLOCK = registerCraftingBlock("deep_fryer",
            new DeepFryerBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));
    public static final Block CHEESE_WHEEL_BLOCK = registerAgeComponentBlock("cheese_wheel",
            new CheeseWheelBlock((AbstractBlock.Settings.create().nonOpaque())));
    public static final Block CHEESE_PRESS_BLOCK = registerCraftingBlock("cheese_press",
            new CheesePressBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));

    private static Block registerBasicBlockAndItem(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlock(name, block);
    }

    private static Block registerBlock(String name, Block block){
        var registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(TacosDelight.MOD_ID, name), block);
        CREATIVE_TAB_BLOCKS.add(registeredBlock);
        return registeredBlock;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerAgeComponentBlock(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name),
                new BlockItem(block, new Item.Settings().component(ModComponents.AGE_COMPONENT, -1)));
        return registerBlock(name, block);
    }

    private static Block registerCraftingBlock(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TacosDelight.MOD_ID, name),
                new BlockItem(block, new Item.Settings().maxCount(1)));
        return registerBlock(name, block);
    }
    private static Block registerItemlessBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TacosDelight.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        TacosDelight.LOGGER.info("Registering mod blocks for " + TacosDelight.MOD_ID);
    }
}
