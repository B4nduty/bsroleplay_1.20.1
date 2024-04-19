package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.CrownItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CrownModel extends GeoModel<CrownItem> {

    @Override
    public Identifier getModelResource(CrownItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/crown.geo.json");
    }

    @Override
    public Identifier getTextureResource(CrownItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/crown.png");
    }

    @Override
    public Identifier getAnimationResource(CrownItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
