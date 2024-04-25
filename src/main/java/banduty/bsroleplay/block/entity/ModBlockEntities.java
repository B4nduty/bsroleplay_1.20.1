package banduty.bsroleplay.block.entity;
import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.ModBlock;
import banduty.bsroleplay.block.entity.coins.BronzeCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.GoldCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.NetheriteCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.BronzeCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.GoldCoinStackBlockEntity;
import banduty.bsroleplay.block.entity.coins.stack.NetheriteCoinStackBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<TinyBandutyBlockEntity> TINY_BANDUTY_BLOCK_ENTITY;
    public static BlockEntityType<BronzeCoinBlockEntity> BRONZE_COIN_BLOCK_ENTITY;
    public static BlockEntityType<GoldCoinBlockEntity> GOLD_COIN_BLOCK_ENTITY;
    public static BlockEntityType<NetheriteCoinBlockEntity> NETHERITE_COIN_BLOCK_ENTITY;
    public static BlockEntityType<BronzeCoinStackBlockEntity> BRONZE_COIN_STACK_BLOCK_ENTITY;
    public static BlockEntityType<GoldCoinStackBlockEntity> GOLD_COIN_STACK_BLOCK_ENTITY;
    public static BlockEntityType<NetheriteCoinStackBlockEntity> NETHERITE_COIN_STACK_BLOCK_ENTITY;

    public static void registerAllBlockEntities() {
        TINY_BANDUTY_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "tiny_banduty_block_entity"),
                FabricBlockEntityTypeBuilder.create(TinyBandutyBlockEntity::new,
                        ModBlock.TINY_BANDUTY).build());

        BRONZE_COIN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "bronze_coin_block_entity"),
                FabricBlockEntityTypeBuilder.create(BronzeCoinBlockEntity::new,
                        ModBlock.BRONZE_COIN).build());

        GOLD_COIN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "gold_coin_block_entity"),
                FabricBlockEntityTypeBuilder.create(GoldCoinBlockEntity::new,
                        ModBlock.GOLD_COIN).build());

        NETHERITE_COIN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "netherite_coin_block_entity"),
                FabricBlockEntityTypeBuilder.create(NetheriteCoinBlockEntity::new,
                        ModBlock.NETHERITE_COIN).build());

        BRONZE_COIN_STACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "bronze_coin_stack_block_entity"),
                FabricBlockEntityTypeBuilder.create(BronzeCoinStackBlockEntity::new,
                        ModBlock.BRONZE_COIN_STACK).build());

        GOLD_COIN_STACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "gold_coin_stack_block_entity"),
                FabricBlockEntityTypeBuilder.create(GoldCoinStackBlockEntity::new,
                        ModBlock.GOLD_COIN_STACK).build());

        NETHERITE_COIN_STACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(BsRolePlay.MOD_ID, "netherite_coin_stack_block_entity"),
                FabricBlockEntityTypeBuilder.create(NetheriteCoinStackBlockEntity::new,
                        ModBlock.NETHERITE_COIN_STACK).build());
    }
}