package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.PoliceArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PoliceArmorRenderer extends GeoArmorRenderer<PoliceArmorItem> {
    public PoliceArmorRenderer() {
        super(new PoliceArmorModel());
    }
}
