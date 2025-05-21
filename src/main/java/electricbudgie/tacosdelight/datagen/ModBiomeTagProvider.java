package electricbudgie.tacosdelight.datagen;
import electricbudgie.tacosdelight.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome> {
    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.IS_TROPICAL)
                .add(BiomeKeys.DESERT)
                .add(BiomeKeys.JUNGLE)
                .add(BiomeKeys.BAMBOO_JUNGLE)
                .add(BiomeKeys.SPARSE_JUNGLE);

        getOrCreateTagBuilder(ModTags.IS_SNOWY)
                .add(BiomeKeys.SNOWY_TAIGA)
                .add(BiomeKeys.SNOWY_BEACH)
                .add(BiomeKeys.SNOWY_PLAINS)
                .add(BiomeKeys.SNOWY_SLOPES);
    }
}
