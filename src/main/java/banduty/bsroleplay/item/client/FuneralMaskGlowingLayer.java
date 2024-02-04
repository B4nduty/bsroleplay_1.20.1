package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.FuneralMaskItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class FuneralMaskGlowingLayer extends AutoGlowingGeoLayer<FuneralMaskItem> {
    public FuneralMaskGlowingLayer(FuneralMaskRenderer funeralMaskRenderer) {
        super(funeralMaskRenderer);
    }
}
