package banduty.bsroleplay.block.entity;
import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.ModBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<HolyCloudStatueEntity> HOLY_CLOUD_STATUE_ENTITY;

    public static void registerAllBlockEntities() {
        HOLY_CLOUD_STATUE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "holy_cloud_statue_entity"),
                FabricBlockEntityTypeBuilder.create(HolyCloudStatueEntity::new,
                        ModBlock.HOLY_CLOUD_STATUE).build());
    }
}