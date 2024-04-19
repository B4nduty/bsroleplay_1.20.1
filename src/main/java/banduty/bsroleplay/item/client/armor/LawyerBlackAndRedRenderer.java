package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.LawyerBlackAndRedItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LawyerBlackAndRedRenderer extends GeoArmorRenderer<LawyerBlackAndRedItem> {
    public LawyerBlackAndRedRenderer() {
        super(new LawyerBlackAndRedModel());
    }
}
