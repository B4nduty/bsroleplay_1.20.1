package banduty.bsroleplay.networking.packet;

import banduty.bsroleplay.util.IEntityDataSaver;
import banduty.bsroleplay.util.StaminaData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class StaminaZeroC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        int stamina = ((IEntityDataSaver) player).bsroleplay$getPersistentData().getInt("stamina_int");
        if (stamina == 0) StaminaData.setZero((IEntityDataSaver) player, true);
        if (stamina >= 10 && ((IEntityDataSaver) player).bsroleplay$getPersistentData()
                .getBoolean("stamina_zero")) StaminaData.setZero((IEntityDataSaver) player, false);
    }
}
