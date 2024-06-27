package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.armor.GenericArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GenericArmorModel extends GeoModel<GenericArmorItem> {

    @Override
    public Identifier getModelResource(GenericArmorItem animatable) {
        if (animatable == ModItems.COWBOY_HAT || animatable == ModItems.PONCHO)
            return new Identifier(BsRolePlay.MOD_ID, "geo/cowboy.geo.json");
        if (animatable == ModItems.CROWN) return new Identifier(BsRolePlay.MOD_ID, "geo/crown.geo.json");
        if (animatable == ModItems.MINI_CROWN) return new Identifier(BsRolePlay.MOD_ID, "geo/mini_crown.geo.json");
        if (animatable == ModItems.FEDORA || animatable == ModItems.FEDORA_PURPLE)
            return new Identifier(BsRolePlay.MOD_ID, "geo/elegant.geo.json");
        if (animatable == ModItems.FUNERAL_MASK) return new Identifier(BsRolePlay.MOD_ID, "geo/funeral_mask.geo.json");
        if (animatable == ModItems.GADGET_HAT) return new Identifier(BsRolePlay.MOD_ID, "geo/gadget.geo.json");
        if (animatable == ModItems.HALO) return new Identifier(BsRolePlay.MOD_ID, "geo/halo.geo.json");
        if (animatable == ModItems.LAWYER_BLACKBLUE_CHESTPLATE || animatable == ModItems.LAWYER_LEGGINGS_BLACK ||
                animatable == ModItems.LAWYER_BOOTS_BLACK || animatable == ModItems.LAWYER_BLACKGOLD_CHESTPLATE ||
                animatable == ModItems.LAWYER_BLACKRED_CHESTPLATE || animatable == ModItems.LAWYER_PURPLERED_CHESTPLATE ||
                animatable == ModItems.LAWYER_LEGGINGS_PURPLE || animatable == ModItems.LAWYER_BOOTS_PURPLE)
            return new Identifier(BsRolePlay.MOD_ID, "geo/lawyer.geo.json");
        if (animatable == ModItems.NEANDERTHAL_CHESTPLATE) return new Identifier(BsRolePlay.MOD_ID, "geo/neanderthal.geo.json");
        if (animatable == ModItems.BLUE_PIRATE_HELMET || animatable == ModItems.BLUE_PIRATE_CHESTPLATE ||
                animatable == ModItems.BLUE_PIRATE_LEGGINGS || animatable == ModItems.RED_PIRATE_HELMET ||
                animatable == ModItems.RED_PIRATE_CHESTPLATE || animatable == ModItems.RED_PIRATE_LEGGINGS)
            return new Identifier(BsRolePlay.MOD_ID, "geo/pirate_armor.geo.json");
        if (animatable == ModItems.CIVIC_CROWN || animatable == ModItems.ROMAN_TOGA)
            return new Identifier(BsRolePlay.MOD_ID, "geo/roman_emperor.geo.json");
        return new Identifier("missing");
    }

    @Override
    public Identifier getTextureResource(GenericArmorItem animatable) {
        if (animatable == ModItems.COWBOY_HAT || animatable == ModItems.PONCHO)
            return new Identifier(BsRolePlay.MOD_ID, "textures/armor/cowboy.png");
        if (animatable == ModItems.CROWN) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/crown.png");
        if (animatable == ModItems.MINI_CROWN) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/mini_crown.png");
        if (animatable == ModItems.FEDORA) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/elegant.png");
        if (animatable == ModItems.FEDORA_PURPLE) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/elegant_purple.png");
        if (animatable == ModItems.FUNERAL_MASK) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/funeral_mask.png");
        if (animatable == ModItems.GADGET_HAT) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/gadget.png");
        if (animatable == ModItems.HALO) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/halo.png");
        if (animatable == ModItems.LAWYER_BLACKBLUE_CHESTPLATE || animatable == ModItems.LAWYER_LEGGINGS_BLACK ||
                animatable == ModItems.LAWYER_BOOTS_BLACK) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/lawyer_black_and_blue.png");
        if (animatable == ModItems.LAWYER_BLACKGOLD_CHESTPLATE) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/lawyer_black_and_gold.png");
        if (animatable == ModItems.LAWYER_BLACKRED_CHESTPLATE) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/lawyer_black_and_red.png");
        if (animatable == ModItems.LAWYER_PURPLERED_CHESTPLATE || animatable == ModItems.LAWYER_LEGGINGS_PURPLE ||
                animatable == ModItems.LAWYER_BOOTS_PURPLE) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/lawyer_purple_and_red.png");
        if (animatable == ModItems.NEANDERTHAL_CHESTPLATE) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/neanderthal.png");
        if (animatable == ModItems.BLUE_PIRATE_HELMET || animatable == ModItems.BLUE_PIRATE_CHESTPLATE ||
                animatable == ModItems.BLUE_PIRATE_LEGGINGS) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/blue_pirate_armor.png");
        if (animatable == ModItems.RED_PIRATE_HELMET || animatable == ModItems.RED_PIRATE_CHESTPLATE ||
                animatable == ModItems.RED_PIRATE_LEGGINGS) return new Identifier(BsRolePlay.MOD_ID,
                "textures/armor/red_pirate_armor.png");
        if (animatable == ModItems.CIVIC_CROWN || animatable == ModItems.ROMAN_TOGA)
            return new Identifier(BsRolePlay.MOD_ID, "textures/armor/roman_emperor.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(GenericArmorItem animatable) {
        if (animatable == ModItems.GADGET_HAT) return new Identifier(BsRolePlay.MOD_ID, "animations/gadget.animation.json");
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}