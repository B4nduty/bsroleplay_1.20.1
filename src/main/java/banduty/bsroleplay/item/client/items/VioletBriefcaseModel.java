package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.item.VioletBriefCase;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class VioletBriefcaseModel extends GeoModel<VioletBriefCase> {

    @Override
    public Identifier getModelResource(VioletBriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/briefcase.geo.json");
    }

    @Override
    public Identifier getTextureResource(VioletBriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/item/violet_briefcase.png");
    }

    @Override
    public Identifier getAnimationResource(VioletBriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
