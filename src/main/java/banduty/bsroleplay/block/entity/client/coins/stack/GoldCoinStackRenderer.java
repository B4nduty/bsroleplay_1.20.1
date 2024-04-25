package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.block.entity.coins.stack.GoldCoinStackBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GoldCoinStackRenderer extends GeoBlockRenderer<GoldCoinStackBlockEntity> {
    public GoldCoinStackRenderer(BlockEntityRendererFactory.Context context) {
        super(new GoldCoinStackModel());
    }
}
