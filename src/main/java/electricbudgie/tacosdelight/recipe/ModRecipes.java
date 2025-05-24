package electricbudgie.tacosdelight.recipe;

import electricbudgie.tacosdelight.TacosDelight;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static final RecipeSerializer<DeepFryerRecipe> DEEP_FRYER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER,
            Identifier.of(TacosDelight.MOD_ID, "deep_frying"), new DeepFryerRecipe.Serializer());

    public static final RecipeType<DeepFryerRecipe> DEEP_FRYER_TYPE = Registry.register(
            Registries.RECIPE_TYPE,
            Identifier.of(TacosDelight.MOD_ID, "deep_frying"), new RecipeType<DeepFryerRecipe>() {
                @Override
                public String toString() {
                    return "deep_frying";
                }
            });

    public static void registerRecipes(){
        TacosDelight.LOGGER.info("Registering custom recipes for " + TacosDelight.MOD_ID);
    }

}
