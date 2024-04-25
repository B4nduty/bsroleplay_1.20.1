package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.armor.LawyerItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class LawyerModel extends GeoModel<LawyerItem> {

    @Override
    public Identifier getModelResource(LawyerItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/lawyer.geo.json");
    }

    @Override
    public Identifier getTextureResource(LawyerItem animatable) {
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
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(LawyerItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
