package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
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
        if (animatable == ModItems.RED_PROTECTION_HELMET || animatable == ModItems.RED_PROTECTION_CHESTPLATE ||
                animatable == ModItems.RED_PROTECTION_LEGGINGS)
            return new Identifier(BsRolePlay.MOD_ID, "textures/armor/amongus_clothing.png");
        if (animatable == ModItems.PROTECTION_HELMET || animatable == ModItems.PROTECTION_CHESTPLATE ||
                animatable == ModItems.PROTECTION_LEGGINGS || animatable == ModItems.PROTECTION_BOOTS)
            return new Identifier(BsRolePlay.MOD_ID, "textures/armor/protection_clothing.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(ProtectionClothingItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
