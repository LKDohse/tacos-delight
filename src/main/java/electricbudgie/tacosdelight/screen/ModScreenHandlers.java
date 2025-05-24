package electricbudgie.tacosdelight.screen;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.screen.custom.DeepFryerScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {

    public static final ScreenHandlerType<DeepFryerScreenHandler> DEEP_FRYER_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(TacosDelight.MOD_ID, "deepfryer_screen_handler"),
                    new ExtendedScreenHandlerType<>(DeepFryerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers(){
        TacosDelight.LOGGER.info("Registering screen handlers for " + TacosDelight.MOD_ID);
    }
}
