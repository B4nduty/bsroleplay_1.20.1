package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.CrownItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CrownRenderer extends GeoArmorRenderer<CrownItem> {
    public CrownRenderer() {
        super(new CrownModel());
    }
}
