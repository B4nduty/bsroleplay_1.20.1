package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.armor.PirateArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class PirateArmorModel extends GeoModel<PirateArmorItem> {

    @Override
    public Identifier getModelResource(PirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/pirate_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(PirateArmorItem animatable) {
        if (animatable == ModItems.BLUE_PIRATE_HELMET || animatable == ModItems.BLUE_PIRATE_CHESTPLATE ||
                animatable == ModItems.BLUE_PIRATE_LEGGINGS) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/blue_pirate_armor.png");
        if (animatable == ModItems.RED_PIRATE_HELMET || animatable == ModItems.RED_PIRATE_CHESTPLATE ||
                animatable == ModItems.RED_PIRATE_LEGGINGS) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/red_pirate_armor.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(PirateArmorItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
