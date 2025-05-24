package electricbudgie.tacosdelight;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import electricbudgie.tacosdelight.block.entity.renderer.DeepFryerBlockEntityRenderer;
import electricbudgie.tacosdelight.screen.ModScreenHandlers;
import electricbudgie.tacosdelight.screen.custom.DeepFryerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class TacosDelightClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_RASPBERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIME_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOT_PEPPER_CROP, RenderLayer.getCutout());
        BlockEntityRendererFactories.register(ModBlockEntities.DEEP_FRYER_BE, DeepFryerBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.DEEP_FRYER_HANDLER, DeepFryerScreen::new);
    }
}
