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
        //Blocks
        blockStateModelGenerator.registerLog(ModBlocks.HALITE).log(ModBlocks.HALITE);

        //Crops
        blockStateModelGenerator.registerCrop(ModBlocks.BLUE_RASPBERRY_BUSH, BlueRaspberryBushBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerCrop(ModBlocks.HOT_PEPPER_CROP, HotPepperCropBlock.AGE, 0,1,2,3,4,5);
        registerTallPlant(blockStateModelGenerator, ModBlocks.LIME_TREE, LimeTreeBlock.AGE);
    }



    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerFoodModels(itemModelGenerator);
        itemModelGenerator.register(ModItems.CARDBOARD_TRAY, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHEESE_PRESS_BLOCK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DEEP_FRYER_BLOCK.asItem(), Models.GENERATED);
    }

    private static void registerFoodModels(ItemModelGenerator itemModelGenerator) {

        // Basic Ingredients
        itemModelGenerator.register(ModItems.HOT_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.DICED_TOMATOES, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIED_CHILI, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIED_ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR_TORTILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.NACHO_CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHREDDED_CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DICED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUR_CREAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TORTILLA_CHIPS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_FIESTA_POTATOES, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_FIESTA_POTATOES, Models.GENERATED);
        itemModelGenerator.register(ModItems.TACO_SEASONING, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCK_SALT_CRYSTALS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TORTILLA_CHIPS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR_TOSTADA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_WEDGE, Models.GENERATED);

        // Raw Ingredients
        itemModelGenerator.register(ModItems.RAW_TACO_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TACO_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TORTILLA_DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURDS_AND_WHEY, Models.GENERATED);

        //Cooked Ingredients
        itemModelGenerator.register(ModItems.TACO_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.TACO_CHICKEN, Models.GENERATED);

        //Unfinished Foods
        itemModelGenerator.register(ModItems.UNCOOKED_CHEESE_QUESADILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_CHICKEN_QUESADILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_BEEF_QUESADILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_POTATO_QUESADILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_CHICKEN_CRUNCHWRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_BEEF_CRUNCHWRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_POTATO_CRUNCHWRAP, Models.GENERATED);

        //Sides
        itemModelGenerator.register(ModItems.NACHOS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESY_FIESTA_POTATOES, Models.GENERATED);

        //Special Nachos
        itemModelGenerator.register(ModItems.CHEESY_NACHO_PLATTER_SERVING, Models.GENERATED);

        //Tacos
        itemModelGenerator.register(ModItems.POTATO_TACO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_TACO, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_TACO, Models.GENERATED);

        //Burritos
        itemModelGenerator.register(ModItems.POTATO_BURRITO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_BURRITO, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_BURRITO, Models.GENERATED);

        //Quesadillas
        itemModelGenerator.register(ModItems.CHEESE_QUESADILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_QUESADILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_QUESADILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTATO_QUESADILLA, Models.GENERATED);

        //Crunchwraps
        itemModelGenerator.register(ModItems.CHICKEN_CRUNCHWRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_CRUNCHWRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTATO_CRUNCHWRAP, Models.GENERATED);


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
