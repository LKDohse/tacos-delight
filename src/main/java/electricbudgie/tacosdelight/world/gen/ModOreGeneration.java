package electricbudgie.tacosdelight.world.gen;

import electricbudgie.tacosdelight.world.ModOrePlacement;
import electricbudgie.tacosdelight.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.BEACH,
                        BiomeKeys.OCEAN),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.COASTAL_HALITE);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.SAVANNA,
                        BiomeKeys.SAVANNA_PLATEAU,
                        BiomeKeys.WINDSWEPT_SAVANNA,
                        BiomeKeys.PLAINS),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.UNDERGROUND_PLAINS_HALITE);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.DESERT,
                        BiomeKeys.BADLANDS,
                        BiomeKeys.WOODED_BADLANDS,
                        BiomeKeys.ERODED_BADLANDS),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.UNDERGROUND_DESERT_HALITE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.DEEP_HALITE);




//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
//                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.);
    }
}
