
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class InvKit extends Item {

    public InvKit(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return BsRolePlay.CONFIG.common.getInvKitConsumeTime() * 20;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient() && user instanceof PlayerEntity player &&
                !player.hasStatusEffect(StatusEffects.WEAKNESS) &&
                !player.hasStatusEffect(StatusEffects.MINING_FATIGUE) &&
                !player.hasStatusEffect(StatusEffects.SLOWNESS)) {
            if (!player.isCreative()) stack.decrement(1);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, BsRolePlay.CONFIG.common.getInvKit1stStageTime() * 20, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, BsRolePlay.CONFIG.common.getInvKit1stStageTime() * 20, 2, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, BsRolePlay.CONFIG.common.getInvKit1stStageTime() * 20, 3, false, false, false));

            player.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getInvKit1stStageTime() * 20);
        }

        return stack;
    }
}
