package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.datagen.custom.recipe.CustomFabricRecipeProvider;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModRecipeProvider extends CustomFabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        Map<Item, Item> fillingWithTaco = Map.of(
                ModItems.TACO_BEEF, ModItems.BEEF_TACO,
                ModItems.TACO_CHICKEN, ModItems.CHICKEN_TACO,
                ModItems.FRIED_FIESTA_POTATOES, ModItems.POTATO_TACO
        );

        Map<Item, Item> fillingWithBurrito = Map.of(
                ModItems.TACO_BEEF, ModItems.BEEF_BURRITO,
                ModItems.TACO_CHICKEN, ModItems.CHICKEN_BURRITO,
                ModItems.FRIED_FIESTA_POTATOES, ModItems.POTATO_BURRITO);

        Map<Item, Item> fillingWithQuesadilla = Map.of(
                ModItems.TACO_BEEF, ModItems.UNCOOKED_BEEF_QUESADILLA,
                ModItems.TACO_CHICKEN, ModItems.UNCOOKED_CHICKEN_QUESADILLA,
                ModItems.FRIED_FIESTA_POTATOES, ModItems.UNCOOKED_POTATO_QUESADILLA,
                ModItems.SHREDDED_CHEESE, ModItems.UNCOOKED_CHEESE_QUESADILLA
        );

        Map<Item, Item> toppingsWithNachos = Map.of(
                ModItems.TACO_BEEF, ModItems.BEEF_NACHO_PLATTER,
                ModItems.TACO_CHICKEN, ModItems.CHICKEN_NACHO_PLATTER,
                ModItems.SHREDDED_CHEESE, ModItems.CHEESY_NACHO_PLATTER
        );

        Map<Item, Item> fillingWithCrunchwrap = Map.of(
                ModItems.TACO_BEEF, ModItems.UNCOOKED_BEEF_CRUNCHWRAP,
                ModItems.TACO_CHICKEN, ModItems.UNCOOKED_CHICKEN_CRUNCHWRAP,
                ModItems.FRIED_FIESTA_POTATOES, ModItems.UNCOOKED_POTATO_CRUNCHWRAP
        );

        generateRecipes(fillingWithTaco,
                (filling, result) -> generateTacoRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithBurrito,
                (filling, result) -> generateBurritoRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithQuesadilla,
                (filling, result) -> generateQuesadillaRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(toppingsWithNachos,
                (filling, result) -> generateNachoPlatterRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithCrunchwrap,
                (filling, result) -> generateCrunchwrapRecipe(filling, result).offerTo(recipeExporter));

        try {
            offerDeepFrying(recipeExporter, ModItems.HOT_PEPPER, ModItems.BLUE_RASPBERRY, 1.0f, 100, 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateRecipes(Map<Item, Item> fillings, BiConsumer<Item, Item> generator) {
        fillings.forEach(generator);
    }

    private static ShapelessRecipeJsonBuilder generateTacoRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA)
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM)
                .input(ModItems.DICED_TOMATOES)
                .input(ModItemTagProvider.LEAFY_GREENS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA));
    }

    private static ShapelessRecipeJsonBuilder generateBurritoRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA)
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM)
                .input(ModItems.DICED_TOMATOES)
                .input(ModItemTagProvider.LEAFY_GREENS)
                .input(ModItemTagProvider.RICE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA));
    }

    private static ShapelessRecipeJsonBuilder generateQuesadillaRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA)
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA));
    }

    private static ShapelessRecipeJsonBuilder generateNachoPlatterRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.TORTILLA_CHIPS)
                .input(ModItems.TORTILLA_CHIPS)
                .input(ModItems.TORTILLA_CHIPS)
                .input(ModItems.TORTILLA_CHIPS)
                .input(filling)
                .input(ModItems.NACHO_CHEESE)
                .input(ModItems.SOUR_CREAM)
                .input(ModItems.CARDBOARD_TRAY)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA));
    }

    private static ShapelessRecipeJsonBuilder generateCrunchwrapRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA)
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM)
                .input(ModItems.DICED_TOMATOES)
                .input(ModItemTagProvider.LEAFY_GREENS)
                .input(ModItems.FLOUR_TOSTADA)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TOSTADA));
    }

}