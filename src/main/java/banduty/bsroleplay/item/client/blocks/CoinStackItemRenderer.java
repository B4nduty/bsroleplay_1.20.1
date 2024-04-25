package banduty.bsroleplay.item.client.blocks;

import banduty.bsroleplay.item.custom.blocks.currency.CoinStackItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CoinStackItemRenderer extends GeoItemRenderer<CoinStackItem> {
    public CoinStackItemRenderer() {
        super(new CoinStackItemModel());
    }
}
