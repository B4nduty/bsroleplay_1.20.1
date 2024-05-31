package banduty.bsroleplay.block.entity.client.coins.stack;

import banduty.bsroleplay.block.entity.coins.stack.AmethystCoinStackBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AmethystCoinStackRenderer extends GeoBlockRenderer<AmethystCoinStackBlockEntity> {
    public AmethystCoinStackRenderer(BlockEntityRendererFactory.Context context) {
        super(new AmethystCoinStackModel());
    }
}
