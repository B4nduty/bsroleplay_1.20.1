package banduty.bsroleplay.networking.packet;

import banduty.bsroleplay.screen.creative_shop.CreativeShopScreenHandler;
import banduty.bsroleplay.screen.shop.ShopScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class UpdateCurrencyCounterPacketC2SPacket {
    private final int syncId;
    private final int increaseAmount;

    public UpdateCurrencyCounterPacketC2SPacket(int syncId, int increaseAmount) {
        this.syncId = syncId;
        this.increaseAmount = increaseAmount;
    }

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        int syncId = buf.readInt();
        int increaseAmount = buf.readInt();
        UpdateCurrencyCounterPacketC2SPacket packet = new UpdateCurrencyCounterPacketC2SPacket(syncId, increaseAmount);
        handle(packet, server, player, responseSender);
    }

    public static void handle(UpdateCurrencyCounterPacketC2SPacket packet, MinecraftServer server, ServerPlayerEntity player, PacketSender sender) {
        server.execute(() -> {
            if (player.currentScreenHandler.syncId == packet.syncId) {
                if (player.currentScreenHandler instanceof ShopScreenHandler handler) {
                    if (packet.increaseAmount > 0) {
                        handler.increaseCurrencyCounter(packet.increaseAmount);
                    } else {
                        handler.decreaseCurrencyCounter(-packet.increaseAmount);
                    }
                }

                if (player.currentScreenHandler instanceof CreativeShopScreenHandler handler) {
                    if (packet.increaseAmount > 0) {
                        handler.increaseCurrencyCounter(packet.increaseAmount);
                    } else {
                        handler.decreaseCurrencyCounter(-packet.increaseAmount);
                    }
                }
            }
        });
    }
}
