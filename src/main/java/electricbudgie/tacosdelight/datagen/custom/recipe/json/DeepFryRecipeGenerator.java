package electricbudgie.tacosdelight.datagen.custom.recipe.json;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class DeepFryRecipeGenerator {

    public static JsonObject generate(ItemConvertible input, ItemConvertible output, float experience, int cookingTime)  {
        Identifier inputId = Registries.ITEM.getId(input.asItem());
        Identifier outputId = Registries.ITEM.getId(output.asItem());

        JsonObject recipeJson = new JsonObject();
        recipeJson.addProperty("type", "tacos_delight:deep_frying");
        recipeJson.addProperty("group", "");
        recipeJson.addProperty("experience", experience);
        recipeJson.addProperty("cookingtime", cookingTime);

        JsonObject ingredient = new JsonObject();
        ingredient.addProperty("item", inputId.toString());
        recipeJson.add("ingredient", ingredient);

        JsonObject result = new JsonObject();
        result.addProperty("item", outputId.toString());
        recipeJson.add("result", result);

        return recipeJson;
    }
}
