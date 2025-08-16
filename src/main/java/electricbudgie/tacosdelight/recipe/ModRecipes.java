package electricbudgie.tacosdelight.recipe;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.datagen.custom.recipe.DeepFryRecipe;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static final RecipeSerializer<DeepFryRecipe> DEEP_FRYER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER,
            Identifier.of(TacosDelight.MOD_ID, "deep_fryer"),
            new CookingRecipeSerializer<>(DeepFryRecipe::new, 100)
    );

    public static final RecipeType<DeepFryerRecipe> DEEP_FRYER_TYPE = Registry.register(
            Registries.RECIPE_TYPE,
            Identifier.of(TacosDelight.MOD_ID, "deepfrying"), new RecipeType<DeepFryerRecipe>() {
                @Override
                public String toString() {
                    return "deepfrying";
                }
            });



    public static void registerRecipes(){
        TacosDelight.LOGGER.info("Registering custom recipes for " + TacosDelight.MOD_ID);
    }

}
