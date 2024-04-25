package banduty.bsroleplay.block.entity.client;

import banduty.bsroleplay.block.entity.TinyBandutyBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TinyBandutyRenderer extends GeoBlockRenderer<TinyBandutyBlockEntity> {
    public TinyBandutyRenderer(BlockEntityRendererFactory.Context context) {
        super(new TinyBandutyModel());
    }
}
