package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.datagen.custom.recipe.CustomFabricRecipeProvider;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;


import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends CustomFabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
       // offerFoodCookingRecipe(recipeExporter, "smoker", RecipeSerializer.SMOKING, SmokingRecipe::new, 100, ModItems.HOT_PEPPER, ModItems.BLUE_RASPBERRY, 1.0f);
       // offerSmelting(recipeExporter, List.of(ModItems.HOT_PEPPER), RecipeCategory.FOOD, ModItems.BLUE_RASPBERRY, 100f, 100, "Tacos Delight");
        try {
            offerDeepFrying(recipeExporter, ModItems.HOT_PEPPER, ModItems.BLUE_RASPBERRY, 1.0f, 100, 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
