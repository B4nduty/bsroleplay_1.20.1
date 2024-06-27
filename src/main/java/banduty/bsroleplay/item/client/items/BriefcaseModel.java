package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.item.BriefCase;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BriefcaseModel extends GeoModel<BriefCase> {

    @Override
    public Identifier getModelResource(BriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/briefcase.geo.json");
    }

    @Override
    public Identifier getTextureResource(BriefCase animatable) {
        if (animatable == ModItems.BRIEFCASE) return new Identifier(BsRolePlay.MOD_ID, "textures/item/briefcase.png");
        if (animatable == ModItems.VIOLET_BRIEFCASE) return new Identifier(BsRolePlay.MOD_ID, "textures/item/violet_briefcase.png");
        if (animatable == ModItems.BLACK_BRIEFCASE) return new Identifier(BsRolePlay.MOD_ID, "textures/item/black_briefcase.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(BriefCase animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
