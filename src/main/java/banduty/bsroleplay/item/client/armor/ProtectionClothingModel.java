package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.armor.ProtectionClothingItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ProtectionClothingModel extends GeoModel<ProtectionClothingItem> {

    @Override
    public Identifier getModelResource(ProtectionClothingItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/protection_clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(ProtectionClothingItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/armor/protection_clothing.png");
    }

    @Override
    public Identifier getAnimationResource(ProtectionClothingItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/armors.animation.json");
    }
}
