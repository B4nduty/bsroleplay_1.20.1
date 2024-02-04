package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.HaloItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HaloGlowingLayer extends AutoGlowingGeoLayer<HaloItem> {
    public HaloGlowingLayer(HaloRenderer haloRenderer) {
        super(haloRenderer);
    }
}
