package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.FuneralMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FuneralMaskRenderer extends GeoArmorRenderer<FuneralMaskItem> {
    public FuneralMaskRenderer() {
        super(new FuneralMaskModel());
    }
}
