package banduty.bsroleplay.block.entity.coins.stack;
import banduty.bsroleplay.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

public class GoldCoinStackBlockEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public GoldCoinStackBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GOLD_COIN_STACK_BLOCK_ENTITY, pos, state);
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
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentTick();
    }
}
