package electricbudgie.tacosdelight.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record DeepFryerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<DeepFryerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(DeepFryerRecipeInput input, World world) {
        if (world.isClient())
            return false;

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(DeepFryerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.DEEP_FRYER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.DEEP_FRYER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<DeepFryerRecipe> {
        //this is so we can read in json files as recipes
        public static final MapCodec<DeepFryerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(DeepFryerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(DeepFryerRecipe::output)
        ).apply(inst, DeepFryerRecipe::new));

        //how this is serialized to be sent over the network
        public static final PacketCodec<RegistryByteBuf, DeepFryerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, DeepFryerRecipe::inputItem,
                        ItemStack.PACKET_CODEC, DeepFryerRecipe::output,
                        DeepFryerRecipe::new);

        @Override
        public MapCodec<DeepFryerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, DeepFryerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }


}
