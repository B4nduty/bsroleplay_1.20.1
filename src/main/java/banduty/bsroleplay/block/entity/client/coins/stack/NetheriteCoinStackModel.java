package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.stack.NetheriteCoinStackBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class NetheriteCoinStackModel extends GeoModel<NetheriteCoinStackBlockEntity> {
    @Override
    public Identifier getModelResource(NetheriteCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin_stack.geo.json");
    }

    @Override
    public Identifier getTextureResource(NetheriteCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/netherite_coins.png");
    }

    @Override
    public Identifier getAnimationResource(NetheriteCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
