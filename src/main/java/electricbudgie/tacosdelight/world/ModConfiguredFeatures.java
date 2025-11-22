package electricbudgie.tacosdelight.world;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.custom.BlueRaspberryBushBlock;
import electricbudgie.tacosdelight.block.custom.LimeTreeBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIME_TREE_KEY = registerKey("lime_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_RASPBERRY_BUSH_KEY = registerKey("blue_raspberry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_HOT_PEPPER_KEY = registerKey("wild_hot_pepper");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHALLOW_HALITE_VEIN_KEY = registerKey("shallow_halite_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MID_HALITE_VEIN_KEY = registerKey("mid_halite_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEP_HALITE_VEIN_KEY = registerKey("deep_halite_vein");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HALITE_GEODE_KEY = registerKey("halite_geode");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COASTAL_HALITE_GEODE_KEY = registerKey("coastal_halite_geode");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, LIME_TREE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(1, 1, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(
                        ModBlocks.LIME_TREE.getDefaultState()
                                .with(LimeTreeBlock.AGE, LimeTreeBlock.ADULT_AGE)
                )))));

        register(context, BLUE_RASPBERRY_BUSH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(10, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(
                        ModBlocks.BLUE_RASPBERRY_BUSH.getDefaultState()
                                .with(BlueRaspberryBushBlock.AGE, BlueRaspberryBushBlock.MAX_AGE))))));

        register(context, WILD_HOT_PEPPER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(5, 4, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_HOT_PEPPERS)))));

        register(context, COASTAL_HALITE_GEODE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(
                        new GeodeLayerConfig(
                                BlockStateProvider.of(Blocks.AIR),
                                BlockStateProvider.of(ModBlocks.HALITE),
                                BlockStateProvider.of(ModBlocks.HALITE),
                                BlockStateProvider.of(Blocks.CALCITE),
                                BlockStateProvider.of(Blocks.SANDSTONE),
                                List.of(
                                        ModBlocks.HALITE.getDefaultState()
                                ),
                                BlockTags.FEATURES_CANNOT_REPLACE,
                                BlockTags.GEODE_INVALID_BLOCKS
                        ),
                        new GeodeLayerThicknessConfig(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackConfig(0.95, 2.0, 2),
                        0.35,
                        0.083,
                        true,
                        UniformIntProvider.create(4, 6),
                        UniformIntProvider.create(3, 4),
                        UniformIntProvider.create(1, 2),
                        -16,
                        16,
                        0.05,
                        1
                ));

        register(context, HALITE_GEODE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(
                        new GeodeLayerConfig(
                                BlockStateProvider.of(Blocks.AIR),
                                BlockStateProvider.of(ModBlocks.HALITE),
                                BlockStateProvider.of(ModBlocks.HALITE),
                                BlockStateProvider.of(Blocks.CALCITE),
                                BlockStateProvider.of(Blocks.SMOOTH_BASALT),
                                List.of(
                                        ModBlocks.HALITE.getDefaultState()
                                ),
                                BlockTags.FEATURES_CANNOT_REPLACE,
                                BlockTags.GEODE_INVALID_BLOCKS
                        ),
                        new GeodeLayerThicknessConfig(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackConfig(0.95, 2.0, 2),
                        0.35,
                        0.083,
                        true,
                        UniformIntProvider.create(4, 6),
                        UniformIntProvider.create(3, 4),
                        UniformIntProvider.create(1, 2),
                        -16,
                        16,
                        0.05,
                        1
                ));

    RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    List<OreFeatureConfig.Target> overworldHaliteBlocks =
            List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.HALITE.getDefaultState()));

        register(context, SHALLOW_HALITE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(overworldHaliteBlocks, 12));
        register(context, MID_HALITE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(overworldHaliteBlocks, 8));
        register(context, DEEP_HALITE_VEIN_KEY, Feature.ORE, new OreFeatureConfig(overworldHaliteBlocks, 4));
}

public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TacosDelight.MOD_ID, name));
}

private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                               RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
}
}
