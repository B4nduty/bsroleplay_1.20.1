package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.DealerItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DealerRenderer extends GeoArmorRenderer<DealerItem> {
    public DealerRenderer() {
        super(new DealerModel());

        addRenderLayer(new DealerGlowingLayer(this));
    }
}
