package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.block.entity.coins.stack.NetheriteCoinStackBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class NetheriteCoinStackRenderer extends GeoBlockRenderer<NetheriteCoinStackBlockEntity> {
    public NetheriteCoinStackRenderer(BlockEntityRendererFactory.Context context) {
        super(new NetheriteCoinStackModel());
    }
}
