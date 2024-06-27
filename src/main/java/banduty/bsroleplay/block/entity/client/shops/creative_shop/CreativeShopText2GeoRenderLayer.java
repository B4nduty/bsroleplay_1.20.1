package banduty.bsroleplay.block.entity.client.shops.creative_shop;

import banduty.bsroleplay.block.entity.shops.CreativeShopBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.Objects;

public class CreativeShopText2GeoRenderLayer extends GeoRenderLayer<CreativeShopBlockEntity> {
    public CreativeShopText2GeoRenderLayer(GeoRenderer<CreativeShopBlockEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack poseStack, CreativeShopBlockEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType,
                       VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        float x;
        int currencyCounter = animatable.getCurrencyCounter();
        if (currencyCounter >= 10000) x = -35f;
        else if (currencyCounter >= 1000) x = -30f;
        else if (currencyCounter >= 100) x = -25f;
        else if (currencyCounter >= 10) x = -20f;
        else x = -15f;
        poseStack.translate(x, 0f, 0f);
        poseStack.scale(1f, 1f, 1f);
        textRenderer.draw(String.valueOf(currencyCounter), 1f, 1f, 0xffffff, false,
                poseStack.peek().getPositionMatrix(), bufferSource, TextRenderer.TextLayerType.NORMAL, 0,
                getLightLevel(Objects.requireNonNull(animatable.getWorld()), animatable.getPos()), true);
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}