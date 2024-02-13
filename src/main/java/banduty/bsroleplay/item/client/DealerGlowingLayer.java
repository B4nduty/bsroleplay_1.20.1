package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.DealerItem;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DealerGlowingLayer extends AutoGlowingGeoLayer<DealerItem> {
    public DealerGlowingLayer(DealerRenderer dealerRenderer) {
        super(dealerRenderer);
    }
}
