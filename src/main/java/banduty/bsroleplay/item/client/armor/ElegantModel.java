package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.armor.ElegantItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ElegantModel extends GeoModel<ElegantItem> {

    @Override
    public Identifier getModelResource(ElegantItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/elegant.geo.json");
    }

    @Override
    public Identifier getTextureResource(ElegantItem animatable) {
        if (animatable == ModItems.FEDORA) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/elegant.png");
        if (animatable == ModItems.FEDORA_PURPLE) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/elegant_purple.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(ElegantItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
