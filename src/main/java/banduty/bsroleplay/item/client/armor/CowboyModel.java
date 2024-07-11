package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.CowboyArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CowboyModel extends GeoModel<CowboyArmorItem> {

    @Override
    public Identifier getModelResource(CowboyArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/cowboy.geo.json");
    }

    @Override
    public Identifier getTextureResource(CowboyArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/cowboy.png");
    }

    @Override
    public Identifier getAnimationResource(CowboyArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
