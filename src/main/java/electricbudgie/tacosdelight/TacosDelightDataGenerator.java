package electricbudgie.tacosdelight;

import electricbudgie.tacosdelight.datagen.*;
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
		var blockTag = pack.addProvider((output, future) -> {
            return new ModBlockTagProvider(output, future);
		});
		pack.addProvider((output, future) -> new ModItemTagProvider(output, future, blockTag));
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
