package banduty.bsroleplay.event;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.util.IEntityDataSaver;
import banduty.bsroleplay.util.StaminaData;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerTickHandler implements ServerTickEvents.StartTick{
    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity playerEntity : server.getPlayerManager().getPlayerList()) {
            int stamina = ((IEntityDataSaver) playerEntity).bsroleplay$getPersistentData().getInt("stamina_int");
            if (playerEntity.age % (BsRolePlay.CONFIG.common.getStaminaRecoverTime() * 0.2) == 0 && stamina < 100) {
                StaminaData.addStamina(((IEntityDataSaver) playerEntity), Math.min(1, 100 - stamina));
            }
        }
    }
}