package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.GenericArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GenericArmorRenderer extends GeoArmorRenderer<GenericArmorItem> {
    public GenericArmorRenderer() {
        super(new GenericArmorModel());

        addRenderLayer(new GenericArmorGlowingLayer(this));
    }
}
