package banduty.bsroleplay.item.custom;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Hook extends Item {
    public Hook (Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos positionClicked = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World World = context.getWorld();

        Entity evokerFangs = new EvokerFangsEntity(EntityType.EVOKER_FANGS, World);
        evokerFangs.setPosition(positionClicked.toCenterPos());
        World.spawnEntity(evokerFangs);

        context.getWorld().playSound(null, positionClicked, SoundEvents.BLOCK_ANVIL_LAND,
                SoundCategory.BLOCKS, 0.5f, 1f);

        player.getItemCooldownManager().set(this, 100);

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.bsroleplay.hook.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
