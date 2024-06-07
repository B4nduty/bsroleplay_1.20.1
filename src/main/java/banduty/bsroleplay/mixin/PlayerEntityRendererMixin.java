package banduty.bsroleplay.mixin;

import banduty.bsroleplay.util.IEntityDataSaver;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @Inject(method = "getArmPose", at = @At("RETURN"), cancellable = true)
    private static void bsroleplay$getArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> callbackInfoReturnable) {
        if (((IEntityDataSaver) player).bsroleplay$getPersistentData().getBoolean("handcuffed")) {
            callbackInfoReturnable.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_CHARGE);
        }
    }
}