package electricbudgie.tacosdelight.datagen;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.effect.ModEffects;
import electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.EffectsChangedCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        var root = Advancement.Builder.create()
                .display(ModItems.BEEF_TACO,
                        Text.literal("Taco Delights"),
                        Text.literal("A world of commercialised tex-mex awaits!"),
                        Identifier.of(TacosDelight.MOD_ID, "textures/gui/advancements/90s_advancement_background.png") ,
                        AdvancementFrame.GOAL,
                        false,
                        false,
                        false
                )
                .criterion("root", InventoryChangedCriterion.Conditions.items(Items.WHEAT))
                .build(consumer, TacosDelight.MOD_ID + "/root");

        var sour_cream = Advancement.Builder.create()
                .parent(root)
                .display(ModItems.SOUR_CREAM,
                        Text.literal("Tangy and Divisive"),
                        Text.literal("The first in a long-line of non-authentic features on this menu"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                        )
                .criterion("sour_cream", InventoryChangedCriterion.Conditions.items(ModItems.SOUR_CREAM))
                .build(consumer, TacosDelight.MOD_ID + "/sour_cream");

        var obtained_salt = Advancement.Builder.create()
                .parent(root)
                .display(ModItems.SALT,
                        Text.literal("All These Flavors"),
                        Text.literal("Salt might not count as a 'spice', but it's pretty important nonetheless"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_salty", InventoryChangedCriterion.Conditions.items(ModItems.SALT))
                .build(consumer, TacosDelight.MOD_ID + "/got_salty");

        var curds_and_whey = Advancement.Builder.create()
                .parent(obtained_salt)
                .display(ModItems.CURDS_AND_WHEY,
                        Text.literal("Little Miss Muffet"),
                        Text.literal("Despite the rhyme, there's probably a way to make this more palatable"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("curds", InventoryChangedCriterion.Conditions.items(ModItems.CURDS_AND_WHEY))
                .build(consumer, TacosDelight.MOD_ID + "/curds");

        var the_beginning = Advancement.Builder.create()
                .parent(obtained_salt)
                .display(ModItems.FLOUR_TORTILLA,
                        Text.literal("Start of a Tex-Mex Journey"),
                        Text.literal("Tortilla in hand, you've taken your first steps into the magical world of commercialized tex-mex"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("made_tortilla", InventoryChangedCriterion.Conditions.items(ModItems.FLOUR_TORTILLA))
                .build(consumer, TacosDelight.MOD_ID + "/made_tortilla");

        var cheese_roll_up = Advancement.Builder.create()
                .parent(the_beginning)
                .display(ModItems.CHEESY_ROLL_UP,
                        Text.literal("Simple, Yet Effective"),
                        Text.literal("At least you heated it up"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("cheese_roll_up", InventoryChangedCriterion.Conditions.items(ModItems.CHEESY_ROLL_UP))
                .build(consumer, TacosDelight.MOD_ID + "/cheese_roll_up");

        var quesadilla = Advancement.Builder.create()
                .parent(cheese_roll_up)
                .display(ModItems.CHEESE_QUESADILLA,
                        Text.literal("Quesadillas"),
                        Text.literal("Like a roll-up, but flat!"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("cheese_quesadilla", InventoryChangedCriterion.Conditions.items(ModItems.CHEESE_QUESADILLA))
                .criterion("chicken_quesadilla", InventoryChangedCriterion.Conditions.items(ModItems.CHICKEN_QUESADILLA))
                .criterion("beef_quesadilla", InventoryChangedCriterion.Conditions.items(ModItems.BEEF_QUESADILLA))
                .criterion("potato_quesadilla", InventoryChangedCriterion.Conditions.items(ModItems.POTATO_QUESADILLA))
                .build(consumer,TacosDelight.MOD_ID + "/quesadilla");

        var taco = Advancement.Builder.create()
                .parent(quesadilla)
                .display(ModItems.BEEF_TACO,
                        Text.literal("Tacos"),
                        Text.literal("So iconic you could make an entire chain based on them"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("chicken_taco", InventoryChangedCriterion.Conditions.items(ModItems.CHICKEN_TACO))
                .criterion("beef_taco", InventoryChangedCriterion.Conditions.items(ModItems.BEEF_TACO))
                .criterion("potato_taco", InventoryChangedCriterion.Conditions.items(ModItems.POTATO_TACO))
                .build(consumer,TacosDelight.MOD_ID + "/taco");

        var burrito = Advancement.Builder.create()
                .parent(taco)
                .display(ModItems.BEEF_BURRITO,
                        Text.literal("Burritos"),
                        Text.literal("Like a taco, but with rice"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("chicken_burrito", InventoryChangedCriterion.Conditions.items(ModItems.CHICKEN_BURRITO))
                .criterion("beef_burrito", InventoryChangedCriterion.Conditions.items(ModItems.BEEF_BURRITO))
                .criterion("potato_burrito", InventoryChangedCriterion.Conditions.items(ModItems.POTATO_BURRITO))
                .build(consumer,TacosDelight.MOD_ID + "/burrito");

        var crunchwrap = Advancement.Builder.create()
                .parent(burrito)
                .display(ModItems.BEEF_CRUNCHWRAP,
                        Text.literal("Crunchwraps"),
                        Text.literal("Like burritos, but flat and crunchy"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("chicken_crunchwrap", InventoryChangedCriterion.Conditions.items(ModItems.CHICKEN_CRUNCHWRAP))
                .criterion("beef_crunchwrap", InventoryChangedCriterion.Conditions.items(ModItems.BEEF_CRUNCHWRAP))
                .criterion("potato_crunchwrap", InventoryChangedCriterion.Conditions.items(ModItems.POTATO_CRUNCHWRAP))
                .build(consumer,TacosDelight.MOD_ID + "/crunchwrap");

        var hot_pepper = Advancement.Builder.create()
                .parent(root)
                .display(ModItems.HOT_PEPPER,
                        Text.literal("Seems Useful"),
                        Text.literal("Little Known Fact: Peppers are used for taco seasoning"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_hot_pepper", InventoryChangedCriterion.Conditions.items(ModItems.HOT_PEPPER))
                .build(consumer, TacosDelight.MOD_ID + "/got_hot_pepper");

        var smoked_pepper = Advancement.Builder.create()
                .parent(hot_pepper)
                .display(ModItems.DRIED_CHILI,
                        Text.literal("Now We're Cooking"),
                        Text.literal("We can probably make a seasoning with this now"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_dried_pepper", InventoryChangedCriterion.Conditions.items(ModItems.DRIED_CHILI))
                .build(consumer, TacosDelight.MOD_ID + "/got_dried_pepper");

        var made_seasoning = Advancement.Builder.create()
                .parent(smoked_pepper)
                .display(ModItems.TACO_SEASONING,
                        Text.literal("Taco Seasoning"),
                        Text.literal("Works for more than just tacos!"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("taco_seasoning", InventoryChangedCriterion.Conditions.items(ModItems.TACO_SEASONING))
                .build(consumer, TacosDelight.MOD_ID + "/taco_seasoning");

        var made_deep_fryer = Advancement.Builder.create()
                .parent(root)
                .display(ModBlocks.DEEP_FRYER_BLOCK.asItem(),
                        Text.literal("A Vat of Bubbling Hot Oil"),
                        Text.literal("The danger makes the food taste better"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("made_deep_fryer", InventoryChangedCriterion.Conditions.items(ModBlocks.DEEP_FRYER_BLOCK))
                .build(consumer, TacosDelight.MOD_ID + "/made_deep_fryer");

        var made_fiesta_potatoes = Advancement.Builder.create()
                .parent(made_deep_fryer)
                .display(ModItems.FRIED_FIESTA_POTATOES,
                        Text.literal("Fried Taters"),
                        Text.literal("So iconic. So versatile."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("made_fiesta_potatoes", InventoryChangedCriterion.Conditions.items(ModItems.FRIED_FIESTA_POTATOES))
                .build(consumer, TacosDelight.MOD_ID + "/made_fiesta_potatoes");

        var made_tortilla_chips = Advancement.Builder.create()
                .parent(made_deep_fryer)
                .display(ModItems.TORTILLA_CHIPS,
                        Text.literal("Tortilla Chips"),
                        Text.literal("Surprisingly easy to make (as long as you have a vat of hot oil)"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("made_tortilla_chips", InventoryChangedCriterion.Conditions.items(ModItems.TORTILLA_CHIPS))
                .build(consumer, TacosDelight.MOD_ID + "/made_tortilla_chips");

        var made_nachos = Advancement.Builder.create()
                .parent(made_tortilla_chips)
                .display(ModItems.NACHOS,
                        Text.literal("Cheesy"),
                        Text.literal("Classic"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("made_nachos", InventoryChangedCriterion.Conditions.items(ModItems.NACHOS))
                .build(consumer, TacosDelight.MOD_ID + "/made_nachos");

        var made_cheesy_potato_burrito = Advancement.Builder.create()
                .parent(made_fiesta_potatoes)
                .display(ModItems.POTATO_BURRITO,
                        Text.literal("Potatoes + Cheese = ❤"),
                        Text.literal("Could you even imagine NOT serving this?"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("made_cheesy_potato_burrito", InventoryChangedCriterion.Conditions.items(ModItems.POTATO_BURRITO))
                .build(consumer, TacosDelight.MOD_ID + "/made_cheesy_potato_burrito");

        var made_empanada = Advancement.Builder.create()
                .parent(made_deep_fryer)
                .display(ModItems.CARAMEL_APPLE_EMPANADA,
                        Text.literal("Caramelly Delicious"),
                        Text.literal("At least this won't ever leave YOUR menu"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("made_empanada", InventoryChangedCriterion.Conditions.items(ModItems.CARAMEL_APPLE_EMPANADA))
                .build(consumer, TacosDelight.MOD_ID + "/made_caramel_apple_empanada");

        var made_cheese_press = Advancement.Builder.create()
                .parent(curds_and_whey)
                .display(ModBlocks.CHEESE_PRESS_BLOCK.asItem(),
                        Text.literal("Cheesemaker"),
                        Text.literal("As it turns out, cheese takes a lot of work"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("made_tortilla", InventoryChangedCriterion.Conditions.items(ModBlocks.CHEESE_PRESS_BLOCK))
                .build(consumer, TacosDelight.MOD_ID + "/made_cheese_press");

        var made_cheese = Advancement.Builder.create()
                .parent(made_cheese_press)
                .display(ModItems.CHEESE_WEDGE,
                        Text.literal("FINALLY"),
                        Text.literal("That took way too long"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("made_cheese", InventoryChangedCriterion.Conditions.items(ModItems.CHEESE_WEDGE))
                .build(consumer, TacosDelight.MOD_ID + "/made_cheese");

        var made_nacho_cheese = Advancement.Builder.create()
                .parent(made_cheese)
                .display(ModItems.NACHO_CHEESE,
                        Text.literal("Saucy"),
                        Text.literal("That orange glow tho"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false)
                .criterion("made_nacho_cheese", InventoryChangedCriterion.Conditions.items(ModItems.NACHO_CHEESE))
                .build(consumer, TacosDelight.MOD_ID + "/made_nacho_cheese");

        var blue_raspberry = Advancement.Builder.create()
                .parent(root)
                .display(ModItems.BLUE_RASPBERRY,
                        Text.literal("They Do Exist!"),
                        Text.literal("So THAT'S where that flavor comes from"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_blue_raspberry", InventoryChangedCriterion.Conditions.items(ModItems.BLUE_RASPBERRY))
                .build(consumer, TacosDelight.MOD_ID + "/got_blue_raspberry");

        var baja_blasted = Advancement.Builder.create()
                .parent(blue_raspberry)
                .display(ModItems.BAJA_BLAST,
                        Text.literal("Ambrosia In Real Life"),
                        Text.literal("You've reached the pinnacle of human ingenuity"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .criterion("made_baja_blast", InventoryChangedCriterion.Conditions.items(ModItems.BAJA_BLAST))
                .build(consumer, TacosDelight.MOD_ID + "/made_baja_blast");

        var gassy = Advancement.Builder.create()
                .parent(made_seasoning)
                .display(ModItems.BEEF_BURRITO,
                        Text.literal("Too Much of a Good Thing"),
                        Text.literal("Experienced some gastrointestinal distress"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .criterion("got_gassy", EffectsChangedCriterion.Conditions.create(new EntityEffectPredicate.Builder().addEffect(ModEffects.GASSY)))
                .build(consumer, TacosDelight.MOD_ID + "/got_gassy");

        var spicy = Advancement.Builder.create()
                .parent(hot_pepper)
                .display(ModItems.HOT_PEPPER,
                        Text.literal("It Burns!"),
                        Text.literal("Eating that really hurt! And yet... "),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .criterion("spicy", EffectsChangedCriterion.Conditions.create(new EntityEffectPredicate.Builder().addEffect(ModEffects.SPICY)))
                .build(consumer, TacosDelight.MOD_ID + "/spicy");

        var got_disappointed = Advancement.Builder.create()
                .parent(the_beginning)
                .display(ModItems.TORTILLA_WITH_CHEESE,
                        Text.literal("Could have been better"),
                        Text.literal("That last meal left you a little hollow and wondering if it could have been more than what it was..."),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .criterion("got_disappointed", EffectsChangedCriterion.Conditions.create(new EntityEffectPredicate.Builder().addEffect(ModEffects.DISAPPOINTED)))
                .build(consumer, TacosDelight.MOD_ID + "/got_disappointed");
    }
}
