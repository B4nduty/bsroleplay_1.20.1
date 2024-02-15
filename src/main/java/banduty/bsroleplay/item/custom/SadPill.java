package banduty.bsroleplay.item.custom;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
        return BsRolePlay.CONFIG.common.getSadPillConsumeTime()*20;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient() && user instanceof PlayerEntity player && !player.hasStatusEffect(StatusEffects.WEAKNESS) && !player.hasStatusEffect(StatusEffects.MINING_FATIGUE) && !player.hasStatusEffect(StatusEffects.SLOWNESS)) {
            if (!player.isCreative()) stack.decrement(1);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 10 * 20, 0, false, false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, 0, false, false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10 * 20, 3, false, false,false));

            player.getItemCooldownManager().set(this, 10 * 20);
            }

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.common.showItemTooltips) {
            tooltip.add(Text.literal("Not applied if has:").formatted(Formatting.RED));
            tooltip.add(Text.literal("- Weakness").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("- Mining Fatigue").formatted(Formatting.WHITE));
            tooltip.add(Text.literal("- Slowness").formatted(Formatting.WHITE));
            super.appendTooltip(stack, world, tooltip, context);
        }
    }
}
