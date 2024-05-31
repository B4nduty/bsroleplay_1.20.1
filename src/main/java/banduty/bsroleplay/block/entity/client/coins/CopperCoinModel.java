package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.CopperCoinBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CopperCoinModel extends GeoModel<CopperCoinBlockEntity> {
    @Override
    public Identifier getModelResource(CopperCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin.geo.json");
    }

    @Override
    public Identifier getTextureResource(CopperCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/copper_coin.png");
    }

    @Override
    public Identifier getAnimationResource(CopperCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
