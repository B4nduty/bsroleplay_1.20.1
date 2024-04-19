package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.LawyerBlackAndBlueItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class LawyerBlackAndBlueModel extends GeoModel<LawyerBlackAndBlueItem> {

    @Override
    public Identifier getModelResource(LawyerBlackAndBlueItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/lawyer.geo.json");
    }

    @Override
    public Identifier getTextureResource(LawyerBlackAndBlueItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/lawyer_black_and_blue.png");
    }

    @Override
    public Identifier getAnimationResource(LawyerBlackAndBlueItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
