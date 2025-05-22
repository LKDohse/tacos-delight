package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.custom.BlueRaspberryBushBlock;
import electricbudgie.tacosdelight.block.custom.HotPepperCropBlock;
import electricbudgie.tacosdelight.block.custom.LimeTreeBlock;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.BLUE_RASPBERRY_BUSH, BlueRaspberryBushBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerCrop(ModBlocks.HOT_PEPPER_CROP, HotPepperCropBlock.AGE, 0,1,2,3,4,5);
        registerTallPlant(blockStateModelGenerator, ModBlocks.LIME_TREE, LimeTreeBlock.AGE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.HOT_PEPPER, Models.GENERATED);
    }

    public final void registerTallPlant(BlockStateModelGenerator generator, Block plant, Property<Integer> ageProperty) {
        generator.registerItemModel(plant.asItem());
        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty, Properties.DOUBLE_BLOCK_HALF).register((age, half) -> {
            return switch (half) {
                case UPPER ->
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(plant,"_age" +age + "_upper"));
                case LOWER ->
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(plant, "_age" +age + "_lower"));
            };
        });
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(plant).coordinate(blockStateVariantMap));
        ageProperty.getValues().stream()
                        .flatMap(age -> Properties.DOUBLE_BLOCK_HALF.getValues().stream()
                                .map(half -> Map.entry(age, half)))
                                .forEach(entry -> {
                                    Integer age = entry.getKey();
                                    DoubleBlockHalf half = entry.getValue();
                                    generator.createSubModel(
                                            plant,
                                            "_age" + age + "_" + half.name().toLowerCase(),
                                            Models.CROSS,
                                            TextureMap::cross
                                    );
                                });
    }
}
