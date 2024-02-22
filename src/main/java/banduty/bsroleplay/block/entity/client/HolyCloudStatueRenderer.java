package banduty.bsroleplay.block.entity.client;

import banduty.bsroleplay.block.entity.HolyCloudStatueEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HolyCloudStatueRenderer extends GeoBlockRenderer<HolyCloudStatueEntity> {
    public HolyCloudStatueRenderer(BlockEntityRendererFactory.Context context) {
        super(new HolyCloudStatueModel());
    }
}
