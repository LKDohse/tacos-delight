package electricbudgie.tacosdelight.block.entity.renderer.client;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.entity.custom.DeepFryerBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;


public class DeepFryerModel extends GeoModel<DeepFryerBlockEntity> {


    @Override
    public Identifier getModelResource(DeepFryerBlockEntity deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "geo/deep_fryer_model.geo.json");
    }

    @Override
    public Identifier getTextureResource(DeepFryerBlockEntity deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/deep_fryer.png");
    }

    @Override
    public Identifier getAnimationResource(DeepFryerBlockEntity deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "animations/deep_fryer_model.animation.json");
    }
}
