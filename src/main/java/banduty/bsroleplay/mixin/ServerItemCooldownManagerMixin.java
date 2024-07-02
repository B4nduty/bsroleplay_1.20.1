package banduty.bsroleplay.mixin;

import banduty.bsroleplay.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerItemCooldownManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerItemCooldownManager.class)
public class ServerItemCooldownManagerMixin {
    @Shadow @Final private ServerPlayerEntity player;

    @Inject(method = "onCooldownUpdate(Lnet/minecraft/item/Item;I)V", at = @At("TAIL"))
    private void onCooldownUpdate(Item item, int duration, CallbackInfo ci) {
        if (duration == 0) {
            if (item == ModItems.INVKIT) {
                addEffectsSadPill(this.player);
            }
        }
    }
    @Inject(method = "onCooldownUpdate(Lnet/minecraft/item/Item;)V", at = @At("TAIL"))
    private void onCooldownUpdate(Item item, CallbackInfo ci) {
        if (item == ModItems.INVKIT) {
            addEffectsSadPill(this.player);
        }
    }

    @Unique
    private static void addEffectsSadPill(ServerPlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 2, false, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 45 * 20, 0, false, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 10, 0, false, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 30 * 20, 2, false, false, false));
    }
}