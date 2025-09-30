package electricbudgie.tacosdelight.world.gen;

import electricbudgie.tacosdelight.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModGeodeGeneration {
    public static void generateGeodes(){
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.OCEAN,
                        BiomeKeys.WARM_OCEAN,
                        BiomeKeys.LUKEWARM_OCEAN,
                        BiomeKeys.BEACH),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                ModPlacedFeatures.COASTAL_HALITE_GEODE_PLACED_KEY);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.DESERT,
                        BiomeKeys.BADLANDS,
                        BiomeKeys.ERODED_BADLANDS,
                        BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                ModPlacedFeatures.INLAND_HALITE_GEODE_PLACED_KEY);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS,
                        BiomeKeys.SAVANNA,
                        BiomeKeys.WINDSWEPT_SAVANNA),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                ModPlacedFeatures.LOWLAND_HALITE_GEODE_PLACED_KEY);
    }
}
