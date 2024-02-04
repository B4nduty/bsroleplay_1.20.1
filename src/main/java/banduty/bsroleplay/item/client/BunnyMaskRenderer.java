package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.BunnyMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BunnyMaskRenderer extends GeoArmorRenderer<BunnyMaskItem> {
    public BunnyMaskRenderer() {
        super(new BunnyMaskModel());

        addRenderLayer(new BunnyMaskGlowingLayer(this));
    }
}
