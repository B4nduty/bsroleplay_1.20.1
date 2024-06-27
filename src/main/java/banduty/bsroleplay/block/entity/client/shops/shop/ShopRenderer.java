package banduty.bsroleplay.block.entity.client.shops.shop;

import banduty.bsroleplay.block.entity.shops.ShopBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ShopRenderer extends GeoBlockRenderer<ShopBlockEntity> {
    public ShopRenderer(BlockEntityRendererFactory.Context context) {
        super(new ShopModel());

        addRenderLayer(new ShopItemGeoRenderLayer(this));
        addRenderLayer(new ShopTextGeoRenderLayer(this));
        addRenderLayer(new ShopText2GeoRenderLayer(this));
    }
}
