package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.CrownItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CrownRenderer extends GeoArmorRenderer<CrownItem> {
    public CrownRenderer() {
        super(new CrownModel());
    }
}
