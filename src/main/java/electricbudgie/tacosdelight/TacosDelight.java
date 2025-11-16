package electricbudgie.tacosdelight;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import electricbudgie.tacosdelight.components.ModComponents;
import electricbudgie.tacosdelight.effect.ModEffects;
import electricbudgie.tacosdelight.item.ModItemGroups;
import electricbudgie.tacosdelight.item.ModItems;
import electricbudgie.tacosdelight.particle.ModParticles;
import electricbudgie.tacosdelight.recipe.ModRecipes;
import electricbudgie.tacosdelight.screen.ModScreenHandlers;
import electricbudgie.tacosdelight.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;
import vectorwing.farmersdelight.common.registry.ModDataComponents;

public class TacosDelight implements ModInitializer {
	public static final String MOD_ID = "tacos-delight";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItemGroups.registerItemGroups();
		ModComponents.initialize();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModParticles.registerParticles();
		ModEffects.registerEffects();
		ModWorldGeneration.generateModWorldGeneration();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		LOGGER.info("Initializing Tacos Delight!");
	}
}