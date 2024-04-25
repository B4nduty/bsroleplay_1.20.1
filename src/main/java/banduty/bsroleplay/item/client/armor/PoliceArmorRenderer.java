package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.PoliceArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PoliceArmorRenderer extends GeoArmorRenderer<PoliceArmorItem> {
    public PoliceArmorRenderer() {
        super(new PoliceArmorModel());

        addRenderLayer(new PoliceArmorGlowingLayer(this));
    }
}
