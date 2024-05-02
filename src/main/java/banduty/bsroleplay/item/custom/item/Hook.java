package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.client.items.HookRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Hook extends Item implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public Hook(Settings settings) {
        super(settings);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private HookRenderer renderer;

            @Override
            public HookRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new HookRenderer();

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
        controllers.add(new AnimationController<>(this,"controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState animationState) {
        Item mainHand = MinecraftClient.getInstance().player.getMainHandStack().getItem();
        if (mainHand == this) {
            if (BsRolePlay.CONFIG.common.modifyHookEvokerFang) {
                if (MinecraftClient.getInstance().player.getItemCooldownManager().isCoolingDown(this)) {
                    animationState.getController().setAnimation(RawAnimation.begin().then("unabled", Animation.LoopType.HOLD_ON_LAST_FRAME));
                    return PlayState.CONTINUE;
                }
                animationState.getController().setAnimation(RawAnimation.begin().then("able", Animation.LoopType.HOLD_ON_LAST_FRAME));
                return PlayState.CONTINUE;
            }
            animationState.getController().setAnimation(RawAnimation.begin().then("unable", Animation.LoopType.HOLD_ON_LAST_FRAME));
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }


    public ActionResult useOnBlock(ItemUsageContext context) {

        if (BsRolePlay.CONFIG.common.modifyHookEvokerFang) {
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            World world = context.getWorld();

            Entity evokerFangs = new EvokerFangsEntity(EntityType.EVOKER_FANGS, world);
            evokerFangs.setPosition(blockPos.toCenterPos());
            world.spawnEntity(evokerFangs);

            context.getWorld().playSound(null, blockPos, SoundEvents.BLOCK_ANVIL_LAND,
                    SoundCategory.BLOCKS, 0.5f, 1f);

            if (player != null) {
                player.getItemCooldownManager().set(this, BsRolePlay.CONFIG.common.getHookCooldown() * 20);
            }

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.common.showItemTooltips) {
            tooltip.add(Text.translatable("tooltip.bsroleplay.hook.tooltip").formatted(Formatting.AQUA));
            super.appendTooltip(stack, world, tooltip, context);
        }
    }
}
