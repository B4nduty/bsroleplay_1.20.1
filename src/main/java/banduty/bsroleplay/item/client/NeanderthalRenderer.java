package banduty.bsroleplay.item.client;

import banduty.bsroleplay.item.custom.NeanderthalItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NeanderthalRenderer extends GeoArmorRenderer<NeanderthalItem> {
    public NeanderthalRenderer() {
        super(new NeanderthalModel());
    }
}
