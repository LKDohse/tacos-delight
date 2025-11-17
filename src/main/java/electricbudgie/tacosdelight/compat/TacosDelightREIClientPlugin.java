package electricbudgie.tacosdelight.compat;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.recipe.DeepFryerRecipe;
import electricbudgie.tacosdelight.recipe.ModRecipes;
import electricbudgie.tacosdelight.screen.custom.DeepFryerScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class TacosDelightREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new DeepFryerCategory());

        registry.addWorkstations(DeepFryerCategory.DEEP_FRYER, EntryStacks.of(ModBlocks.DEEP_FRYER_BLOCK));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
       registry.registerRecipeFiller(DeepFryerRecipe.class, ModRecipes.DEEP_FRYER_TYPE, DeepFryerDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176)/2) + 78, ((screen.height - 166)/2)+30, 20, 25),
                DeepFryerScreen.class, DeepFryerCategory.DEEP_FRYER);
    }
}
