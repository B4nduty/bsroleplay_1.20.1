package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.CowboyItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CowboyModel extends GeoModel<CowboyItem> {

    @Override
    public Identifier getModelResource(CowboyItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/cowboy.geo.json");
    }

    @Override
    public Identifier getTextureResource(CowboyItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/cowboy.png");
    }

    @Override
    public Identifier getAnimationResource(CowboyItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
