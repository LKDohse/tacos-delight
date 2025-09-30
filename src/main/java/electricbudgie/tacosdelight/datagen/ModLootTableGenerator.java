package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.custom.HotPepperCropBlock;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LIME_TREE, Items.STICK);
        addDrop(ModBlocks.BLUE_RASPBERRY_BUSH, Items.STICK);
        addDrop(ModBlocks.HALITE, multipleOreDrops(ModBlocks.HALITE, ModItems.ROCK_SALT_CRYSTALS, 4f, 6f));
        addDrop(ModBlocks.BUDDING_HALITE, multipleOreDrops(ModBlocks.BUDDING_HALITE, ModItems.ROCK_SALT_CRYSTALS, 4f, 7f));
        addDrop(ModBlocks.HALITE_CLUSTER, multipleOreDrops(ModBlocks.HALITE_CLUSTER, ModItems.ROCK_SALT_CRYSTALS, 4f, 6f));
        addDrop(ModBlocks.LARGE_HALITE_BUD, multipleOreDrops(ModBlocks.LARGE_HALITE_BUD, ModItems.ROCK_SALT_CRYSTALS, 2f, 4f));
        addDrop(ModBlocks.MEDIUM_HALITE_BUD, multipleOreDrops(ModBlocks.MEDIUM_HALITE_BUD, ModItems.ROCK_SALT_CRYSTALS, 2f, 3f));
        addDrop(ModBlocks.SMALL_HALITE_BUD, multipleOreDrops(ModBlocks.SMALL_HALITE_BUD, ModItems.ROCK_SALT_CRYSTALS, 1f, 2f));
        addDrop(ModBlocks.DEEP_FRYER_BLOCK);

        BlockStatePropertyLootCondition.Builder hotPepperLootConditionBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.HOT_PEPPER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(HotPepperCropBlock.AGE, 5));
        this.addDrop(ModBlocks.HOT_PEPPER_CROP, this.cropDrops(ModBlocks.HOT_PEPPER_CROP, ModItems.HOT_PEPPER, ModItems.HOT_PEPPER_SEEDS, hotPepperLootConditionBuilder));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops){
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder) ItemEntry.builder(item).apply(
                                SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
