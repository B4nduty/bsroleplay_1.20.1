package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.LawyerBlackAndGoldItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class LawyerBlackAndGoldModel extends GeoModel<LawyerBlackAndGoldItem> {

    @Override
    public Identifier getModelResource(LawyerBlackAndGoldItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/lawyer.geo.json");
    }

    @Override
    public Identifier getTextureResource(LawyerBlackAndGoldItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/lawyer_black_and_gold.png");
    }

    @Override
    public Identifier getAnimationResource(LawyerBlackAndGoldItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
