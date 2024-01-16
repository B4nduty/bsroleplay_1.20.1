package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.RedPirateArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RedPirateArmorRenderer extends GeoArmorRenderer<RedPirateArmorItem> {
    public RedPirateArmorRenderer() {
        super(new RedPirateArmorModel());
    }
}
