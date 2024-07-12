package banduty.bsroleplay.event;

import banduty.bsroleplay.util.IEntityDataSaver;
import banduty.bsroleplay.util.StaminaData;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.advancement.Advancement;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class PlayerTickHandler implements ServerTickEvents.StartTick{
    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity playerEntity : server.getPlayerManager().getPlayerList()) {
            int stamina = ((IEntityDataSaver) playerEntity).bsroleplay$getPersistentData().getInt("stamina_int");
            boolean staminaZero = ((IEntityDataSaver) playerEntity).bsroleplay$getPersistentData().getBoolean("stamina_zero");
            boolean regenStamina = ((IEntityDataSaver) playerEntity).bsroleplay$getPersistentData().getBoolean("regen_stamina");
            int staminaRecoverTime = 60;
            int totalStamina = 60;
            Advancement netherAdvancement = playerEntity.server.getAdvancementLoader().get(new Identifier("minecraft", "nether/root"));
            Advancement endAdvancement = playerEntity.server.getAdvancementLoader().get(new Identifier("minecraft", "end/kill_dragon"));
            if (playerEntity.getAdvancementTracker().getProgress(endAdvancement).isDone()) {
                totalStamina = 180;
                staminaRecoverTime = 30;
            } else if (playerEntity.getAdvancementTracker().getProgress(netherAdvancement).isDone()) {
                totalStamina = 120;
                staminaRecoverTime = 45;
            }

            if (stamina == 0) StaminaData.setZero((IEntityDataSaver) playerEntity, true);
            if (stamina >= 60 && staminaZero) StaminaData.setZero((IEntityDataSaver) playerEntity, false);

            if (stamina >= 60) StaminaData.setBlockedStamina((IEntityDataSaver) playerEntity, false);
            else if (staminaZero) StaminaData.setBlockedStamina((IEntityDataSaver) playerEntity, true);

            int ticksPerRecovery = (int) (staminaRecoverTime * (20.0 / totalStamina));

            if (playerEntity.age % ticksPerRecovery == 0 && stamina < totalStamina && regenStamina) {
                StaminaData.addStamina(((IEntityDataSaver) playerEntity), Math.min(1, totalStamina - stamina));
            }
        }
    }
}