package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.datagen.custom.recipe.CustomFabricRecipeProvider;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.io.IOException;
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

//        Map<Item, Item> toppingsWithNachos = Map.of(
//                ModItems.TACO_BEEF, ModItems.BEEF_NACHO_PLATTER,
//                ModItems.TACO_CHICKEN, ModItems.CHICKEN_NACHO_PLATTER,
//                ModItems.SHREDDED_CHEESE, ModItems.CHEESY_NACHO_PLATTER
//        );

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

//        generateRecipes(toppingsWithNachos,
//                (filling, result) -> generateNachoPlatterRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithCrunchwrap,
                (filling, result) -> generateCrunchwrapRecipe(filling, result).offerTo(recipeExporter));


        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.TORTILLA_DOUGH, ModItems.FLOUR_TORTILLA, 1f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.UNCOOKED_CHEESE_QUESADILLA, ModItems.CHEESE_QUESADILLA, 1f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.UNCOOKED_POTATO_QUESADILLA, ModItems.POTATO_QUESADILLA, 1f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.UNCOOKED_CHICKEN_QUESADILLA, ModItems.CHICKEN_QUESADILLA, 1f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.UNCOOKED_BEEF_QUESADILLA, ModItems.BEEF_QUESADILLA, 1f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.UNCOOKED_POTATO_CRUNCHWRAP, ModItems.POTATO_CRUNCHWRAP, 1f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.UNCOOKED_BEEF_CRUNCHWRAP, ModItems.BEEF_CRUNCHWRAP, 1f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 100, ModItems.UNCOOKED_CHICKEN_CRUNCHWRAP, ModItems.CHICKEN_CRUNCHWRAP, 1f);

        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "smoker", RecipeSerializer.SMOKING, SmokingRecipe::new, 100, ModItems.HOT_PEPPER, ModItems.DRIED_CHILI, 1f);

        generateHomogenousFoodBox(ModItems.BEEF_BURRITO, ModBlocks.BEEF_BURRITO_BOX_BLOCK, 5).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.CHICKEN_BURRITO, ModBlocks.CHICKEN_BURRITO_BOX_BLOCK, 5).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.POTATO_BURRITO, ModBlocks.POTATO_BURRITO_BOX_BLOCK, 5).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.BEEF_TACO, ModBlocks.BEEF_TACO_BOX_BLOCK, 6).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.CHICKEN_TACO, ModBlocks.CHICKEN_TACO_BOX_BLOCK, 6).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.POTATO_TACO, ModBlocks.POTATO_TACO_BOX_BLOCK, 6).offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_TACO_BEEF)
                .input(ModItemTagProvider.CUT_CHICKEN)
                .input(ModItems.TACO_SEASONING)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TACO_SEASONING), FabricRecipeProvider.conditionsFromItem(ModItems.TACO_SEASONING))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_TACO_CHICKEN)
                .input(ModItemTagProvider.GROUND_BEEF)
                .input(ModItems.TACO_SEASONING)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TACO_SEASONING), FabricRecipeProvider.conditionsFromItem(ModItems.TACO_SEASONING))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.UNCOOKED_FIESTA_POTATOES)
                .input(ModItems.DICED_POTATO)
                .input(ModItems.TACO_SEASONING)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TACO_SEASONING), FabricRecipeProvider.conditionsFromItem(ModItems.TACO_SEASONING))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.BEEF_CRAVINGS_BLOCK_BOX.asItem())
                .input(ModItems.BEEF_TACO, 2)
                .input(ModItems.BEEF_BURRITO, 2)
                .input(ModItems.BEEF_CRUNCHWRAP, 2)
                .input(ModItems.BEEF_QUESADILLA, 2)
                .input(ModItems.CARDBOARD_TRAY)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BEEF_CRUNCHWRAP), FabricRecipeProvider.conditionsFromItem(ModItems.BEEF_CRUNCHWRAP))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.CHICKEN_CRAVINGS_BLOCK_BOX.asItem())
                .input(ModItems.CHICKEN_TACO, 2)
                .input(ModItems.CHICKEN_BURRITO, 2)
                .input(ModItems.CHICKEN_CRUNCHWRAP, 2)
                .input(ModItems.CHICKEN_QUESADILLA, 2)
                .input(ModItems.CARDBOARD_TRAY)
                .criterion(FabricRecipeProvider.hasItem(ModItems.CHICKEN_CRUNCHWRAP), FabricRecipeProvider.conditionsFromItem(ModItems.CHICKEN_CRUNCHWRAP))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.POTATO_CRAVINGS_BLOCK_BOX.asItem())
                .input(ModItems.POTATO_TACO, 2)
                .input(ModItems.POTATO_BURRITO, 2)
                .input(ModItems.POTATO_CRUNCHWRAP, 2)
                .input(ModItems.POTATO_QUESADILLA, 2)
                .criterion(FabricRecipeProvider.hasItem(ModItems.POTATO_CRUNCHWRAP), FabricRecipeProvider.conditionsFromItem(ModItems.POTATO_CRUNCHWRAP))
                .input(ModItems.CARDBOARD_TRAY)
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CARDBOARD_TRAY)
                .pattern("# #")
                .pattern("###")
                .input('#', Items.PAPER)
                .criterion(FabricRecipeProvider.hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SALT, 2)
                .input(ModItems.ROCK_SALT_CRYSTALS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROCK_SALT_CRYSTALS), FabricRecipeProvider.conditionsFromItem((ModItems.ROCK_SALT_CRYSTALS)))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TACO_SEASONING, 4)
                .input(ModItems.SALT)
                .input(ModItems.DRIED_CHILI)
                .input(ModItems.DRIED_ONION)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SALT), FabricRecipeProvider.conditionsFromItem(ModItems.SALT))
                .offerTo(recipeExporter);


        try {
            offerDeepFrying(recipeExporter, ModItems.RAW_TORTILLA_CHIPS, ModItems.TORTILLA_CHIPS, 1.0f, 100, 1);
            offerDeepFrying(recipeExporter, ModItems.UNCOOKED_FIESTA_POTATOES, ModItems.FRIED_FIESTA_POTATOES, 1.0f, 100, 1);
            offerDeepFrying(recipeExporter, ModItems.FLOUR_TORTILLA, ModItems.FLOUR_TOSTADA, 1.0f, 100, 1);
            offerCutting(recipeExporter, ModItemTagProvider.TOMATOES, ModItems.DICED_TOMATOES, 1);
            offerCutting(recipeExporter, ModItems.FLOUR_TORTILLA, ModItems.RAW_TORTILLA_CHIPS, 2);
            offerCutting(recipeExporter, Items.POTATO, ModItems.DICED_POTATO, 4);
            offerCutting(recipeExporter, ModItems.CHEESE_WEDGE, ModItems.SHREDDED_CHEESE, 4);
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

    private static ShapelessRecipeJsonBuilder generateHomogenousFoodBox(Item food, Block box, int count) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, box.asItem())
                .input(food, count)
                .input(ModItems.CARDBOARD_TRAY)
                .criterion(FabricRecipeProvider.hasItem(food), FabricRecipeProvider.conditionsFromItem(food));
    }

}