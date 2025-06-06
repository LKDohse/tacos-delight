package electricbudgie.tacosdelight.block.entity.renderer;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.entity.custom.DeepFryerBlockEntity;
import electricbudgie.tacosdelight.block.entity.renderer.client.DeepFryerModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DeepFryerBlockEntityRenderer extends GeoBlockRenderer<DeepFryerBlockEntity> {
    public DeepFryerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(new DeepFryerModel());
    }

    @Override
    public @Nullable RenderLayer getRenderType(DeepFryerBlockEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucentCull(Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/deep_fryer.png"));
    }
}
