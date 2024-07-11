package banduty.bsroleplay.util;

import banduty.bsroleplay.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.advancement.Advancement;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class StaminaData {
    public static void setStamina(IEntityDataSaver player, boolean stamina_boolean) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        nbt.putBoolean("stamina_boolean", stamina_boolean);
        syncStaminaBoolean(stamina_boolean, (ServerPlayerEntity) player);
    }

    public static void setZero(IEntityDataSaver player, boolean stamina_zero) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        nbt.putBoolean("stamina_zero", stamina_zero);
        syncStaminaZero(stamina_zero, (ServerPlayerEntity) player);
    }

    public static void setRegenStamina(IEntityDataSaver player, boolean regen_stamina) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        nbt.putBoolean("regen_stamina", regen_stamina);
        syncRegenStamina(regen_stamina, (ServerPlayerEntity) player);
    }

    public static void addStamina(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        int stamina_int = nbt.getInt("stamina_int");
        int totalStamina = 60;
        if (player instanceof ServerPlayerEntity playerEntity) {
            Advancement netherAdvancement = playerEntity.server.getAdvancementLoader().get(new Identifier("minecraft", "nether/root"));
            Advancement endAdvancement = playerEntity.server.getAdvancementLoader().get(new Identifier("minecraft", "end/kill_dragon"));
            if (playerEntity.getAdvancementTracker().getProgress(endAdvancement).isDone()) {
                totalStamina = 180;
            } else if (playerEntity.getAdvancementTracker().getProgress(netherAdvancement).isDone()) {
                totalStamina = 120;
            }
        }
        if (stamina_int + amount >= totalStamina) {
            stamina_int = totalStamina;
        } else {
            stamina_int += amount;
        }

        nbt.putInt("stamina_int", stamina_int);
        if (player instanceof ServerPlayerEntity) {
            syncStamina(stamina_int, (ServerPlayerEntity) player);
        }
    }

    public static void removeStamina(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        int stamina_int = nbt.getInt("stamina_int");
        if (stamina_int - amount < 0) {
            stamina_int = 0;
        } else {
            stamina_int -= amount;
        }

        nbt.putInt("stamina_int", stamina_int);
        syncStamina(stamina_int, (ServerPlayerEntity) player);
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

    public static void syncStaminaZero(boolean stamina_zero, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeBoolean(stamina_zero);
        ServerPlayNetworking.send(player, ModMessages.STAMINA_ZERO_ID, buffer);
    }

    public static void syncRegenStamina(boolean regen_stamina, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeBoolean(regen_stamina);
        ServerPlayNetworking.send(player, ModMessages.STAMINA_ZERO_ID, buffer);
    }
}