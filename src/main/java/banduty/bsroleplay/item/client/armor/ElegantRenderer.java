package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.ElegantItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ElegantRenderer extends GeoArmorRenderer<ElegantItem> {
    public ElegantRenderer() {
        super(new ElegantModel());
    }
}
