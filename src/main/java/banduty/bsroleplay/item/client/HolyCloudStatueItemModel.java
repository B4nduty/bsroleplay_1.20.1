package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.HolyCloudStatueItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class HolyCloudStatueItemModel extends GeoModel<HolyCloudStatueItem> {
    @Override
    public Identifier getModelResource(HolyCloudStatueItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/holy_cloud_statue.geo.json");
    }

    @Override
    public Identifier getTextureResource(HolyCloudStatueItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/holy_cloud_statue.png");
    }

    @Override
    public Identifier getAnimationResource(HolyCloudStatueItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/holy_cloud_statue.animation.json");
    }
}
