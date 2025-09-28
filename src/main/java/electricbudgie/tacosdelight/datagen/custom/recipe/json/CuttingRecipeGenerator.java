package electricbudgie.tacosdelight.datagen.custom.recipe.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CuttingRecipeGenerator {

    // For single-item input
    public static JsonObject generate(ItemConvertible input, ItemConvertible output, int count) {
        Identifier inputId = Registries.ITEM.getId(input.asItem());
        return generateInternal("item", inputId, output, count);
    }

    // For tag input
    public static JsonObject generate(TagKey<Item> inputTag, ItemConvertible output, int count) {
        Identifier tagId = inputTag.id();
        return generateInternal("tag", tagId, output, count);
    }

    // Shared logic
    private static JsonObject generateInternal(String ingredientType, Identifier inputId, ItemConvertible output, int count) {
        Identifier outputId = Registries.ITEM.getId(output.asItem());

        JsonObject recipeJson = new JsonObject();
        recipeJson.addProperty("type", "farmersdelight:cutting");
        recipeJson.addProperty("group", "tacos-delight");
        recipeJson.addProperty("category", "food");

        JsonObject ingredient = new JsonObject();
        ingredient.addProperty(ingredientType, inputId.toString()); // "item" or "tag"
        JsonArray ingredientArray = new JsonArray();
        ingredientArray.add(ingredient);
        recipeJson.add("ingredients", ingredientArray);

        JsonObject tool = new JsonObject();
        tool.addProperty("tag", "farmersdelight:tools/knives");
        recipeJson.add("tool", tool);

        JsonObject id = new JsonObject();
        JsonObject result = new JsonObject();
        id.addProperty("id", outputId.toString());
        result.addProperty("count", count);
        result.add("item", id);
        JsonArray resultsArray = new JsonArray();
        resultsArray.add(result);
        recipeJson.add("result", resultsArray);

        return recipeJson;
    }
}
