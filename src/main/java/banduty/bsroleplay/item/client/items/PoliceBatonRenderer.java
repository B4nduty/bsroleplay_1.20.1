package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.item.custom.item.PoliceBaton;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PoliceBatonRenderer extends GeoItemRenderer<PoliceBaton> {
    public PoliceBatonRenderer() {
        super(new PoliceBatonModel());
    }
}
