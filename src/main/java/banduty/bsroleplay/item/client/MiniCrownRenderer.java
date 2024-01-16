package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.MiniCrownItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MiniCrownRenderer extends GeoArmorRenderer<MiniCrownItem> {
    public MiniCrownRenderer() {
        super(new MiniCrownModel());
    }
}
