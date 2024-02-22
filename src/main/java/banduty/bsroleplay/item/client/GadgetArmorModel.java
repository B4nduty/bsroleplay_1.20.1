package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.GadgetArmor;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GadgetArmorModel extends GeoModel<GadgetArmor> {

    @Override
    public Identifier getModelResource(GadgetArmor animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/gadget.geo.json");
    }

    @Override
    public Identifier getTextureResource(GadgetArmor animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/gadget.png");
    }

    @Override
    public Identifier getAnimationResource(GadgetArmor animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/gadget.animation.json");
    }
}
