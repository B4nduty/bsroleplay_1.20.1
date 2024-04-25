package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.LawyerItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LawyerRenderer extends GeoArmorRenderer<LawyerItem> {
    public LawyerRenderer() {
        super(new LawyerModel());
    }
}
