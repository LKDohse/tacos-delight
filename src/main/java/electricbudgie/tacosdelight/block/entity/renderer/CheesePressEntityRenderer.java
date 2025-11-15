package electricbudgie.tacosdelight.block.entity.renderer;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.entity.custom.CheesePressBlockEntity;
import electricbudgie.tacosdelight.block.entity.renderer.client.CheesePressModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CheesePressEntityRenderer extends GeoBlockRenderer<CheesePressBlockEntity> {
    public CheesePressEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(new CheesePressModel());
    }

    @Override
    public @Nullable RenderLayer getRenderType(CheesePressBlockEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucentCull(Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/cheese_press.png"));
    }
}
