package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.BunnyMaskItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class BunnyMaskGlowingLayer extends AutoGlowingGeoLayer<BunnyMaskItem> {
    public BunnyMaskGlowingLayer(BunnyMaskRenderer bunnyMaskRenderer) {
        super(bunnyMaskRenderer);
    }
}
