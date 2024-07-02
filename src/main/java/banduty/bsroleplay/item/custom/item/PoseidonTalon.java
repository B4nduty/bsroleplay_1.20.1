
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.effect.ModEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;

public class PoseidonTalon extends Item {
    public PoseidonTalon(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        if (player != null) {
            Vec3d playerPos = player.getPos();
            double maxRadius = 4.0;
            int particlesPerCircle = 50;
            int animationFrames = 4;

            for (int frame = 0; frame < animationFrames; frame++) {
                double progress = (double) frame / animationFrames;

                for (int i = 0; i < particlesPerCircle; i++) {
                    double angle = (2 * Math.PI / particlesPerCircle) * i;

                    double offsetX = Math.cos(angle) * maxRadius * progress;
                    double offsetZ = Math.sin(angle) * maxRadius * progress;

                    double particleX = playerPos.getX() + offsetX;
                    double particleY = playerPos.getY() + 0.1;
                    double particleZ = playerPos.getZ() + offsetZ;

                    int color = 16776960;
                    float red = ColorHelper.Argb.getRed(color) / 255.0F;
                    float green = ColorHelper.Argb.getGreen(color) / 255.0F;
                    float blue = ColorHelper.Argb.getBlue(color) / 255.0F;

                    world.addParticle(new DustParticleEffect(
                                    new Vector3f(red, green, blue),
                                    1.0f
                            ),
                            particleX,
                            particleY,
                            particleZ,
                            0f, 0f, 0f);
                }
            }
            if (!world.isClient) {
                Box detectionBox = new Box(player.getBlockPos()).expand(4);
                double maxDistance = 4.0;

                world.getEntitiesByClass(LivingEntity.class, detectionBox, entity ->
                                entity != player && player.getBlockPos().isWithinDistance(entity.getBlockPos(), 5))
                        .forEach(entity -> {
                            Vec3d entityPos = entity.getPos();
                            Vec3d direction = entityPos.subtract(playerPos).normalize();

                            double distance = playerPos.distanceTo(entityPos);
                            double knockbackStrength = 20.0 - (distance / maxDistance);

                            entity.takeKnockback(knockbackStrength, -direction.x, -direction.z);

                            entity.addStatusEffect(new StatusEffectInstance(ModEffects.TIDAL_SURGE,
                                    6 * 20, 0, true, false, true));
                        });
            }

            player.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getPoseidonTalonCooldown() * 20);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.common.showItemTooltips) {
            tooltip.add(Text.translatable("tooltip.bsroleplay.poseidon_talon.tooltip"));
            super.appendTooltip(stack, world, tooltip, context);
        }
    }
}
