package electricbudgie.tacosdelight.compat;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;

import java.util.LinkedList;
import java.util.List;

public class CheesePressCategory implements DisplayCategory<CheesePressDisplay> {
    public static final CategoryIdentifier<CheesePressDisplay> ID = CategoryIdentifier.of(TacosDelight.MOD_ID, "cheese_press");

    @Override
    public CategoryIdentifier<? extends CheesePressDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Cheese Press");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.CHEESE_PRESS_BLOCK);
    }

    @Override
    public List<Widget> setupDisplay(CheesePressDisplay display, Rectangle bounds) {

        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createRecipeBase(bounds));

        int x = bounds.getCenterX();

        widgets.add(Widgets.createSlot(new Point(x - 40, bounds.getCenterY()))
                .entries(display.getInputEntries().get(0)));

        widgets.add(Widgets.createArrow(new Point(x - 10, bounds.getCenterY())));

        widgets.add(Widgets.createSlot(new Point(x + 20, bounds.getCenterY()))
                .entries(display.getOutputEntries().get(0)));

        return widgets;
    }
}
