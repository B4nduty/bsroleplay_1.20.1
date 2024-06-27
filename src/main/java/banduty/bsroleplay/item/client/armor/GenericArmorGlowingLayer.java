package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.GenericArmorItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GenericArmorGlowingLayer extends AutoGlowingGeoLayer<GenericArmorItem> {
    public GenericArmorGlowingLayer(GenericArmorRenderer genericArmorRenderer) {
        super(genericArmorRenderer);
    }
}
