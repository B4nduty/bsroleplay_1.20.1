package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.RedPirateArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RedPirateArmorRenderer extends GeoArmorRenderer<RedPirateArmorItem> {
    public RedPirateArmorRenderer() {
        super(new RedPirateArmorModel());
    }
}
