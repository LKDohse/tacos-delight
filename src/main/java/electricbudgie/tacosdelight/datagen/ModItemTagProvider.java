package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public static final TagKey<Item> LEAFY_GREENS = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "leafy_greens"));
    public static final TagKey<Item> BLOCK_CHEESE = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "block_cheese"));
    public static final TagKey<Item> SHREDDED_CHEESE = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "shredded_cheese"));
    public static final TagKey<Item> TOMATOES = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "tomatoes"));
    public static final TagKey<Item> ONIONS = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "onions"));
    public static final TagKey<Item> RICE = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "rice"));
    public static final TagKey<Item> CUT_CHICKEN = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "cut_chicken"));
    public static final TagKey<Item> GROUND_BEEF = TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, "ground_beef"));

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(LEAFY_GREENS)
                .add(Identifier.of("farmersdelight", "cabbage_leaf"));

        this.getOrCreateTagBuilder(TOMATOES)
                .add(Identifier.of("farmersdelight","tomato"));

        this.getOrCreateTagBuilder(ONIONS)
                .add(Identifier.of("farmersdelight", "onion"));

        this.getOrCreateTagBuilder(RICE)
                .add(Identifier.of("farmersdelight","rice"));

        this.getOrCreateTagBuilder(CUT_CHICKEN)
                .add(Identifier.of("farmersdelight", "chicken_cuts"));

        this.getOrCreateTagBuilder(GROUND_BEEF)
                .add(Identifier.of("farmersdelight","minced_beef"));

        this.getOrCreateTagBuilder(SHREDDED_CHEESE)
                .add(ModItems.SHREDDED_CHEESE);
    }
}
