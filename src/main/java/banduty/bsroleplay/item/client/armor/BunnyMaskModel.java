package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.BunnyMaskItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BunnyMaskModel extends GeoModel<BunnyMaskItem> {

    @Override
    public Identifier getModelResource(BunnyMaskItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/bunny_mask.geo.json");
    }

    @Override
    public Identifier getTextureResource(BunnyMaskItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/bunny_mask.png");
    }

    @Override
    public Identifier getAnimationResource(BunnyMaskItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
