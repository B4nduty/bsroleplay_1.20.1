
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.custom.SandstormProjectileEntity;
import banduty.bsroleplay.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DuneCaller extends Item {
    public DuneCaller(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            SandstormProjectileEntity sandstormProjectileEntity = new SandstormProjectileEntity(user, world);
            sandstormProjectileEntity.setItem(new ItemStack(ModItems.SANDSTORM_PROJECTILE));
            sandstormProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2.0f, 1.0f);
            world.spawnEntity(sandstormProjectileEntity);
            user.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getDuneCallerCooldown() * 20);
        }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.common.showItemTooltips) {
            tooltip.add(Text.translatable("tooltip.bsroleplay.dune_caller.tooltip"));
            super.appendTooltip(stack, world, tooltip, context);
        }
    }
}