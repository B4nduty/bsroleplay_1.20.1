package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.AmethystCoinBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AmethystCoinModel extends GeoModel<AmethystCoinBlockEntity> {
    @Override
    public Identifier getModelResource(AmethystCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin.geo.json");
    }

    @Override
    public Identifier getTextureResource(AmethystCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/amethyst_coins.png");
    }

    @Override
    public Identifier getAnimationResource(AmethystCoinBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
