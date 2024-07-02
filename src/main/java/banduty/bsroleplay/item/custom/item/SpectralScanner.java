package banduty.bsroleplay.item.custom.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpectralScanner extends Item {
    public SpectralScanner(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            Box box = new Box(user.getBlockPos()).expand(24);
            world.getEntitiesByClass(LivingEntity.class, box, entity ->
                    user.getBlockPos().isWithinDistance(entity.getBlockPos(), 25) && entity instanceof PlayerEntity
                            && entity != user && entity.hasStatusEffect(StatusEffects.INVISIBILITY))
                    .forEach(entity -> {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,
                            3 * 20, 0 , true, true, true));
                        entity.playSound(SoundEvents.BLOCK_BELL_USE, 1.0f, 1.0f);
                    });
            user.getStackInHand(hand).damage(1, null, (ServerPlayerEntity) user);
            user.getItemCooldownManager().set(this, 45 * 20);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Detects Invisible Players"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
