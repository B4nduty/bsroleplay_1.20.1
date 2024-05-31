package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.coins.stack.CopperCoinStackBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CopperCoinStackModel extends GeoModel<CopperCoinStackBlockEntity> {
    @Override
    public Identifier getModelResource(CopperCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin_stack.geo.json");
    }

    @Override
    public Identifier getTextureResource(CopperCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/copper_coin.png");
    }

    @Override
    public Identifier getAnimationResource(CopperCoinStackBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
