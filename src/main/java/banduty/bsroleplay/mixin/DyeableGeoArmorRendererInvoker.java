package banduty.bsroleplay.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.DyeableGeoArmorRenderer;

@Mixin(DyeableGeoArmorRenderer.class)
public interface DyeableGeoArmorRendererInvoker {
    @Invoker("getColorForBone")
    Color invokeGetColorForBone(GeoBone bone);
}