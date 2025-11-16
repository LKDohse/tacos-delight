package electricbudgie.tacosdelight.effect;

import electricbudgie.tacosdelight.TacosDelight;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SLIMY = registerStatusEffect("slimy",
            new SlimyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(TacosDelight.MOD_ID, "slimy"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> DISAPPOINTED = registerStatusEffect("disappointed",
            new DisappointedEffect(StatusEffectCategory.HARMFUL,0xbbbfbf)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(TacosDelight.MOD_ID, "disappointed"), -0.20f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> GASSY = registerStatusEffect("gassy",
            new GassyEffect(StatusEffectCategory.NEUTRAL,0x7d5011));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TacosDelight.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        TacosDelight.LOGGER.info("Registering Mod Effects for " + TacosDelight.MOD_ID);
    }
}
