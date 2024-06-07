package banduty.bsroleplay.mixin;

import banduty.bsroleplay.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public class MilkBucketMixin {
    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void bsroleplay$use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (((IEntityDataSaver) user).bsroleplay$getPersistentData().getBoolean("handcuffed")) {
            cir.setReturnValue(TypedActionResult.pass(user.getStackInHand(hand)));
        }
    }
}