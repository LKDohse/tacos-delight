package electricbudgie.tacosdelight.datagen.custom.recipe;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.recipe.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;

public class DeepFryRecipe extends AbstractCookingRecipe {

    public DeepFryRecipe(String group, CookingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(ModRecipes.DEEP_FRYER_TYPE, group, CookingRecipeCategory.FOOD, ingredient, result, experience, cookingTime);
    }
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.DEEP_FRYER_BLOCK);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    public static final RecipeSerializer<DeepFryRecipe> SERIALIZER = ModRecipes.DEEP_FRYER_SERIALIZER;

}
