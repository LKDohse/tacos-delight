package electricbudgie.tacosdelight.compat;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.item.ModItems;
import electricbudgie.tacosdelight.recipe.DeepFryerRecipe;
import electricbudgie.tacosdelight.recipe.ModRecipes;
import electricbudgie.tacosdelight.screen.custom.DeepFryerScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;

public class TacosDelightREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new DeepFryerCategory());
        registry.add(new CheesePressCategory());

        registry.addWorkstations(DeepFryerCategory.DEEP_FRYER, EntryStacks.of(ModBlocks.DEEP_FRYER_BLOCK));
        registry.addWorkstations(DeepFryerCategory.DEEP_FRYER, EntryStacks.of(ModBlocks.CHEESE_PRESS_BLOCK));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
       registry.registerRecipeFiller(DeepFryerRecipe.class, ModRecipes.DEEP_FRYER_TYPE, DeepFryerDisplay::new);
       registerCheesePressRecipes(registry);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176)/2) + 78, ((screen.height - 166)/2)+30, 20, 25),
                DeepFryerScreen.class, DeepFryerCategory.DEEP_FRYER);
    }

    private void registerCheesePressRecipes(DisplayRegistry registry){
        registry.add(new CheesePressDisplay(
                new ItemStack(ModItems.CURDS_AND_WHEY),
                new ItemStack(ModBlocks.CHEESE_WHEEL_BLOCK.asItem())
        ));
    }
}
