package banduty.bsroleplay.entity.client;


import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.custom.HolyCloudEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

// Made with Blockbench 4.9.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class HolyCloudModel extends GeoModel<HolyCloudEntity> {
	@Override
	public Identifier getModelResource(HolyCloudEntity animatable) {
		return new Identifier(BsRolePlay.MOD_ID, "geo/holy_cloud.geo.json");
	}

	@Override
	public Identifier getTextureResource(HolyCloudEntity animatable) {
		return new Identifier(BsRolePlay.MOD_ID, "textures/entity/holy_cloud.png");
	}

	@Override
	public Identifier getAnimationResource(HolyCloudEntity animatable) {
		return new Identifier(BsRolePlay.MOD_ID, "animations/holy_cloud.animation.json");
	}

	@Override
	public void setCustomAnimations(HolyCloudEntity animatable, long instanceId, AnimationState<HolyCloudEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
			head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
		}
	}
}