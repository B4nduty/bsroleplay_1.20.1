package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.GadgetHatItem;
import banduty.bsroleplay.mixin.DyeableGeoArmorRendererInvoker;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class GadgetHatOverlay extends GeoRenderLayer<GadgetHatItem> {
    private static final Identifier TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/armor/gadget_overlay.png");

    public GadgetHatOverlay(GeoRenderer<GadgetHatItem> entityRenderer) {
        super(entityRenderer);
    }

    private GeoBone getBoneYouAreInterestedIn(BakedGeoModel bakedModel) {
        return bakedModel.topLevelBones().stream().findFirst().orElse(null);
    }

    @Override
    public void render(MatrixStack poseStack, GadgetHatItem animatable, BakedGeoModel bakedModel, RenderLayer renderType,
                       VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderLayer armorRenderType = RenderLayer.getArmorCutoutNoCull(TEXTURE);
        GeoBone bone = getBoneYouAreInterestedIn(bakedModel);
        DyeableGeoArmorRendererInvoker invoker = (DyeableGeoArmorRendererInvoker) getRenderer();

        Color colorObj = invoker.invokeGetColorForBone(bone);
        int color = colorObj.getColor();
        var r = ColorHelper.Argb.getRed(color);
        var g = ColorHelper.Argb.getGreen(color);
        var b = ColorHelper.Argb.getBlue(color);

        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.DEFAULT_UV,
                (float) r / 375, (float) g / 375, (float) b / 375, 1);
    }
}