package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.block.entity.coins.stack.BronzeCoinStackBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BronzeCoinStackRenderer extends GeoBlockRenderer<BronzeCoinStackBlockEntity> {
    public BronzeCoinStackRenderer(BlockEntityRendererFactory.Context context) {
        super(new BronzeCoinStackModel());
    }
}
