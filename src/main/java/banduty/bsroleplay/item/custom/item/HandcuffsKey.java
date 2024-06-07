
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.sound.ModSounds;
import banduty.bsroleplay.util.Handcuffed;
import banduty.bsroleplay.util.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HandcuffsKey extends Item {
    public HandcuffsKey(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof PlayerEntity playerTarget &&
                ((IEntityDataSaver) playerTarget).bsroleplay$getPersistentData().getBoolean("handcuffed")) {
            if (!user.isCreative()) stack.decrement(1);
            playerTarget.removeStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS).getEffectType());
            playerTarget.removeStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS).getEffectType());
            playerTarget.removeStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST).getEffectType());

            World world = user.getWorld();
            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld) user.getWorld();
                BlockPos blockPos = user.getBlockPos();
                serverWorld.playSound(null, blockPos, ModSounds.HANDCUFFEDNT, SoundCategory.PLAYERS, 1f, 1f);
                playerTarget.sendMessage(Text.translatable("message.bsroleplay.handcuff_key.free_2").fillStyle(Style.EMPTY.withColor(Formatting.GREEN)), true);
                user.sendMessage(Text.translatable("message.bsroleplay.handcuff_key.free_1", playerTarget.getName().getString()).fillStyle(Style.EMPTY), true);
            }
            Handcuffed.setHandcuffed((IEntityDataSaver) playerTarget, false);

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
