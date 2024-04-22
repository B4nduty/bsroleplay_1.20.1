package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.item.Hook;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class HookModel extends GeoModel<Hook> {

    @Override
    public Identifier getModelResource(Hook animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/hook.geo.json");
    }

    @Override
    public Identifier getTextureResource(Hook animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/item/hook.png");
    }

    @Override
    public Identifier getAnimationResource(Hook animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/hook.animation.json");
    }
}
