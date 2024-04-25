package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.BronzeCoinBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BronzeCoinModel extends GeoModel<BronzeCoinBlockEntity> {
    @Override
    public Identifier getModelResource(BronzeCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin.geo.json");
    }

    @Override
    public Identifier getTextureResource(BronzeCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/bronze_coin.png");
    }

    @Override
    public Identifier getAnimationResource(BronzeCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
