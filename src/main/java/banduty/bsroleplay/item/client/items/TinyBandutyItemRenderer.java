package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.item.custom.item.TinyBandutyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TinyBandutyItemRenderer extends GeoItemRenderer<TinyBandutyItem> {
    public TinyBandutyItemRenderer() {
        super(new TinyBandutyItemModel());
    }
}
