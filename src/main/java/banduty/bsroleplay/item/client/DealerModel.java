package banduty.bsroleplay.item.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.DealerItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DealerModel extends GeoModel<DealerItem> {

    @Override
    public Identifier getModelResource(DealerItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/dealer.geo.json");
    }

    @Override
    public Identifier getTextureResource(DealerItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/dealer.png");
    }

    @Override
    public Identifier getAnimationResource(DealerItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
