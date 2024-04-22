package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.item.TinyBandutyItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TinyBandutyItemModel extends GeoModel<TinyBandutyItem> {
    @Override
    public Identifier getModelResource(TinyBandutyItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/tiny_banduty.geo.json");
    }

    @Override
    public Identifier getTextureResource(TinyBandutyItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/tiny_banduty.png");
    }

    @Override
    public Identifier getAnimationResource(TinyBandutyItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
