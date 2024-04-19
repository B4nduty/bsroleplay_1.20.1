package banduty.bsroleplay.item.client.armor;

import banduty.bsroleplay.item.custom.armor.NeanderthalItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NeanderthalRenderer extends GeoArmorRenderer<NeanderthalItem> {
    public NeanderthalRenderer() {
        super(new NeanderthalModel());
    }
}
