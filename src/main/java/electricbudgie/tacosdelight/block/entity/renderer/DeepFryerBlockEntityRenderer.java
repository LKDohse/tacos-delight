package electricbudgie.tacosdelight.block.entity.renderer;

import electricbudgie.tacosdelight.block.entity.custom.DeepFryerBlockEntity;
import electricbudgie.tacosdelight.block.entity.renderer.client.DeepFryerModel;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DeepFryerBlockEntityRenderer extends GeoBlockRenderer<DeepFryerBlockEntity> {
    public DeepFryerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(new DeepFryerModel());
    }


}
