package banduty.bsroleplay.item.custom;

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
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HandcuffsKey extends Item {
    public HandcuffsKey(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (BlockedMilk.isMilkBlocked((IEntityDataSaver) entity)) {
            if (!user.isCreative()) stack.decrement(1);
            entity.removeStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS).getEffectType());
            entity.removeStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS).getEffectType());
            entity.removeStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST).getEffectType());

            World world = user.getWorld();
            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld) user.getWorld();
                BlockPos blockPos = user.getBlockPos();
                serverWorld.playSound(null, blockPos, ModSounds.HANDCUFFEDNT, SoundCategory.PLAYERS, 1f, 1f);
            }

            BlockedMilk.setMilkBlocked(((IEntityDataSaver) entity), false);

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}