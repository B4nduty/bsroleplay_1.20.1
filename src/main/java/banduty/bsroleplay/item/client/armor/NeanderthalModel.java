package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.NeanderthalItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class NeanderthalModel extends GeoModel<NeanderthalItem> {

    @Override
    public Identifier getModelResource(NeanderthalItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/neanderthal.geo.json");
    }

    @Override
    public Identifier getTextureResource(NeanderthalItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/neanderthal.png");
    }

    @Override
    public Identifier getAnimationResource(NeanderthalItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
