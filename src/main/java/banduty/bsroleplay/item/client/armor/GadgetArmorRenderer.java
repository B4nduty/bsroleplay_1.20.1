package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.GadgetArmor;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GadgetArmorRenderer extends GeoArmorRenderer<GadgetArmor> {
    public GadgetArmorRenderer() {
        super(new GadgetArmorModel());
    }
}
