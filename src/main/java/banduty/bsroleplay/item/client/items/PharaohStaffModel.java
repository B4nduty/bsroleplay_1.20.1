package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.item.PharaohStaff;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class PharaohStaffModel extends GeoModel<PharaohStaff> {

    @Override
    public Identifier getModelResource(PharaohStaff animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/pharaoh_staff.geo.json");
    }

    @Override
    public Identifier getTextureResource(PharaohStaff animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/item/pharaoh_staff.png");
    }

    @Override
    public Identifier getAnimationResource(PharaohStaff animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/pharaoh_staff.animation.json");
    }
}
