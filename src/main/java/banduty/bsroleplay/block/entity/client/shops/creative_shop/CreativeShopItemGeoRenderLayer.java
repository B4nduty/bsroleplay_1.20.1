package banduty.bsroleplay.block.entity.client.shops.creative_shop;

import banduty.bsroleplay.BsRolePlayClient;
import banduty.bsroleplay.block.entity.shops.CreativeShopBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.Objects;

public class CreativeShopItemGeoRenderLayer extends GeoRenderLayer<CreativeShopBlockEntity> {
    public CreativeShopItemGeoRenderLayer(GeoRenderer<CreativeShopBlockEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack poseStack, CreativeShopBlockEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType,
                       VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = animatable.getRenderStack();
        poseStack.push();
        poseStack.translate(0f, 0.7f + (float) BsRolePlayClient.getHeight() / 2000, 0f);
        poseStack.scale(0.5f, 0.5f, 0.5f);
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(BsRolePlayClient.getAngle()));

        itemRenderer.renderItem(stack, ModelTransformationMode.GROUND, getLightLevel(Objects.requireNonNull(animatable.getWorld()),
                animatable.getPos()), OverlayTexture.DEFAULT_UV, poseStack, bufferSource, animatable.getWorld(), 1);
        poseStack.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}