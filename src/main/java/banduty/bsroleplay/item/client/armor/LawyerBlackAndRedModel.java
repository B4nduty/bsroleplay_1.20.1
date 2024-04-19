package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.LawyerBlackAndRedItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class LawyerBlackAndRedModel extends GeoModel<LawyerBlackAndRedItem> {

    @Override
    public Identifier getModelResource(LawyerBlackAndRedItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/lawyer.geo.json");
    }

    @Override
    public Identifier getTextureResource(LawyerBlackAndRedItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/lawyer_black_and_red.png");
    }

    @Override
    public Identifier getAnimationResource(LawyerBlackAndRedItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
