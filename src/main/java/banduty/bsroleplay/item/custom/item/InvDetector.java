package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.item.client.items.InvDetectorModel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InvDetector extends Item implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public InvDetector(Settings settings) {
        super(settings);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GeoItemRenderer<InvDetector> renderer;

            @Override
            public GeoItemRenderer<InvDetector> getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new GeoItemRenderer<>(new InvDetectorModel());

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

    private PlayState predicate(AnimationState<InvDetector> animationState) {
        if (MinecraftClient.getInstance().player == null) return PlayState.STOP;
        Item mainHand = MinecraftClient.getInstance().player.getMainHandStack().getItem();
        Item leftHand = MinecraftClient.getInstance().player.getOffHandStack().getItem();
        boolean coolDown = MinecraftClient.getInstance().player.getItemCooldownManager().isCoolingDown(this);
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        if (!coolDown && (mainHand == this || leftHand == this)) return PlayState.CONTINUE;
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            Box box = new Box(user.getBlockPos()).expand(32);
            world.getEntitiesByClass(LivingEntity.class, box, entity ->
                    user.getBlockPos().isWithinDistance(entity.getBlockPos(), 33) && entity instanceof PlayerEntity
                            && entity != user && entity.hasStatusEffect(StatusEffects.INVISIBILITY))
                    .forEach(entity -> entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,
                            3 * 20, 0 , true, true, true)));
            user.getStackInHand(hand).damage(1, null, (ServerPlayerEntity) user);
            user.getItemCooldownManager().set(this, 30 * 20);
            user.playSound(SoundEvents.BLOCK_BELL_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Detects Invisible Players"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
