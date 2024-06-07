package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.MasksItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MasksRenderer extends GeoArmorRenderer<MasksItem> {
    public MasksRenderer() {
        super(new MasksModel());

        addRenderLayer(new MasksGlowingLayer(this));
    }
}
