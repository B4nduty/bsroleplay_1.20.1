package banduty.bsroleplay.mixin;

import banduty.bsroleplay.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void bsroleplay$applyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.hasStatusEffect(ModEffects.SANDSTORM)) {
            float f = player.getStatusEffect(ModEffects.SANDSTORM).isInfinite() ? 5.0F : MathHelper.lerp(Math.min(1.0F,
                    (float)player.getStatusEffect(ModEffects.SANDSTORM).getDuration() / 20.0F), viewDistance, 5.0F);

            float fogStart;
            float fogEnd;
            if (fogType == BackgroundRenderer.FogType.FOG_SKY) {
                fogStart = 0.0F;
                fogEnd = f * 0.8F;
            } else {
                fogStart = f * 0.25F;
                fogEnd = f;
            }

            int color = 16749568;
            float red = ColorHelper.Argb.getRed(color) / 255.0F;
            float green = ColorHelper.Argb.getGreen(color) / 255.0F;
            float blue = ColorHelper.Argb.getBlue(color) / 255.0F;

            RenderSystem.setShaderFogColor(red, green, blue);
            RenderSystem.setShaderFogStart(fogStart);
            RenderSystem.setShaderFogEnd(fogEnd);

            ci.cancel();
        }
    }

    @Inject(method = "setFogBlack", at = @At("HEAD"), cancellable = true)
    private static void bsroleplay$applyFogColor(CallbackInfo ci) {
        if (MinecraftClient.getInstance().player != null
                && MinecraftClient.getInstance().player.hasStatusEffect(ModEffects.SANDSTORM)) {
            int color = 16749568;
            float red = ColorHelper.Argb.getRed(color) / 255.0F;
            float green = ColorHelper.Argb.getGreen(color) / 255.0F;
            float blue = ColorHelper.Argb.getBlue(color) / 255.0F;

            RenderSystem.clearColor(red, green, blue, 1.0F);

            ci.cancel();
        }
    }
}