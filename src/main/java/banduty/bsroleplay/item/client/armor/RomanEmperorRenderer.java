package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.RomanEmperorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RomanEmperorRenderer extends GeoArmorRenderer<RomanEmperorItem> {
    public RomanEmperorRenderer() {
        super(new RomanEmperorModel());
    }
}
