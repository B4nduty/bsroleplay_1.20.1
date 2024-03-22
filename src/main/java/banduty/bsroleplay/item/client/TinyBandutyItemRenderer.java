package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.TinyBandutyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TinyBandutyItemRenderer extends GeoItemRenderer<TinyBandutyItem> {
    public TinyBandutyItemRenderer() {
        super(new TinyBandutyItemModel());
    }
}
