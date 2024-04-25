package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.PoliceArmorItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PoliceArmorGlowingLayer extends AutoGlowingGeoLayer<PoliceArmorItem> {
    public PoliceArmorGlowingLayer(PoliceArmorRenderer policeArmorRenderer) {
        super(policeArmorRenderer);
    }
}
