package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.DealerItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DealerRenderer extends GeoArmorRenderer<DealerItem> {
    public DealerRenderer() {
        super(new DealerModel());

        addRenderLayer(new DealerGlowingLayer(this));
    }
}
