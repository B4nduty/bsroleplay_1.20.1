package banduty.bsroleplay.util;

import banduty.bsroleplay.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class StaminaData {
    public static void setStamina(IEntityDataSaver player, boolean stamina_boolean) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        nbt.putBoolean("stamina_boolean", stamina_boolean);
        syncStaminaBoolean(stamina_boolean, (ServerPlayerEntity) player);
    }

    public static int addStamina(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        int stamina_int = nbt.getInt("stamina_int");
        if (stamina_int + amount >= 100) {
            stamina_int = 100;
        } else {
            stamina_int += amount;
        }

        nbt.putInt("stamina_int", stamina_int);
        syncStamina(stamina_int, (ServerPlayerEntity) player);
        return stamina_int;
    }

    public static int removeStamina(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        int stamina_int = nbt.getInt("stamina_int");
        if (stamina_int - amount < 0) {
            stamina_int = 0;
        } else {
            stamina_int -= amount;
        }

        nbt.putInt("stamina_int", stamina_int);
        syncStamina(stamina_int, (ServerPlayerEntity) player);
        return stamina_int;
    }

    public static void syncStamina(int stamina_int, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(stamina_int);
        ServerPlayNetworking.send(player, ModMessages.STAMINA_INT_ID, buffer);
    }

    public static void syncStaminaBoolean(boolean stamina_boolean, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeBoolean(stamina_boolean);
        ServerPlayNetworking.send(player, ModMessages.STAMINA_BOOLEAN_ID, buffer);
    }
}