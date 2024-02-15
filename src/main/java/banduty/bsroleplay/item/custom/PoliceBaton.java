package banduty.bsroleplay.item.custom;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PoliceBaton extends AxeItem {
    public PoliceBaton(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 1, 2f, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (BsRolePlay.CONFIG.common.modifyPoliceBatonSlowness &&
                !(attacker instanceof PlayerEntity playerAttacker && playerAttacker.getItemCooldownManager().isCoolingDown(this))) {
            if (attacker instanceof PlayerEntity playerAttacker) {
                playerAttacker.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getPoliceBatonCooldown()*20);
            }
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, BsRolePlay.CONFIG.common.getPoliceBatonSlownessDuration()*20, BsRolePlay.CONFIG.common.getPoliceBatonSlownessLevel()-1));
            return true;
        }
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.common.showItemTooltips) {
            tooltip.add(Text.translatable("tooltip.bsroleplay.policebaton.tooltip").formatted(Formatting.AQUA));
            super.appendTooltip(stack, world, tooltip, context);
        }
    }
}
