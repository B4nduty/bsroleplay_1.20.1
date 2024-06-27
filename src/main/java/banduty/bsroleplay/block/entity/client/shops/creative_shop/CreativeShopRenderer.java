package banduty.bsroleplay.block.entity.client.shops.creative_shop;

import banduty.bsroleplay.block.entity.shops.CreativeShopBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CreativeShopRenderer extends GeoBlockRenderer<CreativeShopBlockEntity> {
    public CreativeShopRenderer(BlockEntityRendererFactory.Context context) {
        super(new CreativeShopModel());

        addRenderLayer(new CreativeShopItemGeoRenderLayer(this));
        addRenderLayer(new CreativeShopTextGeoRenderLayer(this));
        addRenderLayer(new CreativeShopText2GeoRenderLayer(this));
    }
}
