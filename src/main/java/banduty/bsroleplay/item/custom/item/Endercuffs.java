
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.sound.ModSounds;
import banduty.bsroleplay.util.Handcuffed;
import banduty.bsroleplay.util.IEntityDataSaver;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Endercuffs extends Item {
    public Endercuffs(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof PlayerEntity playerTarget && playerTarget.isCreative() &&
                !((IEntityDataSaver) playerTarget).bsroleplay$getPersistentData().getBoolean("handcuffed")) {
            if (!user.isCreative()) stack.decrement(1);
            if (playerTarget instanceof ServerPlayerEntity serverPlayerTarget) {
                serverPlayerTarget.changeGameMode(serverPlayerTarget.isCreative() ? GameMode.SURVIVAL : GameMode.CREATIVE);
            }
            playerTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,
                    -1, BsRolePlay.CONFIG.common.getHandcuffsSlownessLevel() - 1, false,
                    false, false));
            playerTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,
                    -1, BsRolePlay.CONFIG.common.getHandcuffsWeaknessLevel() - 1, false,
                    false, false));
            playerTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,
                    -1, 217, false, false, false));

            Handcuffed.setHandcuffed(((IEntityDataSaver) playerTarget), true);

            if (user.getWorld() instanceof ServerWorld serverWorld) {
                BlockPos blockPos = user.getBlockPos();
                serverWorld.playSound(null, blockPos, ModSounds.HANDCUFFED, SoundCategory.PLAYERS, 1f, 1f);
                playerTarget.sendMessage(Text.translatable("message.bsroleplay.handcuff.handcuffed_2").fillStyle(Style.EMPTY.withColor(Formatting.RED)), true);
                user.sendMessage(Text.translatable("message.bsroleplay.endercuffs.handcuffed", playerTarget.getName().getString()), true);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!BsRolePlay.CONFIG.common.modifyEndercuffsFire) {
            return ActionResult.success(world.isClient());
        }

        PlayerEntity playerEntity = context.getPlayer();
        BlockPos usedOnPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(usedOnPos);
        if (!CampfireBlock.canBeLit(blockState) && !CandleBlock.canBeLit(blockState) && !CandleCakeBlock.canBeLit(blockState)) {
            BlockPos posToPlaceBlock = usedOnPos.offset(context.getSide());
            if (AbstractFireBlock.canPlaceAt(world, posToPlaceBlock, context.getHorizontalPlayerFacing())) {
                world.playSound(playerEntity, posToPlaceBlock, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
                BlockState blockState2 = AbstractFireBlock.getState(world, posToPlaceBlock);
                world.setBlockState(posToPlaceBlock, blockState2, 11);
                world.emitGameEvent(playerEntity, GameEvent.BLOCK_PLACE, usedOnPos);
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity serverPlayerEntity) {
                    Criteria.PLACED_BLOCK.trigger(serverPlayerEntity, posToPlaceBlock, itemStack);
                }

                if (playerEntity != null) {
                    playerEntity.getItemCooldownManager().set(this, 600);
                }

                return ActionResult.success(world.isClient());
            } else {
                return ActionResult.PASS;
            }
        } else {
            world.playSound(playerEntity, usedOnPos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            world.setBlockState(usedOnPos, blockState.with(Properties.LIT, true), 11);
            world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, usedOnPos);
            if (playerEntity != null) {
                playerEntity.getItemCooldownManager().set(this, 200);
            }
            return ActionResult.success(world.isClient());
        }
    }
}
