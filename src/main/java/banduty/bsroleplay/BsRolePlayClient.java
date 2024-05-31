
package banduty.bsroleplay;

import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.block.entity.client.TinyBandutyRenderer;
import banduty.bsroleplay.block.entity.client.coins.AmethystCoinRenderer;
import banduty.bsroleplay.block.entity.client.coins.CopperCoinRenderer;
import banduty.bsroleplay.block.entity.client.coins.GoldCoinRenderer;
import banduty.bsroleplay.block.entity.client.coins.NetheriteCoinRenderer;
import banduty.bsroleplay.block.entity.client.coins.stack.AmethystCoinStackRenderer;
import banduty.bsroleplay.block.entity.client.coins.stack.CopperCoinStackRenderer;
import banduty.bsroleplay.block.entity.client.coins.stack.GoldCoinStackRenderer;
import banduty.bsroleplay.block.entity.client.coins.stack.NetheriteCoinStackRenderer;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.screen.ModScreenHandlers;
import banduty.bsroleplay.screen.WalletScreen;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.DyeableItem;

public class BsRolePlayClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.TINY_BANDUTY_BLOCK_ENTITY, TinyBandutyRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.COPPER_COIN_BLOCK_ENTITY, CopperCoinRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.GOLD_COIN_BLOCK_ENTITY, GoldCoinRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.AMETHYST_COIN_BLOCK_ENTITY, AmethystCoinRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.NETHERITE_COIN_BLOCK_ENTITY, NetheriteCoinRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.COPPER_COIN_STACK_BLOCK_ENTITY, CopperCoinStackRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.GOLD_COIN_STACK_BLOCK_ENTITY, GoldCoinStackRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.AMETHYST_COIN_STACK_BLOCK_ENTITY, AmethystCoinStackRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.NETHERITE_COIN_STACK_BLOCK_ENTITY, NetheriteCoinStackRenderer::new);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
                tintIndex > 0 ? -1 : ((DyeableItem) stack.getItem()).getColor(stack), ModItems.WALLET);

        HandledScreens.register(ModScreenHandlers.WALLET_SCREEN_HANDLER, WalletScreen::new);
    }
}