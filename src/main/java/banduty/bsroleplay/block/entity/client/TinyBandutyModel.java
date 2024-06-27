package banduty.bsroleplay.block.entity.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.TinyBandutyBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TinyBandutyModel extends GeoModel<TinyBandutyBlockEntity> {
    @Override
    public Identifier getModelResource(TinyBandutyBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/tiny_banduty.geo.json");
    }

    @Override
    public Identifier getTextureResource(TinyBandutyBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/tiny_banduty.png");
    }

    @Override
    public Identifier getAnimationResource(TinyBandutyBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
