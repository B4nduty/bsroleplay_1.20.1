package banduty.bsroleplay.effect;

import banduty.bsroleplay.networking.ModMessages;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.UUID;

public class TidalSurgeEffect extends StatusEffect {
    private static final UUID TIDAL_SURGE_STRENGTH_REDUCTION_UUID = UUID.fromString("d2c91d90-3d3c-11eb-adc1-0242ac120002");
    private static final String TIDAL_SURGE_STRENGTH_REDUCTION_NAME = "Tidal Surge Strength Reduction";
    private static final double STRENGTH_REDUCTION_AMOUNT = -2.0;

    protected TidalSurgeEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient) {
            double velocityX = entity.getVelocity().x * 0.4;
            double velocityY = entity.getVelocity().y * 0.4;
            double velocityZ = entity.getVelocity().z * 0.4;
            entity.setVelocity(velocityX, velocityY, velocityZ);

            if (entity instanceof PlayerEntity player) {
                PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
                buf.writeInt(player.getId());
                buf.writeDouble(velocityX);
                buf.writeDouble(velocityY);
                buf.writeDouble(velocityZ);
                ServerPlayNetworking.send((ServerPlayerEntity) player, ModMessages.VELOCITY_UPDATE_ID, buf);
            }

            EntityAttributeInstance attributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            if (attributeInstance != null) {
                EntityAttributeModifier modifier = new EntityAttributeModifier(
                        TIDAL_SURGE_STRENGTH_REDUCTION_UUID,
                        TIDAL_SURGE_STRENGTH_REDUCTION_NAME,
                        STRENGTH_REDUCTION_AMOUNT,
                        EntityAttributeModifier.Operation.ADDITION
                );
                if (!attributeInstance.hasModifier(modifier)) {
                    attributeInstance.addTemporaryModifier(modifier);
                }
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        EntityAttributeInstance attackDamage = attributes.getCustomInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackDamage != null) {
            attackDamage.removeModifier(TIDAL_SURGE_STRENGTH_REDUCTION_UUID);
        }
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
