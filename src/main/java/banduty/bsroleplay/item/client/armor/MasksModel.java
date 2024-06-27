package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.armor.MasksItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class MasksModel extends GeoModel<MasksItem> {

    @Override
    public Identifier getModelResource(MasksItem animatable) {
        if (animatable == ModItems.BUNNY_MASK) return new Identifier(BsRolePlay.MOD_ID, "geo/bunny_mask.geo.json");
        if (animatable == ModItems.DREAM_MASK) return new Identifier(BsRolePlay.MOD_ID, "geo/dream_mask.geo.json");
        if (animatable == ModItems.DEALER_MASK) return new Identifier(BsRolePlay.MOD_ID, "geo/dealer_mask.geo.json");
        return new Identifier("missing");
    }

    @Override
    public Identifier getTextureResource(MasksItem animatable) {
        if (animatable == ModItems.BUNNY_MASK) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/bunny_mask.png");
        if (animatable == ModItems.DREAM_MASK) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/dream_mask.png");
        if (animatable == ModItems.DEALER_MASK) return new Identifier(BsRolePlay.MOD_ID, "textures/armor/dealer_mask.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(MasksItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
