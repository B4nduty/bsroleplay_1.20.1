package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.block.entity.coins.stack.CopperCoinStackBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CopperCoinStackRenderer extends GeoBlockRenderer<CopperCoinStackBlockEntity> {
    public CopperCoinStackRenderer(BlockEntityRendererFactory.Context context) {
        super(new CopperCoinStackModel());
    }
}
