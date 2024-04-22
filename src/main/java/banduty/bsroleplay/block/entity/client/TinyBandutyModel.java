package banduty.bsroleplay.block.entity.client;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.TinyBandutyEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TinyBandutyModel extends GeoModel<TinyBandutyEntity> {
    @Override
    public Identifier getModelResource(TinyBandutyEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/tiny_banduty.geo.json");
    }

    @Override
    public Identifier getTextureResource(TinyBandutyEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/tiny_banduty.png");
    }

    @Override
    public Identifier getAnimationResource(TinyBandutyEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
