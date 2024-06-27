package banduty.bsroleplay.block.custom;

import banduty.bsroleplay.block.entity.shops.ShopBlockEntity;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.item.WalletItem;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.UUID;

public class Shop extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    protected static final VoxelShape WOOD = createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
    protected static final VoxelShape GLASS = createCuboidShape(4.0, 10.0, 4.0, 12.0, 16.0, 12.0);
    protected static final VoxelShape SHAPE = VoxelShapes.union(WOOD, GLASS);

    public Shop(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ShopBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ShopBlockEntity) {
                ItemScatterer.spawn(world, pos, (ShopBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof ShopBlockEntity shopBlockEntity && placer != null) {
            shopBlockEntity.setOwner(placer.getUuid());
            shopBlockEntity.markDirty();
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        NamedScreenHandlerFactory shopBlockEntityScreen = (ShopBlockEntity) world.getBlockEntity(pos);
        if (world.isClient) return ActionResult.SUCCESS;
        if (!(world.getBlockEntity(pos) instanceof ShopBlockEntity shopBlockEntity)) return ActionResult.PASS;
        UUID owner = shopBlockEntity.getOwner();
        if (owner.equals(player.getUuid())) {
            player.openHandledScreen(shopBlockEntityScreen);
            return ActionResult.SUCCESS;
        }
        ItemStack mainHandStack = player.getMainHandStack();
        ItemStack sellStack = shopBlockEntity.getRenderStack();
        if (sellStack.isEmpty()) {
            player.sendMessage(Text.translatable("bsroleplay.shop.no_item_sell").formatted(Formatting.RED), true);
            return ActionResult.PASS;
        }
        if (mainHandStack.getItem() != ModItems.WALLET) {
            player.sendMessage(Text.translatable("bsroleplay.shop.wallet_need").formatted(Formatting.RED), true);
            return ActionResult.PASS;
        }
        if (shopBlockEntity.getCurrencyCounter() > shopBlockEntity.maxCoins - shopBlockEntity.getCoins()) {
            player.sendMessage(Text.translatable("bsroleplay.shop.full_coins").formatted(Formatting.RED), true);
            return ActionResult.PASS;
        }
        if (WalletItem.getCurrencyFromNbt(mainHandStack) < shopBlockEntity.getCurrencyCounter()) {
            player.sendMessage(Text.translatable("bsroleplay.shop.no_money").formatted(Formatting.RED), true);
            return ActionResult.PASS;
        }
        WalletItem.writeCurrencyToNbt(mainHandStack,
                WalletItem.getCurrencyFromNbt(mainHandStack) - shopBlockEntity.getCurrencyCounter());
        shopBlockEntity.addCoins(shopBlockEntity.getCoins() + shopBlockEntity.getCurrencyCounter());
        player.getInventory().insertStack(sellStack.copyWithCount(1));
        shopBlockEntity.reduceSellStack(1);
        Objects.requireNonNull(world.getPlayerByUuid(shopBlockEntity.getOwner()))
                .sendMessage(Text.translatable("bsroleplay.shop.sell_popup", sellStack.getName()).formatted(Formatting.GREEN), true);
        return ActionResult.SUCCESS;
    }

    @Override
    @SuppressWarnings("deprecation")
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        if (world.getBlockEntity(pos) instanceof ShopBlockEntity shopBlockEntity &&
                shopBlockEntity.getOwner().equals(player.getUuid())) return super.calcBlockBreakingDelta(state, player, world, pos);
        else return -1.0f;
    }
}