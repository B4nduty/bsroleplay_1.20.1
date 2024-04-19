package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.HaloItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class HaloRenderer extends GeoArmorRenderer<HaloItem> {
    public HaloRenderer() {
        super(new HaloModel());

        addRenderLayer(new HaloGlowingLayer(this));
    }
}
