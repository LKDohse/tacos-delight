package electricbudgie.tacosdelight.particle;

import electricbudgie.tacosdelight.TacosDelight;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final SimpleParticleType GASSY_PARTICLE =
            registerParticle("gassy", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType){
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(TacosDelight.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        TacosDelight.LOGGER.info("registering particles for " + TacosDelight.MOD_ID);
    }
}
