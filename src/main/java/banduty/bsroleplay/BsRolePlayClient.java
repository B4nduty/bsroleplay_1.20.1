package banduty.bsroleplay;

import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.block.entity.client.coins.BronzeCoinRenderer;
import banduty.bsroleplay.block.entity.client.coins.GoldCoinRenderer;
import banduty.bsroleplay.block.entity.client.coins.NetheriteCoinRenderer;
import banduty.bsroleplay.block.entity.client.coins.stack.BronzeCoinStackRenderer;
import banduty.bsroleplay.block.entity.client.TinyBandutyRenderer;
import banduty.bsroleplay.block.entity.client.coins.stack.GoldCoinStackRenderer;
import banduty.bsroleplay.block.entity.client.coins.stack.NetheriteCoinStackRenderer;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class BsRolePlayClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.TINY_BANDUTY_BLOCK_ENTITY, TinyBandutyRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.BRONZE_COIN_BLOCK_ENTITY, BronzeCoinRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.GOLD_COIN_BLOCK_ENTITY, GoldCoinRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.NETHERITE_COIN_BLOCK_ENTITY, NetheriteCoinRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.BRONZE_COIN_STACK_BLOCK_ENTITY, BronzeCoinStackRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.GOLD_COIN_STACK_BLOCK_ENTITY, GoldCoinStackRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.NETHERITE_COIN_STACK_BLOCK_ENTITY, NetheriteCoinStackRenderer::new);
    }
}