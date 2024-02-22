package banduty.bsroleplay.block.entity.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.HolyCloudStatueEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class HolyCloudStatueModel extends GeoModel<HolyCloudStatueEntity> {
    @Override
    public Identifier getModelResource(HolyCloudStatueEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/holy_cloud_statue.geo.json");
    }

    @Override
    public Identifier getTextureResource(HolyCloudStatueEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/holy_cloud_statue.png");
    }

    @Override
    public Identifier getAnimationResource(HolyCloudStatueEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/holy_cloud_statue.animation.json");
    }
}
