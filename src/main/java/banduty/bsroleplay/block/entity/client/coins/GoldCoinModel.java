package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.GoldCoinBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GoldCoinModel extends GeoModel<GoldCoinBlockEntity> {
    @Override
    public Identifier getModelResource(GoldCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin.geo.json");
    }

    @Override
    public Identifier getTextureResource(GoldCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/gold_coins.png");
    }

    @Override
    public Identifier getAnimationResource(GoldCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
