package banduty.bsroleplay.item.client.blocks;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.blocks.currency.CoinStackItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CoinStackItemModel extends GeoModel<CoinStackItem> {
    @Override
    public Identifier getModelResource(CoinStackItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/coin_stack.geo.json");
    }

    @Override
    public Identifier getTextureResource(CoinStackItem animatable) {
        if (animatable == ModItems.BRONZE_COIN_STACK) return new Identifier(BsRolePlay.MOD_ID, "textures/block/bronze_coin.png");
        if (animatable == ModItems.GOLD_COIN_STACK) return new Identifier(BsRolePlay.MOD_ID, "textures/block/gold_coins.png");
        if (animatable == ModItems.NETHERITE_COIN_STACK) return new Identifier(BsRolePlay.MOD_ID, "textures/block/netherite_coins.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(CoinStackItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/noanim.animation.json");
    }
}
