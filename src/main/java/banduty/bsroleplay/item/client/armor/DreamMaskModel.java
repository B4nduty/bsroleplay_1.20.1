package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.DreamMaskItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DreamMaskModel extends GeoModel<DreamMaskItem> {

    @Override
    public Identifier getModelResource(DreamMaskItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/dream_mask.geo.json");
    }

    @Override
    public Identifier getTextureResource(DreamMaskItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/dream_mask.png");
    }

    @Override
    public Identifier getAnimationResource(DreamMaskItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
