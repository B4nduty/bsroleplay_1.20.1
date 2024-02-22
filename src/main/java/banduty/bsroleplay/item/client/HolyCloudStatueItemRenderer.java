package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.HolyCloudStatueItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class HolyCloudStatueItemRenderer extends GeoItemRenderer<HolyCloudStatueItem> {
    public HolyCloudStatueItemRenderer() {
        super(new HolyCloudStatueItemModel());
    }
}
