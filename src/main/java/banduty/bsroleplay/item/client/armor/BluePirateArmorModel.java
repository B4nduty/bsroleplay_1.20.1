package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.BluePirateArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BluePirateArmorModel extends GeoModel<BluePirateArmorItem> {

    @Override
    public Identifier getModelResource(BluePirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/pirate_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(BluePirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/blue_pirate_armor.png");
    }

    @Override
    public Identifier getAnimationResource(BluePirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
