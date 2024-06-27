
package banduty.bsroleplay.block.entity.shops;
import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.screen.shop.ShopScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.UUID;

public class ShopBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory, GeoBlockEntity {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    protected UUID owner = Util.NIL_UUID;
    private static final int SELL_SLOT = 0;

    protected final PropertyDelegate propertyDelegate;
    private int currencyCounter = 0;
    public int maxCoins = BsRolePlay.CONFIG.currency.getWalletMaxCoins();
    private int coins = 0;

    public ShopBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHOP_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ShopBlockEntity.this.currencyCounter;
                    case 1 -> ShopBlockEntity.this.coins;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ShopBlockEntity.this.currencyCounter = value;
                    case 1 -> ShopBlockEntity.this.coins = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<ShopBlockEntity> animationState) {
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

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Shop");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("shop.currency_counter", currencyCounter);
        nbt.putInt("shop.coins", coins);
        nbt.putUuid("shop.owner", owner);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        currencyCounter = nbt.getInt("shop.currency_counter");
        coins = nbt.getInt("shop.coins");
        owner = nbt.contains("shop.owner") ? nbt.getUuid("shop.owner") : Util.NIL_UUID;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ShopScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
        markDirty();
    }

    public UUID getOwner() {
        return owner;
    }

    public void addCoins(int coins) {
        this.coins = coins;
        markDirty();
    }

    public int getCoins() {
        return coins;
    }

    public void setCurrencyCounter(int currencyCounter) {
        this.currencyCounter = currencyCounter;
        markDirty();
    }

    public int getCurrencyCounter() {
        return currencyCounter;
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public void reduceSellStack(int decrease){
        this.removeStack(SELL_SLOT, decrease);
        markDirty();
    }

    public ItemStack getRenderStack() {
        return this.getStack(SELL_SLOT);
    }
}
