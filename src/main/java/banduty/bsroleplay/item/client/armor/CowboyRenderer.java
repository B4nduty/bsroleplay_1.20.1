package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.CowboyItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CowboyRenderer extends GeoArmorRenderer<CowboyItem> {
    public CowboyRenderer() {
        super(new CowboyModel());
    }
}
