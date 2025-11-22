package electricbudgie.tacosdelight.world.gen;

import electricbudgie.tacosdelight.tags.ModTags;
import electricbudgie.tacosdelight.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModVegetalGeneration {
    public static void generateVegetation(){
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_TROPICAL),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_HOT_PEPPER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_TROPICAL),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LIME_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_SNOWY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_RASPBERRY_BUSH_PLACED_KEY);

    }
}
