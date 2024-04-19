package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.DealerItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DealerGlowingLayer extends AutoGlowingGeoLayer<DealerItem> {
    public DealerGlowingLayer(DealerRenderer dealerRenderer) {
        super(dealerRenderer);
    }
}
