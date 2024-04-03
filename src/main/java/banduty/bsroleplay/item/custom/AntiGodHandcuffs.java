package banduty.bsroleplay.item.custom;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.sound.ModSounds;
import banduty.bsroleplay.util.BlockedMilk;
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
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class AntiGodHandcuffs extends Item {
    public AntiGodHandcuffs(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof PlayerEntity)
            if (((PlayerEntity) entity).isCreative()) {
                if (!BlockedMilk.isMilkBlocked((IEntityDataSaver) entity)) {
                    if (!user.isCreative()) stack.decrement(1);
                    if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
                        serverPlayerEntity.changeGameMode(((ServerPlayerEntity) entity).isCreative() ? GameMode.SURVIVAL : GameMode.CREATIVE);
                    }
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,
                            -1, BsRolePlay.CONFIG.common.getHandcuffsSlownessLevel()-1, false,
                            false, false));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,
                            -1, BsRolePlay.CONFIG.common.getHandcuffsWeaknessLevel()-1, false,
                            false, false));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,
                            -1, 217, false, false, false));

                    BlockedMilk.setMilkBlocked(((IEntityDataSaver) entity), true);

                    World world = user.getWorld();
                    if (!world.isClient) {
                        ServerWorld serverWorld = (ServerWorld) user.getWorld();
                        BlockPos blockPos = user.getBlockPos();
                        serverWorld.playSound(null, blockPos, ModSounds.HANDCUFFED, SoundCategory.PLAYERS, 1f, 1f);
                        entity.sendMessage(Text.translatable("message.bsroleplay.handcuff.handcuffed_2"));
                        user.sendMessage(Text.translatable("message.bsroleplay.anti_god_handcuffs.handcuffed", entity.getName().getString()));
                    }

                    return ActionResult.SUCCESS;
                }
            }
        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (BsRolePlay.CONFIG.common.modifyAntiGodHandcuffsFire) {
            PlayerEntity playerEntity = context.getPlayer();
            BlockPos blockPos = context.getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);
            if (!CampfireBlock.canBeLit(blockState) && !CandleBlock.canBeLit(blockState) && !CandleCakeBlock.canBeLit(blockState)) {
                BlockPos blockPos2 = blockPos.offset(context.getSide());
                if (AbstractFireBlock.canPlaceAt(world, blockPos2, context.getHorizontalPlayerFacing())) {
                    world.playSound(playerEntity, blockPos2, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
                    BlockState blockState2 = AbstractFireBlock.getState(world, blockPos2);
                    world.setBlockState(blockPos2, blockState2, 11);
                    world.emitGameEvent(playerEntity, GameEvent.BLOCK_PLACE, blockPos);
                    ItemStack itemStack = context.getStack();
                    if (playerEntity instanceof ServerPlayerEntity) {
                        Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos2, itemStack);
                    }

                    if (playerEntity != null) {
                        playerEntity.getItemCooldownManager().set(this, 1800);
                    }

                    return ActionResult.success(world.isClient());
                } else {
                    return ActionResult.FAIL;
                }
            } else {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
                world.setBlockState(blockPos, blockState.with(Properties.LIT, true), 11);
                world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
                if (playerEntity != null) {
                    playerEntity.getItemCooldownManager().set(this, 200);
                }
                return ActionResult.success(world.isClient());
            }
        }
        return ActionResult.success(world.isClient());
    }
}
