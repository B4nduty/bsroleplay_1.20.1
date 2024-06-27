package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.item.InvDetector;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class InvDetectorModel extends GeoModel<InvDetector> {

    @Override
    public Identifier getModelResource(InvDetector animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/invdetector.geo.json");
    }

    @Override
    public Identifier getTextureResource(InvDetector animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/item/invdetector.png");
    }

    @Override
    public Identifier getAnimationResource(InvDetector animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/invdetector.animation.json");
    }
}
