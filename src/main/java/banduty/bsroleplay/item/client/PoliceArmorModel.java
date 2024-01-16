package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.PoliceArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class PoliceArmorModel extends GeoModel<PoliceArmorItem> {

    @Override
    public Identifier getModelResource(PoliceArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/police_armor_3d.geo.json");
    }

    @Override
    public Identifier getTextureResource(PoliceArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/police_armor_3d.png");
    }

    @Override
    public Identifier getAnimationResource(PoliceArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
