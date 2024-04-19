package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.ProtectionClothingItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ProtectionClothingRenderer extends GeoArmorRenderer<ProtectionClothingItem> {
    public ProtectionClothingRenderer() {
        super(new ProtectionClothingModel());

        addRenderLayer(new ProtectionClothingGlowingLayer(this));
    }
}
