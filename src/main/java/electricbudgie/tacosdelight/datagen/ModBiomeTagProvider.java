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
                .add(BiomeKeys.GROVE)
                .add(BiomeKeys.SNOWY_TAIGA)
                .add(BiomeKeys.SNOWY_BEACH)
                .add(BiomeKeys.SNOWY_PLAINS)
                .add(BiomeKeys.SNOWY_SLOPES);

        getOrCreateTagBuilder(ModTags.IS_WARM)
                .add(BiomeKeys.DESERT)
                .add(BiomeKeys.JUNGLE)
                .add(BiomeKeys.BAMBOO_JUNGLE)
                .add(BiomeKeys.SPARSE_JUNGLE)
                .add(BiomeKeys.SAVANNA)
                .add(BiomeKeys.WINDSWEPT_SAVANNA)
                .add(BiomeKeys.SAVANNA_PLATEAU)
                .add(BiomeKeys.BADLANDS)
                .add(BiomeKeys.ERODED_BADLANDS)
                .add(BiomeKeys.WOODED_BADLANDS)
                .add(BiomeKeys.SWAMP)
                .add(BiomeKeys.MANGROVE_SWAMP)
                .add(BiomeKeys.MUSHROOM_FIELDS)
                .add(BiomeKeys.STONY_PEAKS)
                .add(BiomeKeys.PLAINS)
                .add(BiomeKeys.SUNFLOWER_PLAINS)
                .add(BiomeKeys.BEACH);

        getOrCreateTagBuilder(ModTags.IS_COOL)
                .add(BiomeKeys.SNOWY_TAIGA)
                .add(BiomeKeys.SNOWY_BEACH)
                .add(BiomeKeys.SNOWY_PLAINS)
                .add(BiomeKeys.SNOWY_SLOPES)
                .add(BiomeKeys.FROZEN_RIVER)
                .add(BiomeKeys.FROZEN_PEAKS)
                .add(BiomeKeys.FROZEN_OCEAN)
                .add(BiomeKeys.DEEP_FROZEN_OCEAN)
                .add(BiomeKeys.GROVE)
                .add(BiomeKeys.ICE_SPIKES)
                .add(BiomeKeys.WINDSWEPT_FOREST)
                .add(BiomeKeys.WINDSWEPT_HILLS)
                .add(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS)
                .add(BiomeKeys.STONY_SHORE)
                .add(BiomeKeys.OLD_GROWTH_PINE_TAIGA)
                .add(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA)
                .add(BiomeKeys.TAIGA);


    }
}
