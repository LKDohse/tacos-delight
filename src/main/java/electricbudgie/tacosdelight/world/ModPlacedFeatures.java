package electricbudgie.tacosdelight.world;

import electricbudgie.tacosdelight.TacosDelight;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import javax.imageio.spi.RegisterableService;
import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> LIME_TREE_PLACED_KEY = registerKey("lime_tree_placed");
    public static final RegistryKey<PlacedFeature> BLUE_RASPBERRY_BUSH_PLACED_KEY = registerKey("blue_raspberry_bush_placed");
    public static final RegistryKey<PlacedFeature> COASTAL_HALITE_GEODE_PLACED_KEY = registerKey("coastal_halite_geode_placed_key");
    public static final RegistryKey<PlacedFeature> INLAND_HALITE_GEODE_PLACED_KEY = registerKey("inland_halite_geode_placed_key");
    public static final RegistryKey<PlacedFeature> LOWLAND_HALITE_GEODE_PLACED_KEY = registerKey("lowland_halite_geode_placed_key");

    public static final RegistryKey<PlacedFeature> UNDERGROUND_DESERT_HALITE = registerKey("underground_desert_halite");
    public static final RegistryKey<PlacedFeature> UNDERGROUND_PLAINS_HALITE = registerKey("underground_plains_halite");
    public static final RegistryKey<PlacedFeature> COASTAL_HALITE = registerKey("coastal_halite");
    public static final RegistryKey<PlacedFeature> DEEP_HALITE = registerKey("deep_halite");



    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TacosDelight.MOD_ID, name));
    }

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, LIME_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LIME_TREE_KEY),
                RarityFilterPlacementModifier.of(8),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, BLUE_RASPBERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_RASPBERRY_BUSH_KEY),
                RarityFilterPlacementModifier.of(4),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, COASTAL_HALITE_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COASTAL_HALITE_GEODE_KEY),
                RarityFilterPlacementModifier.of(30), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.fixed(40),
                        YOffset.fixed(60)), BiomePlacementModifier.of());

        register(context, INLAND_HALITE_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HALITE_GEODE_KEY),
                RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.fixed(20),
                        YOffset.fixed(40)), BiomePlacementModifier.of());

        register(context, LOWLAND_HALITE_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HALITE_GEODE_KEY),
                RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.fixed(30),
                        YOffset.fixed(50)), BiomePlacementModifier.of());

        register(context, UNDERGROUND_DESERT_HALITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MID_HALITE_VEIN_KEY),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(20), YOffset.fixed(50))));

        register(context, UNDERGROUND_PLAINS_HALITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MID_HALITE_VEIN_KEY),
                ModOrePlacement.modifiersWithCount(6,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.fixed(35))));

        register(context, COASTAL_HALITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SHALLOW_HALITE_VEIN_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(40), YOffset.fixed(60))));

        register(context, DEEP_HALITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEP_HALITE_VEIN_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(20))));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
