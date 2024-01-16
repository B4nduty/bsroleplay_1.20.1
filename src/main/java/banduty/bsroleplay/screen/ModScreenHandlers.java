package banduty.bsroleplay.screen;

import banduty.bsroleplay.BsRolePlay;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<HolyCloudGeneratorScreenHandler> HOLY_CLOUD_GENERATOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(BsRolePlay.MOD_ID, "holy_cloud_generator"),
                    new ExtendedScreenHandlerType<>(HolyCloudGeneratorScreenHandler::new));

    public static void registerScreenHandlers() {
        BsRolePlay.LOGGER.info("Registering Screen Handlers for " + BsRolePlay.MOD_ID);
    }
}