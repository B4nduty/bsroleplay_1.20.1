package banduty.bsroleplay.item.client.blocks;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.blocks.ShopItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ShopItemModel extends GeoModel<ShopItem> {
    @Override
    public Identifier getModelResource(ShopItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "geo/shop.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShopItem animatable) {
        if (animatable == ModItems.SHOP) return new Identifier(BsRolePlay.MOD_ID, "textures/block/shop.png");
        if (animatable == ModItems.CREATIVE_SHOP) return new Identifier(BsRolePlay.MOD_ID, "textures/block/creative_shop.png");
        return new Identifier("missing");
    }

    @Override
    public Identifier getAnimationResource(ShopItem animatable) {
        return new Identifier(BsRolePlay.MOD_ID, "animations/generic.animation.json");
    }
}