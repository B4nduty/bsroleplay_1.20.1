package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.RedPirateArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class RedPirateArmorModel extends GeoModel<RedPirateArmorItem> {
    @Override
    public Identifier getModelResource(RedPirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/pirate_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(RedPirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/red_pirate_armor.png");
    }

    @Override
    public Identifier getAnimationResource(RedPirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
