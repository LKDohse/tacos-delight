package electricbudgie.tacosdelight;

import electricbudgie.tacosdelight.datagen.*;
import electricbudgie.tacosdelight.datagen.custom.recipe.CustomFabricRecipeProvider;
import electricbudgie.tacosdelight.world.ModConfiguredFeatures;
import electricbudgie.tacosdelight.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class TacosDelightDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBiomeTagProvider::new);
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModLootTableGenerator::new);
		pack.addProvider(ModRecipeProvider::new
		);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
