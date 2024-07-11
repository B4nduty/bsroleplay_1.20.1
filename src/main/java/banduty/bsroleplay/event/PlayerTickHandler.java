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
            int staminaRecoverTime = 60;
            int totalStamina = 60;
            int intTotalStamina = 60;
            Advancement netherAdvancement = playerEntity.server.getAdvancementLoader().get(new Identifier("minecraft", "nether/root"));
            Advancement endAdvancement = playerEntity.server.getAdvancementLoader().get(new Identifier("minecraft", "end/kill_dragon"));
            if (playerEntity.getAdvancementTracker().getProgress(endAdvancement).isDone()) {
                totalStamina = 180;
                staminaRecoverTime = 30;
                intTotalStamina = 180;
            } else if (playerEntity.getAdvancementTracker().getProgress(netherAdvancement).isDone()) {
                totalStamina = 120;
                staminaRecoverTime = 45;
                intTotalStamina = 120;
            }

            int ticksPerRecovery = (int) (staminaRecoverTime * (20.0 / totalStamina));

            if (playerEntity.age % ticksPerRecovery == 0 && stamina < intTotalStamina &&
                    ((IEntityDataSaver) playerEntity).bsroleplay$getPersistentData().getBoolean("regen_stamina")) {
                StaminaData.addStamina(((IEntityDataSaver) playerEntity), Math.min(1, intTotalStamina - stamina));
            }
        }
    }
}