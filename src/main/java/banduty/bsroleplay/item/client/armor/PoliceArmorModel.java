package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.PoliceArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class PoliceArmorModel extends GeoModel<PoliceArmorItem> {

    @Override
    public Identifier getModelResource(PoliceArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/police_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(PoliceArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/police_armor.png");
    }

    @Override
    public Identifier getAnimationResource(PoliceArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
