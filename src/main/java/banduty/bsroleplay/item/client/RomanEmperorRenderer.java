package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.RomanEmperorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RomanEmperorRenderer extends GeoArmorRenderer<RomanEmperorItem> {
    public RomanEmperorRenderer() {
        super(new RomanEmperorModel());
    }
}
