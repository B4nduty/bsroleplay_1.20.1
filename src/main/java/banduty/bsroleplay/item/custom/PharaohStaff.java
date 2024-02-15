package banduty.bsroleplay.item.custom;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
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

public class PharaohStaff extends Item {
    public PharaohStaff (Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World World = context.getWorld();
        if (BsRolePlay.CONFIG.common.modifyPharaohStaffLightning) {

            Entity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, World);
            lightning.setPosition(blockPos.toCenterPos());
            World.spawnEntity(lightning);

            context.getWorld().playSound(null, blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE,
                    SoundCategory.BLOCKS, 1f, 1f);

            if (player != null) {
                player.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getPharaohStaffCooldown() * 20);
            }

            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.common.showItemTooltips) {
            tooltip.add(Text.translatable("tooltip.bsroleplay.pharaoh_staff.tooltip").formatted(Formatting.AQUA));
            super.appendTooltip(stack, world, tooltip, context);
        }
    }
}
