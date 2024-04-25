package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.block.entity.coins.GoldCoinBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GoldCoinRenderer extends GeoBlockRenderer<GoldCoinBlockEntity> {
    public GoldCoinRenderer(BlockEntityRendererFactory.Context context) {
        super(new GoldCoinModel());
    }
}
