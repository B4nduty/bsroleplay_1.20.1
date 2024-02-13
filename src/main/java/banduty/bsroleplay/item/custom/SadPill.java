package banduty.bsroleplay.item.custom;

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

public class SadPill extends Item {

    public SadPill(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient() && user instanceof PlayerEntity player && !player.hasStatusEffect(StatusEffects.WEAKNESS) && !player.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
            if (!player.isCreative()) stack.decrement(1);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 10 * 20, 0, false, false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10 * 20, 3, false, false,false));
            ((PlayerEntity) user).getItemCooldownManager().set(this, 10*20);

            player.getItemCooldownManager().set(this, 10 * 20);
            }

        return stack;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }
}
