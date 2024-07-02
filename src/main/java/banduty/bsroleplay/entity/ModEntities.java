package banduty.bsroleplay.entity;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.custom.SandstormProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SandstormProjectileEntity> SANDSTORM_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BsRolePlay.MOD_ID, "sandstorm_projectile"),
            FabricEntityTypeBuilder.<SandstormProjectileEntity>create(SpawnGroup.MISC, SandstormProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static void registerModEntities() {
        BsRolePlay.LOGGER.info("Registering Entities for " + BsRolePlay.MOD_ID);
    }
}
