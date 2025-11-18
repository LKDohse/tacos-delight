package electricbudgie.tacosdelight.effect;

import electricbudgie.tacosdelight.particle.ModParticles;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SpicyEffect extends StatusEffect {

    protected SpicyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 1.0F) {
            entity.damage(entity.getDamageSources().magic(), 0.5F);
        }
        entity.setSprinting(true);

        if (!entity.getWorld().isClient()) {
            spawnFireCloud(entity, entity.getWorld());
        }
        return true;
    }

    private void spawnFireCloud(LivingEntity entity, World world){

        AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(
                world,
                entity.getX(),
                entity.getY() + 1.5,
                entity.getZ()
        );

        cloud.setOwner(entity);
        cloud.setRadius(0.5f);
        cloud.setRadiusGrowth(0.025f);
        cloud.setDuration(5);
        cloud.setParticleType(ParticleTypes.FLAME);
        cloud.hasNoGravity();
        world.spawnEntity(cloud);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}
