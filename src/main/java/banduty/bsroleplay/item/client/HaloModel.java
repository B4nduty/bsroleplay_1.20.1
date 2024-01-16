package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.HaloItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class HaloModel extends GeoModel<HaloItem> {

    @Override
    public Identifier getModelResource(HaloItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/halo.geo.json");
    }

    @Override
    public Identifier getTextureResource(HaloItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/halo.png");
    }

    @Override
    public Identifier getAnimationResource(HaloItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/halo.animation.json");
    }
}
