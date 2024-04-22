package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.item.custom.item.PharaohStaff;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PharaohStaffRenderer extends GeoItemRenderer<PharaohStaff> {
    public PharaohStaffRenderer() {
        super(new PharaohStaffModel());
    }
}
