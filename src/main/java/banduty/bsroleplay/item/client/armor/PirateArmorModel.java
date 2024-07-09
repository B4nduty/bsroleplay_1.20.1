package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.PirateArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class PirateArmorModel extends GeoModel<PirateArmorItem> {

    @Override
    public Identifier getModelResource(PirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/pirate_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(PirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/pirate_armor.png");
    }

    @Override
    public Identifier getAnimationResource(PirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
