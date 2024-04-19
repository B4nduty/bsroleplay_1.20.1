package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.BluePirateArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BluePirateArmorRenderer extends GeoArmorRenderer<BluePirateArmorItem> {
    public BluePirateArmorRenderer() {
        super(new BluePirateArmorModel());
    }
}
