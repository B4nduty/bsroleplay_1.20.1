package banduty.bsroleplay.networking.packet;

import banduty.bsroleplay.util.IEntityDataSaver;
import banduty.bsroleplay.util.StaminaData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.advancement.Advancement;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class PoliceEffectsC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        if (!((IEntityDataSaver) player).bsroleplay$getPersistentData().getBoolean("stamina_zero")) {
            Advancement netherAdvancement = player.server.getAdvancementLoader().get(new Identifier("minecraft", "nether/root"));
            Advancement endAdvancement = player.server.getAdvancementLoader().get(new Identifier("minecraft", "end/kill_dragon"));
            StaminaData.removeStamina((IEntityDataSaver) player, 1);
            int speedAmplifier = 2;
            if (player.getAdvancementTracker().getProgress(endAdvancement).isDone()) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2,
                        2, false, false, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2,
                        1, false, false, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2,
                        0, false, false, false));

                speedAmplifier = 4;
            } else if (player.getAdvancementTracker().getProgress(netherAdvancement).isDone()) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2,
                        1, false, false, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2,
                        0, false, false, false));
                speedAmplifier = 3;
            }
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2,
                    speedAmplifier, false, false, false));
        }
    }
}
