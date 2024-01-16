package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.DreamMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DreamMaskRenderer extends GeoArmorRenderer<DreamMaskItem> {
    public DreamMaskRenderer() {
        super(new DreamMaskModel());
    }
}
