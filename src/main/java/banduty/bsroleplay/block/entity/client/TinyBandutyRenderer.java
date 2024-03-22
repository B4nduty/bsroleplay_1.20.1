package banduty.bsroleplay.block.entity.client;

import banduty.bsroleplay.block.entity.TinyBandutyEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TinyBandutyRenderer extends GeoBlockRenderer<TinyBandutyEntity> {
    public TinyBandutyRenderer(BlockEntityRendererFactory.Context context) {
        super(new TinyBandutyModel());
    }
}
