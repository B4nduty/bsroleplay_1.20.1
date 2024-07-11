package banduty.bsroleplay.event;

import banduty.bsroleplay.networking.ModMessages;
import banduty.bsroleplay.util.IEntityDataSaver;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String BANDUTY_ROLEPLAY = "key.category.bsroleplay";
    public static final String KEY_POLICE_SPEED = "key.bsroleplay.police_speed";

    public static KeyBinding policeSpeed;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            PlayerEntity playerEntity = MinecraftClient.getInstance().player;
            if (playerEntity != null) {
                int stamina = ((IEntityDataSaver) playerEntity).bsroleplay$getPersistentData().getInt("stamina_int");
                if(policeSpeed.isPressed() && ((IEntityDataSaver) playerEntity).bsroleplay$getPersistentData()
                        .getBoolean("stamina_boolean") && stamina > 0) {
                    ClientPlayNetworking.send(ModMessages.POLICE_SPEED_ID, PacketByteBufs.create());
                    ClientPlayNetworking.send(ModMessages.SET_STAMINA_ZERO_ID, PacketByteBufs.create());
                    ClientPlayNetworking.send(ModMessages.SET_REGEN_STAMINA_FALSE_ID, PacketByteBufs.create());
                }

                if (!policeSpeed.isPressed()) ClientPlayNetworking.send(ModMessages.SET_REGEN_STAMINA_TRUE_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register() {
        policeSpeed = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_POLICE_SPEED,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_CONTROL,
                BANDUTY_ROLEPLAY
        ));

        registerKeyInputs();
    }
}
