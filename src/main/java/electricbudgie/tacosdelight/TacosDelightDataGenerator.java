package electricbudgie.tacosdelight;

import electricbudgie.tacosdelight.datagen.ModBiomeTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

public class TacosDelightDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBiomeTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {

	}
}
