package banduty.bsroleplay.item.client.blocks;

import banduty.bsroleplay.item.custom.blocks.TinyBandutyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TinyBandutyItemRenderer extends GeoItemRenderer<TinyBandutyItem> {
    public TinyBandutyItemRenderer() {
        super(new TinyBandutyItemModel());
    }
}
