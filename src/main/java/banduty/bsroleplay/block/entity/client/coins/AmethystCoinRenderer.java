package banduty.bsroleplay.block.entity.client.coins;

import banduty.bsroleplay.block.entity.coins.AmethystCoinBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AmethystCoinRenderer extends GeoBlockRenderer<AmethystCoinBlockEntity> {
    public AmethystCoinRenderer(BlockEntityRendererFactory.Context context) {
        super(new AmethystCoinModel());
    }
}
