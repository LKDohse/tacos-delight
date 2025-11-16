package electricbudgie.tacosdelight.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.Random;

public class DisappointedEffect extends StatusEffect {
    private static final Random RANDOM = new Random();

    protected DisappointedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient) {
            if (RANDOM.nextFloat() < 0.005f) {
                entity.getWorld().playSound(
                        null,
                        entity.getBlockPos(),
                        SoundEvents.ENTITY_VILLAGER_AMBIENT,
                        SoundCategory.PLAYERS,
                        0.3f,
                        0.9f + (RANDOM.nextFloat() * 0.2f)
                );
            }
        }


        return super.applyUpdateEffect(entity, amplifier);
    }



    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
