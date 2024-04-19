package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.MiniCrownItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MiniCrownRenderer extends GeoArmorRenderer<MiniCrownItem> {
    public MiniCrownRenderer() {
        super(new MiniCrownModel());
    }
}
