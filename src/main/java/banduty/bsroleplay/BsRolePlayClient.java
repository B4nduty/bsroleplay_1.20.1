package banduty.bsroleplay;

import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.block.entity.client.HolyCloudStatueRenderer;
import banduty.bsroleplay.block.entity.client.TinyBandutyRenderer;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class BsRolePlayClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.HOLY_CLOUD_STATUE_ENTITY, HolyCloudStatueRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.TINY_BANDUTY_ENTITY, TinyBandutyRenderer::new);
    }
}
