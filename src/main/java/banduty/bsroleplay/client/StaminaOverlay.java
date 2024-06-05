package banduty.bsroleplay.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.util.IEntityDataSaver;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class StaminaOverlay implements HudRenderCallback {
    private static final Identifier STAMINA = new Identifier(BsRolePlay.MOD_ID, "textures/overlay/stamina.png");
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
        boolean shouldStamina = ((IEntityDataSaver) player).bsroleplay$getPersistentData().getBoolean("stamina_boolean");
        int stamina = ((IEntityDataSaver) player).bsroleplay$getPersistentData().getInt("stamina_int");
        MinecraftClient client = MinecraftClient.getInstance();
        if (shouldStamina) {
            if (client != null) {
                int width = client.getWindow().getScaledWidth();
                int height = client.getWindow().getScaledHeight();

                x = width / 2;
                y = height;
            }

            for(int i = 0; i < 100; i++) {
                if(stamina > i) {
                    RenderSystem.setShaderTexture(0, STAMINA);
                    drawContext.drawTexture(STAMINA,x + 94,y - 31,0, 0, (int) (i * 0.34) + 1, 34,
                            34,34);
                } else {
                    break;
                }
            }
        }
    }
}