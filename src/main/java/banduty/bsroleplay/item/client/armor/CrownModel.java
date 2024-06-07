package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.armor.CrownItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CrownModel extends GeoModel<CrownItem> {

    @Override
    public Identifier getModelResource(CrownItem animatable) {
        if (animatable == ModItems.CROWN) return new Identifier(BsRolePlay.MOD_ID, "geo/crown.geo.json");
        if (animatable == ModItems.MINI_CROWN) return new Identifier(BsRolePlay.MOD_ID, "geo/mini_crown.geo.json");
        return new Identifier("missing");
    }

    @Override
    public Identifier getTextureResource(CrownItem animatable) {
        if (animatable == ModItems.CROWN) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/crown.png");
        if (animatable == ModItems.MINI_CROWN) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/mini_crown.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(CrownItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
