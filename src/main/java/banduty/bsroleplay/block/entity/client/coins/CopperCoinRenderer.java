package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.block.entity.coins.CopperCoinBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CopperCoinRenderer extends GeoBlockRenderer<CopperCoinBlockEntity> {
    public CopperCoinRenderer(BlockEntityRendererFactory.Context context) {
        super(new CopperCoinModel());
    }
}
