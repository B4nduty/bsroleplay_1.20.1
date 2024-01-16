package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.BluePirateArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BluePirateArmorRenderer extends GeoArmorRenderer<BluePirateArmorItem> {
    public BluePirateArmorRenderer() {
        super(new BluePirateArmorModel());
    }
}
