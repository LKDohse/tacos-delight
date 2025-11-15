package electricbudgie.tacosdelight.block.entity.renderer.client;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.entity.custom.CheesePressBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CheesePressModel extends GeoModel<CheesePressBlockEntity> {
    @Override
    public Identifier getModelResource(CheesePressBlockEntity cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "geo/cheese_press_model.geo.json");
    }

    @Override
    public Identifier getTextureResource(CheesePressBlockEntity cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/cheese_press.png");
    }

    @Override
    public Identifier getAnimationResource(CheesePressBlockEntity cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "animations/cheese_press_model.animation.json");
    }

}
