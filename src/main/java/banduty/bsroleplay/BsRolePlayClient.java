package banduty.bsroleplay;

import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.block.entity.renderer.HolyCloudGeneratorBlockEntityRenderer;
import banduty.bsroleplay.entity.ModEntities;
import banduty.bsroleplay.entity.client.HolyCloudRenderer;
import banduty.bsroleplay.screen.HolyCloudGeneratorScreen;
import banduty.bsroleplay.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class BsRolePlayClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.HOLY_CLOUD_GENERATOR_SCREEN_HANDLER, HolyCloudGeneratorScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.HOLY_CLOUD_GENERATOR_STATION_BLOCK_ENTITY, HolyCloudGeneratorBlockEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.HOLY_CLOUD, HolyCloudRenderer::new);
    }
}
