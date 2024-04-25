package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.PirateArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PirateArmorRenderer extends GeoArmorRenderer<PirateArmorItem> {
    public PirateArmorRenderer() {
        super(new PirateArmorModel());
    }
}
