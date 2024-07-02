package banduty.bsroleplay.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class GrayscaleOverlay implements HudRenderCallback {

    private static final Identifier GRAYSCALE_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/overlay/grayscale.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
        if (player.hasStatusEffect(ModEffects.TIDAL_SURGE)) {
            int width = drawContext.getScaledWindowWidth();
            int height = drawContext.getScaledWindowHeight();

            int duration = player.getStatusEffect(ModEffects.TIDAL_SURGE).getDuration();
            float opacity = 2.5f;
            if (duration <= 80) opacity = Math.max(0.0f, duration / 32f);
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShaderTexture(0, GRAYSCALE_TEXTURE);
            drawContext.setShaderColor(1.0F, 1.0F, 1.0F, opacity);
            drawContext.drawTexture(GRAYSCALE_TEXTURE, 0, 0, 0, 0, width, height, width, height);

            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.disableBlend();
        }
    }
}
