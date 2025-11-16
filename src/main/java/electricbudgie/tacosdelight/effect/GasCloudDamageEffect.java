package electricbudgie.tacosdelight.effect;

import electricbudgie.tacosdelight.registry.ModDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.Nullable;

public class GasCloudDamageEffect  extends InstantStatusEffect {
    public GasCloudDamageEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.hasInvertedHealingAndHarm()) {
            entity.heal(Math.max(4 << amplifier, 0));
        } else {
            entity.damage(getDamageSource(entity), 6 << amplifier);
        }

        return true;
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if (target.hasInvertedHealingAndHarm()) {
            int i = (int)(proximity * (4 << amplifier) + 0.5);
            target.heal(i);
        } else {
            int i = (int)(proximity * (6 << amplifier) + 0.5);
            if (source == null) {
                target.damage(getDamageSource(target), i);
            } else {
                target.damage(getDamageSource(source), i);
            }
        }
    }

    private DamageSource getDamageSource(Entity entity){
        return new DamageSource(
                entity.getWorld().getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(ModDamageSources.GAS_CLOUD));
    }
}
