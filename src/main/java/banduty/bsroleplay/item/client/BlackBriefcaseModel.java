package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.BlackBriefCase;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BlackBriefcaseModel extends GeoModel<BlackBriefCase> {

    @Override
    public Identifier getModelResource(BlackBriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/briefcase.geo.json");
    }

    @Override
    public Identifier getTextureResource(BlackBriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/item/black_briefcase.png");
    }

    @Override
    public Identifier getAnimationResource(BlackBriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
