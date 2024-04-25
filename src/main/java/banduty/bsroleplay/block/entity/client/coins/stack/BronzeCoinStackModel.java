package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.stack.BronzeCoinStackBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BronzeCoinStackModel extends GeoModel<BronzeCoinStackBlockEntity> {
    @Override
    public Identifier getModelResource(BronzeCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin_stack.geo.json");
    }

    @Override
    public Identifier getTextureResource(BronzeCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/bronze_coin.png");
    }

    @Override
    public Identifier getAnimationResource(BronzeCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
