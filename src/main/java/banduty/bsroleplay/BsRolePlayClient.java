
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
import banduty.bsroleplay.block.entity.client.shops.creative_shop.CreativeShopRenderer;
import banduty.bsroleplay.block.entity.client.shops.shop.ShopRenderer;
import banduty.bsroleplay.client.GrayscaleOverlay;
import banduty.bsroleplay.client.StaminaOverlay;
import banduty.bsroleplay.entity.ModEntities;
import banduty.bsroleplay.event.KeyInputHandler;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.networking.ModMessages;
import banduty.bsroleplay.screen.ModScreenHandlers;
import banduty.bsroleplay.screen.creative_shop.CreativeShopScreen;
import banduty.bsroleplay.screen.shop.ShopScreen;
import banduty.bsroleplay.screen.wallet.WalletScreen;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.DyeableItem;

public class BsRolePlayClient implements ClientModInitializer {
    private static int angle = 0;
    private static int angleTickCounter = 0;
    private static int height = 0;
    private static boolean increasing = true;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            angleTickCounter++;
            if (angleTickCounter >= 1) {
                angleTickCounter = 0;
                angle = (angle + 1) % 361;
                if (angle == 360) angle = 0;
                if (increasing) {
                    height++;
                    if (height >= 100) increasing = false;
                } else {
                    height--;
                    if (height <= 0) increasing = true;
                }
            }
        });
        BlockEntityRendererRegistry.register(ModBlockEntities.SHOP_BLOCK_ENTITY, ShopRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.CREATIVE_SHOP_BLOCK_ENTITY, CreativeShopRenderer::new);
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
        HandledScreens.register(ModScreenHandlers.SHOP_SCREEN_HANDLER, ShopScreen::new);
        HandledScreens.register(ModScreenHandlers.CREATIVE_SHOP_SCREEN_HANDLER, CreativeShopScreen::new);

        HudRenderCallback.EVENT.register(new StaminaOverlay());
        HudRenderCallback.EVENT.register(new GrayscaleOverlay());

        ModMessages.registerS2CPackets();

        KeyInputHandler.register();

        EntityRendererRegistry.register(ModEntities.SANDSTORM_PROJECTILE, FlyingItemEntityRenderer::new);
    }

    public static int getAngle() {
        return angle;
    }

    public static int getHeight() {
        return height;
    }
}