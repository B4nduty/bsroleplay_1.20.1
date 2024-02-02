package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.RomanEmperorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class RomanEmperorModel extends GeoModel<RomanEmperorItem> {

    @Override
    public Identifier getModelResource(RomanEmperorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/roman_emperor.geo.json");
    }

    @Override
    public Identifier getTextureResource(RomanEmperorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/roman_emperor.png");
    }

    @Override
    public Identifier getAnimationResource(RomanEmperorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
