
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.sound.ModSounds;
import banduty.bsroleplay.util.BlockedMilk;
import banduty.bsroleplay.util.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
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
        if (entity instanceof PlayerEntity playerTarget && !playerTarget.isCreative()) {
            if (!BlockedMilk.isMilkBlocked((IEntityDataSaver) entity)) {
                if (!user.isCreative()) stack.decrement(1);
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,
                        -1, BsRolePlay.CONFIG.common.getHandcuffsSlownessLevel() - 1, false,
                        false, false));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,
                        -1, BsRolePlay.CONFIG.common.getHandcuffsWeaknessLevel() - 1, false,
                        false, false));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,
                        -1, 217, false, false, false));

                BlockedMilk.setMilkBlocked(((IEntityDataSaver) entity), true);

                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    BlockPos blockPos = user.getBlockPos();
                    serverWorld.playSound(null, blockPos, ModSounds.HANDCUFFED, SoundCategory.PLAYERS, 1f, 1f);
                    entity.sendMessage(Text.translatable("message.bsroleplay.handcuff.handcuffed_2").formatted(Formatting.RED));
                    user.sendMessage(Text.translatable("message.bsroleplay.handcuff.handcuffed_1", entity.getName().getString()).formatted(Formatting.RED));
                }

                user.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getHandcuffsCooldown() * 20);

                return ActionResult.SUCCESS;

            }
        }
        return ActionResult.PASS;
    }
}