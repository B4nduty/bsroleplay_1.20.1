package banduty.bsroleplay.entity.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.custom.HolyCloudEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HolyCloudRenderer extends GeoEntityRenderer<HolyCloudEntity> {
    public HolyCloudRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new HolyCloudModel());
    }

    @Override
    public Identifier getTextureLocation(HolyCloudEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/entity/holy_cloud.png");
    }

    @Override
    public void render(HolyCloudEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f,0.5f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
