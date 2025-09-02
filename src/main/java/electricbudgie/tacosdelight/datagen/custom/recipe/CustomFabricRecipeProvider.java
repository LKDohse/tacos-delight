package electricbudgie.tacosdelight.datagen.custom.recipe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.datagen.custom.recipe.json.DeepFryRecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;

public abstract class CustomFabricRecipeProvider extends FabricRecipeProvider {
    public CustomFabricRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        fabricDataOutput = output;
    }

    FabricDataOutput fabricDataOutput;


    protected void offerDeepFrying(RecipeExporter exporter,
                                   ItemConvertible input,
                                   ItemConvertible output,
                                   float experience,
                                   int cookingTime,
                                   int count) throws IOException {


        var recipeJson = DeepFryRecipeGenerator.generate(input, output, experience, cookingTime, count);
        writeRecipeJson(fabricDataOutput, Identifier.of(TacosDelight.MOD_ID, Registries.ITEM.getId(output.asItem()).getPath()), recipeJson);
    }

    public void writeRecipeJson(FabricDataOutput output, Identifier id, JsonObject json) throws IOException {
        Path outputDir = output.getPath().getParent();
        Path recipePath = outputDir
                .resolve("resources")
                .resolve("data")
                .resolve(id.getNamespace())
                .resolve("recipe")
                .resolve(id.getPath() + "_from_deepfrying.json");
        var outputPath = recipePath.getParent();
        Files.createDirectories(outputPath);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(json);

        Files.writeString(recipePath, jsonString, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }
}
