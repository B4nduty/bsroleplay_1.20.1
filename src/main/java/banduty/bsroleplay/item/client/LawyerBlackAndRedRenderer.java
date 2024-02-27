package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.LawyerBlackAndRedItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LawyerBlackAndRedRenderer extends GeoArmorRenderer<LawyerBlackAndRedItem> {
    public LawyerBlackAndRedRenderer() {
        super(new LawyerBlackAndRedModel());
    }
}
