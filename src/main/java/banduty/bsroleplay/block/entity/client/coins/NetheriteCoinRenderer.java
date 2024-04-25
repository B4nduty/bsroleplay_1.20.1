package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.block.entity.coins.NetheriteCoinBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class NetheriteCoinRenderer extends GeoBlockRenderer<NetheriteCoinBlockEntity> {
    public NetheriteCoinRenderer(BlockEntityRendererFactory.Context context) {
        super(new NetheriteCoinModel());
    }
}
