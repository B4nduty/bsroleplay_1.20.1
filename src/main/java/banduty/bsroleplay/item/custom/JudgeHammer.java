package banduty.bsroleplay.item.custom;

import banduty.bsroleplay.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JudgeHammer extends Item {
    public JudgeHammer (Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos positionClicked = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        context.getWorld().playSound(null, positionClicked, ModSounds.JUDGE_HAMMER_RIGHT_CLICK,
                SoundCategory.BLOCKS, 1f, 1f);

        player.getItemCooldownManager().set(this, 20);

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.bsroleplay.judgehammer.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
