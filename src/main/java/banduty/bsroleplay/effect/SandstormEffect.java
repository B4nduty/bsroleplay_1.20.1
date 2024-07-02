package banduty.bsroleplay.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

public class SandstormEffect extends StatusEffect {
    protected SandstormEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient) {
            entity.damage(entity.getWorld().getDamageSources().magic(), 0.25f);
        }
        int color = 16749568;
        float red = ColorHelper.Argb.getRed(color) / 255.0F;
        float green = ColorHelper.Argb.getGreen(color) / 255.0F;
        float blue = ColorHelper.Argb.getBlue(color) / 255.0F;

        double centerX = entity.getX();
        double centerY = entity.getY() + entity.getHeight() / 2.0;
        double centerZ = entity.getZ();

        int layerCount = 6;
        int particlesPerLayer = 15;
        double maxRadius = 1.0;

        for (int layer = 0; layer < layerCount; layer++) {
            double layerRadius = maxRadius * ((double) (layer + 1) / (double) layerCount);

            for (int i = 0; i < particlesPerLayer; i++) {
                double angle = Math.toRadians(i * (360.0 / particlesPerLayer));
                double yOffset = MathHelper.nextDouble(entity.getRandom(), -0.7, 0.3);
                double xOffset = Math.cos(angle) * layerRadius * 0.5;
                double zOffset = Math.sin(angle) * layerRadius * 0.5;

                double swirlFactor = 0.1;
                double swirlX = Math.sin(entity.age * swirlFactor + i * 0.5);
                double swirlZ = Math.cos(entity.age * swirlFactor + i * 0.5);

                double oscillationFactor = 0.05;
                double oscillationY = Math.sin(entity.age * oscillationFactor + i * 0.3) * 0.2;

                Vec3d offset = new Vec3d(xOffset + swirlX, yOffset + oscillationY, zOffset + swirlZ);

                entity.getEntityWorld().addParticle(new DustParticleEffect(
                                new Vector3f(red, green, blue),
                                1.0f
                        ),
                        centerX + offset.x,
                        centerY + offset.y,
                        centerZ + offset.z,
                        0, 0, 0
                );
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}