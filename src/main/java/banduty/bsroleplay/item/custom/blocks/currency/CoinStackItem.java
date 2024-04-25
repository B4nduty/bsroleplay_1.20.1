package banduty.bsroleplay.item.custom.blocks.currency;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.client.blocks.CoinStackItemRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CoinStackItem extends BlockItem implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public CoinStackItem(Block block, Settings settings) {
        super(block, settings);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private final CoinStackItemRenderer renderer = new CoinStackItemRenderer();

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this,"controller", 0, this::predicate));

    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.currency.showCoinPrice) {
            if (stack.getItem() == ModItems.BRONZE_COIN_STACK) tooltip.add(Text.literal("9 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.GOLD_COIN_STACK) tooltip.add(Text.literal("729 RP").formatted(Formatting.AQUA));
            if (stack.getItem() == ModItems.NETHERITE_COIN_STACK) tooltip.add(Text.literal("59049 RP").formatted(Formatting.AQUA));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
