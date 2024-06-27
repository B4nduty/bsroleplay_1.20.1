package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.stack.GoldCoinStackBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class GoldCoinStackModel extends GeoModel<GoldCoinStackBlockEntity> {
    @Override
    public Identifier getModelResource(GoldCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin_stack.geo.json");
    }

    @Override
    public Identifier getTextureResource(GoldCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/gold_coins.png");
    }

    @Override
    public Identifier getAnimationResource(GoldCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
