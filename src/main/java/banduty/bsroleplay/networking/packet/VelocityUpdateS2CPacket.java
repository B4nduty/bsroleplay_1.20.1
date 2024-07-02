package banduty.bsroleplay.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;

public class VelocityUpdateS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        int entityId = buf.readInt();
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();

        client.execute(() -> {
            if (client.world != null) {
                Entity entity = client.world.getEntityById(entityId);
                if (entity != null) {
                    entity.setVelocity(x, y, z);
                }
            }
        });
    }
}

