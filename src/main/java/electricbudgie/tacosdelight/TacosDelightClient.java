package electricbudgie.tacosdelight;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.custom.CheeseWheelBlock;
import electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import electricbudgie.tacosdelight.block.entity.renderer.CheesePressEntityRenderer;
import electricbudgie.tacosdelight.block.entity.renderer.DeepFryerBlockEntityRenderer;
import electricbudgie.tacosdelight.components.ModComponents;
import electricbudgie.tacosdelight.screen.ModScreenHandlers;
import electricbudgie.tacosdelight.screen.custom.DeepFryerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;

public class TacosDelightClient implements ClientModInitializer {

    public static void registerModelPredicateProviders() {
        ModelPredicateProviderRegistry.register(ModBlocks.CHEESE_WHEEL_BLOCK.asItem(), Identifier.of("age"),
                (itemStack, clientWorld, livingEntity, seed) -> {
                    Integer age = itemStack.get(ModComponents.AGE_COMPONENT);
                    if (age == null) return 0.0f;
                    return switch (age) {
                        case 0 -> 0.0f;
                        case 1 -> 0.5f;
                        case 2 -> 1.0f;
                        default -> 0f;
                    };
                });
    }

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_RASPBERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIME_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOT_PEPPER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HALITE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HALITE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_HALITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_HALITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_HALITE_BUD, RenderLayer.getCutout());

//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEEF_TACO_BOX_BLOCK, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHICKEN_TACO_BOX_BLOCK, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTATO_TACO_BOX_BLOCK, RenderLayer.getCutout());
        BlockEntityRendererFactories.register(ModBlockEntities.DEEP_FRYER_BE, DeepFryerBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.CHEESE_PRESS_BE, CheesePressEntityRenderer::new);

        registerModelPredicateProviders();
        HandledScreens.register(ModScreenHandlers.DEEP_FRYER_HANDLER, DeepFryerScreen::new);
    }
}
