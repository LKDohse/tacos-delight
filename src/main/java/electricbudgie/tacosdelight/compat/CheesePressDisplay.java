package electricbudgie.tacosdelight.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CheesePressDisplay implements Display {
    private final ItemStack input;
    private final ItemStack output;

    public CheesePressDisplay(ItemStack input, ItemStack output){
        this.input = input;
        this.output = output;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(EntryIngredients.of(input));
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(EntryIngredients.of(output));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CheesePressCategory.ID;
    }
}
