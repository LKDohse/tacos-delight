package electricbudgie.tacosdelight.components;

import com.mojang.serialization.Codec;
import electricbudgie.tacosdelight.TacosDelight;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {
    public static final ComponentType<Integer> AGE_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(TacosDelight.MOD_ID, "age"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );

    public static void initialize(){
        TacosDelight.LOGGER.info("Registering components for ", TacosDelight.MOD_ID);
    }
}
