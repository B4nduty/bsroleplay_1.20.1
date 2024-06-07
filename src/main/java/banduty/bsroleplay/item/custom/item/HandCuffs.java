
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
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

public class HandCuffs extends Item {

    public HandCuffs(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
            if (entity instanceof PlayerEntity playerTarget && !playerTarget.isCreative() &&
                    !((IEntityDataSaver) playerTarget).bsroleplay$getPersistentData().getBoolean("handcuffed")) {
                if (!user.isCreative()) stack.decrement(1);
                playerTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,
                        -1, BsRolePlay.CONFIG.common.getHandcuffsSlownessLevel() - 1, false,
                        false, false));
                playerTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,
                        -1, BsRolePlay.CONFIG.common.getHandcuffsWeaknessLevel() - 1, false,
                        false, false));
                playerTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,
                        -1, 217, false, false, false));

                Handcuffed.setHandcuffed(((IEntityDataSaver) playerTarget), true);

                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    BlockPos blockPos = user.getBlockPos();
                    serverWorld.playSound(null, blockPos, ModSounds.HANDCUFFED, SoundCategory.PLAYERS, 1f, 1f);
                    playerTarget.sendMessage(Text.translatable("message.bsroleplay.handcuff.handcuffed_2").fillStyle(Style.EMPTY.withColor(Formatting.RED)), true);
                    user.sendMessage(Text.translatable("message.bsroleplay.handcuff.handcuffed_1", playerTarget.getName().getString()).fillStyle(Style.EMPTY), true);
                }

                return ActionResult.SUCCESS;

            }
        return ActionResult.PASS;
    }
}