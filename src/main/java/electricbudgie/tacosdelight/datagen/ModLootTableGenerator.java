package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.custom.HotPepperCropBlock;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LIME_TREE, Items.STICK);
        addDrop(ModBlocks.BLUE_RASPBERRY_BUSH, Items.STICK);

        BlockStatePropertyLootCondition.Builder hotPepperLootConditionBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.HOT_PEPPER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(HotPepperCropBlock.AGE, 5));
        this.addDrop(ModBlocks.HOT_PEPPER_CROP, this.cropDrops(ModBlocks.HOT_PEPPER_CROP, ModItems.HOT_PEPPER, ModItems.HOT_PEPPER_SEEDS, hotPepperLootConditionBuilder));
    }
}
