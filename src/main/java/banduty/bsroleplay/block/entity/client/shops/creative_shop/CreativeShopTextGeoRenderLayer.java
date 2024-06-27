package banduty.bsroleplay.block.entity.client.shops.creative_shop;

import banduty.bsroleplay.block.entity.shops.CreativeShopBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.Objects;

public class CreativeShopTextGeoRenderLayer extends GeoRenderLayer<CreativeShopBlockEntity> {
    public CreativeShopTextGeoRenderLayer(GeoRenderer<CreativeShopBlockEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack poseStack, CreativeShopBlockEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType,
                       VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        float x;
        if (animatable.getCurrencyCounter() >= 10000) x = -0.1f;
        else if (animatable.getCurrencyCounter() >= 1000) x = -0.075f;
        else if (animatable.getCurrencyCounter() >= 100) x = -0.05f;
        else if (animatable.getCurrencyCounter() >= 10) x = -0.025f;
        else x = 0f;
        poseStack.translate(x, 0.35f, -0.38f);
        poseStack.scale(0.01f, 0.01f, 0.01f);
        poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
        textRenderer.draw(Text.literal("RP"), 1f, 1f, 0xffffff, false,
                poseStack.peek().getPositionMatrix(), bufferSource, TextRenderer.TextLayerType.NORMAL, 0,
                getLightLevel(Objects.requireNonNull(animatable.getWorld()), animatable.getPos()));
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}