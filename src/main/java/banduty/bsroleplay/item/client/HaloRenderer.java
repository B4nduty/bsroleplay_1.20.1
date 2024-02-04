package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.HaloItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HaloRenderer extends GeoArmorRenderer<HaloItem> {
    public HaloRenderer() {
        super(new HaloModel());

        addRenderLayer(new HaloGlowingLayer(this));
    }
}
