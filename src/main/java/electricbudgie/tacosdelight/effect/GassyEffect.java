package electricbudgie.tacosdelight.effect;

import electricbudgie.tacosdelight.particle.ModParticles;
import electricbudgie.tacosdelight.registry.ModDamageSources;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.joml.Vector3f;

import java.util.Random;

public class GassyEffect extends StatusEffect {
    private static final Random RANDOM = new Random();

    protected GassyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()){
            if(RANDOM.nextFloat() < 0.005f)
                spawnGasCloud(entity);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    private void spawnGasCloud(LivingEntity entity){
        ServerWorld world = (ServerWorld) entity.getWorld();

        AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(
                world,
                entity.getX(),
                entity.getY() + 1,
                entity.getZ()
        );

        cloud.setOwner(entity);
        cloud.setRadius(0.5f);
        cloud.setRadiusGrowth(0.025f);
        cloud.setDuration(20);
        cloud.setParticleType(ModParticles.GASSY_PARTICLE);
        cloud.addEffect(new StatusEffectInstance(ModEffects.GAS_CLOUD_DAMAGE, 1, 0));
        world.spawnEntity(cloud);
        world.playSound(null, entity.getBlockPos(),
                SoundEvents.BLOCK_SLIME_BLOCK_STEP,
                SoundCategory.PLAYERS,
                0.8f, 0.8f);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
