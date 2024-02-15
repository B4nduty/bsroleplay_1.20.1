package banduty.bsroleplay.item.custom;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Hook extends Item {
    public Hook (Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {

        if (BsRolePlay.CONFIG.common.modifyHookEvokerFang) {
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            World World = context.getWorld();

            Entity evokerFangs = new EvokerFangsEntity(EntityType.EVOKER_FANGS, World);
            evokerFangs.setPosition(blockPos.toCenterPos());
            World.spawnEntity(evokerFangs);

            context.getWorld().playSound(null, blockPos, SoundEvents.BLOCK_ANVIL_LAND,
                    SoundCategory.BLOCKS, 0.5f, 1f);

            if (player != null) {
                player.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getHookCooldown() * 20);
            }

            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.common.showItemTooltips) {
            tooltip.add(Text.translatable("tooltip.bsroleplay.hook.tooltip").formatted(Formatting.AQUA));
            super.appendTooltip(stack, world, tooltip, context);
        }
    }
}
