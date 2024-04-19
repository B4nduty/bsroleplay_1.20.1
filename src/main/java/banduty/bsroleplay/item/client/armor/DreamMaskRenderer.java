package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.DreamMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DreamMaskRenderer extends GeoArmorRenderer<DreamMaskItem> {
    public DreamMaskRenderer() {
        super(new DreamMaskModel());
    }
}
