package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.GadgetArmor;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GadgetArmorRenderer extends GeoArmorRenderer<GadgetArmor> {
    public GadgetArmorRenderer() {
        super(new GadgetArmorModel());
    }
}
