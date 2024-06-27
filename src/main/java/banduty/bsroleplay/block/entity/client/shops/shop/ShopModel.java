package banduty.bsroleplay.block.entity.client.shops.shop;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.shops.ShopBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ShopModel extends GeoModel<ShopBlockEntity> {
    @Override
    public Identifier getModelResource(ShopBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/shop.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShopBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "textures/block/shop.png");
    }

    @Override
    public Identifier getAnimationResource(ShopBlockEntity animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}
