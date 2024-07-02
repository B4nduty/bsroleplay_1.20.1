package banduty.bsroleplay.entity.custom;

import banduty.bsroleplay.effect.ModEffects;
import banduty.bsroleplay.entity.ModEntities;
import banduty.bsroleplay.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class SandstormProjectileEntity extends ThrownItemEntity {
    public SandstormProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public SandstormProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.SANDSTORM_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SANDSTORM_PROJECTILE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        BlockPos center = entityHitResult.getEntity().getBlockPos();
        int radius = 8;
        BlockPos corner1 = new BlockPos(
                center.getX() - radius,
                center.getY() - radius,
                center.getZ() - radius
        );

        BlockPos corner2 = new BlockPos(
                center.getX() + radius,
                center.getY() + radius,
                center.getZ() + radius
        );
        if (!this.getWorld().isClient) {
            spawnHollowCubeParticles(corner1, corner2, (ServerWorld) this.getWorld());
            this.getWorld().sendEntityStatus(this, (byte) 3);
            Box box = new Box(center).expand(8);
            this.getWorld().getEntitiesByClass(LivingEntity.class, box, entity ->
                            center.isWithinDistance(entity.getBlockPos(), 9) && entity instanceof PlayerEntity playerEntity &&
                                    !(playerEntity.getInventory().getArmorStack(3).getItem() instanceof ArmorItem armorItem && armorItem == ModItems.FUNERAL_MASK))
                    .forEach(entity -> entity.addStatusEffect(new StatusEffectInstance(ModEffects.SANDSTORM,
                            15 * 20, 0 , true, false, true)));
        }
        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        BlockPos center = blockHitResult.getBlockPos();
        int radius = 8;
        BlockPos corner1 = new BlockPos(
                center.getX() - radius,
                center.getY() - radius,
                center.getZ() - radius
        );

        BlockPos corner2 = new BlockPos(
                center.getX() + radius,
                center.getY() + radius,
                center.getZ() + radius
        );

        if (!this.getWorld().isClient) {
            spawnHollowCubeParticles(corner1, corner2, (ServerWorld) this.getWorld());
            this.getWorld().sendEntityStatus(this, (byte) 3);
            Box box = new Box(center).expand(8);
            this.getWorld().getEntitiesByClass(LivingEntity.class, box, entity ->
                            center.isWithinDistance(entity.getBlockPos(), 9) && entity instanceof PlayerEntity playerEntity &&
                                    !(playerEntity.getInventory().getArmorStack(3).getItem() instanceof ArmorItem armorItem && armorItem == ModItems.FUNERAL_MASK))
                    .forEach(entity -> entity.addStatusEffect(new StatusEffectInstance(ModEffects.SANDSTORM,
                            15 * 20, 0 , true, false, true)));
        }
        this.discard();
    }

    public static void spawnHollowCubeParticles(BlockPos corner1, BlockPos corner2, ServerWorld world) {
        List<BlockPos> result = new ArrayList<>();
        int minX = Math.min(corner1.getX(), corner2.getX());
        int minY = Math.min(corner1.getY(), corner2.getY());
        int minZ = Math.min(corner1.getZ(), corner2.getZ());
        int maxX = Math.max(corner1.getX(), corner2.getX());
        int maxY = Math.max(corner1.getY(), corner2.getY());
        int maxZ = Math.max(corner1.getZ(), corner2.getZ());

        // Top and bottom faces
        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                result.add(new BlockPos(x, minY, z));
                result.add(new BlockPos(x, maxY, z));
            }
        }

        // Front and back faces
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                result.add(new BlockPos(x, y, minZ));
                result.add(new BlockPos(x, y, maxZ));
            }
        }

        // Left and right faces
        for (int z = minZ; z <= maxZ; z++) {
            for (int y = minY; y <= maxY; y++) {
                result.add(new BlockPos(minX, y, z));
                result.add(new BlockPos(maxX, y, z));
            }
        }

        // Spawn particles at calculated positions
        for (BlockPos pos : result) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.5;
            double z = pos.getZ() + 0.5;

            int color = 16749568;
            float red = ColorHelper.Argb.getRed(color) / 255.0F;
            float green = ColorHelper.Argb.getGreen(color) / 255.0F;
            float blue = ColorHelper.Argb.getBlue(color) / 255.0F;

            world.spawnParticles(new DustParticleEffect(new Vector3f(red, green, blue), 1.0f), x, y, z,
                    1, 0.0, 0.0, 0.0, 0.0);
        }
    }
}
