package banduty.bsroleplay.block.entity;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<HolyCloudGeneratorBlockEntity> HOLY_CLOUD_GENERATOR_STATION_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(BsRolePlay.MOD_ID, "holy_cloud_be"),
                    FabricBlockEntityTypeBuilder.create(HolyCloudGeneratorBlockEntity::new,
                            ModBlocks.HOLY_CLOUD_GENERATOR_STATION).build());

    public static void registerBlockEntities() {
        BsRolePlay.LOGGER.info("Registering Block Entities for " + BsRolePlay.MOD_ID);
    }
}
