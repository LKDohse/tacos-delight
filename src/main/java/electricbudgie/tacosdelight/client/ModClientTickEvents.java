package electricbudgie.tacosdelight.client;

import electricbudgie.tacosdelight.effect.ModEffects;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.player.PlayerEntity;

public class ModClientTickEvents {

    private static void registerDisappointmentClientEvents(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            PlayerEntity player = client.player;

            if (player.hasStatusEffect(ModEffects.DISAPPOINTED)) {

                float currentPitch = player.getPitch();
                float targetPitch = (currentPitch + 0.7f); // tune: 0.05–0.3 works nicely
                targetPitch = Math.min(targetPitch, 59f);
                player.setPitch(targetPitch);
            }
        });
    }

    public static void registerClientTickEvents(){
        registerDisappointmentClientEvents();
    }


}
