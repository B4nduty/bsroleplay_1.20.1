package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.FuneralMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FuneralMaskRenderer extends GeoArmorRenderer<FuneralMaskItem> {
    public FuneralMaskRenderer() {
        super(new FuneralMaskModel());

        addRenderLayer(new FuneralMaskGlowingLayer(this));
    }
}
