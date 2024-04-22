package banduty.bsroleplay.item.client.items;

import banduty.bsroleplay.item.custom.item.Hook;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class HookRenderer extends GeoItemRenderer<Hook> {
    public HookRenderer() {
        super(new HookModel());
    }
}
