package electricbudgie.tacosdelight.datagen.custom.recipe.json;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class DeepFryRecipeGenerator {

    public static JsonObject generate(ItemConvertible input, ItemConvertible output, float experience, int cookingTime, int count)  {
        Identifier inputId = Registries.ITEM.getId(input.asItem());
        Identifier outputId = Registries.ITEM.getId(output.asItem());

        JsonObject recipeJson = new JsonObject();
        recipeJson.addProperty("type", "tacos-delight:deepfrying");
        recipeJson.addProperty("group", "tacos-delight");
        recipeJson.addProperty("category", "food");
        recipeJson.addProperty("experience", experience);
        recipeJson.addProperty("cookingtime", cookingTime);

        JsonObject ingredient = new JsonObject();
        ingredient.addProperty("item", inputId.toString());
        recipeJson.add("ingredient", ingredient);

        JsonObject result = new JsonObject();
        result.addProperty("id", outputId.toString());
        result.addProperty("count", count);
        recipeJson.add("result", result);

        return recipeJson;
    }
}
