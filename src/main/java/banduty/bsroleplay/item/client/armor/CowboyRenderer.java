package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.CowboyArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CowboyRenderer extends GeoArmorRenderer<CowboyArmorItem> {
    public CowboyRenderer() {
        super(new CowboyModel());
    }
}