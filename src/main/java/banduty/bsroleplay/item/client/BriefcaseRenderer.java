package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.BriefCase;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BriefcaseRenderer extends GeoItemRenderer<BriefCase> {
    public BriefcaseRenderer() {
        super(new BriefcaseModel());
    }
}
