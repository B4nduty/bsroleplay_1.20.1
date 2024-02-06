package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.ProtectionClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ProtectionClothingRenderer extends GeoArmorRenderer<ProtectionClothingItem> {
    public ProtectionClothingRenderer() {
        super(new ProtectionClothingModel());

        addRenderLayer(new ProtectionClothingGlowingLayer(this));
    }
}
