package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.CowboyItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CowboyRenderer extends GeoArmorRenderer<CowboyItem> {
    public CowboyRenderer() {
        super(new CowboyModel());
    }
}
