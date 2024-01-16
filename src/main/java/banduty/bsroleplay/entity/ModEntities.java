package banduty.bsroleplay.entity;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.custom.HolyCloudEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<HolyCloudEntity> HOLY_CLOUD = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(BsRolePlay.MOD_ID, "holy_cloud"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HolyCloudEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 0.6875f)).build());

    public static void registerModEntities() {
        BsRolePlay.LOGGER.info("Registering Entities for " + BsRolePlay.MOD_ID);
    }

}


