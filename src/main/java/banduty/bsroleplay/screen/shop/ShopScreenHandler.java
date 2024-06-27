
package banduty.bsroleplay.screen.shop;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.shops.ShopBlockEntity;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.blocks.currency.CoinItem;
import banduty.bsroleplay.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ShopScreenHandler extends ScreenHandler {
    private final Inventory sellInventory;
    private final Inventory coinsInventory = new SimpleInventory(4);
    private final PropertyDelegate propertyDelegate;
    public final ShopBlockEntity blockEntity;

    public ShopScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(2));
    }

    public ShopScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.SHOP_SCREEN_HANDLER, syncId);
        this.blockEntity = ((ShopBlockEntity) blockEntity);
        this.sellInventory = ((Inventory) blockEntity);
        sellInventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;

        this.addSlot(new Slot(this.sellInventory, 0, 104, 11));

        this.addSlot(new CoinOutputSlot(this.coinsInventory, 0, 38, 61, (CoinItem) ModItems.COPPER_COIN));
        this.addSlot(new CoinOutputSlot(this.coinsInventory, 1, 66, 61, (CoinItem) ModItems.GOLD_COIN));
        this.addSlot(new CoinOutputSlot(this.coinsInventory, 2, 94, 61, (CoinItem) ModItems.AMETHYST_COIN));
        this.addSlot(new CoinOutputSlot(this.coinsInventory, 3, 122, 61, (CoinItem) ModItems.NETHERITE_COIN));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        onCoinsAdded(this.propertyDelegate.get(1));

        addProperties(arrayPropertyDelegate);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        return super.onButtonClick(player, id);
    }

    private void onCoinsAdded(int storedCoins) {
        for (Slot slot : this.slots) {
            if (slot instanceof CoinOutputSlot coinOutputSlot) {
                coinOutputSlot.setStack(new ItemStack(coinOutputSlot.coinItem, storedCoins /
                        coinOutputSlot.coinItem.currencyValue));
            }
        }
    }

    public int getCurrencyAmount() {
        return this.propertyDelegate.get(0);
    }

    public void increaseCurrencyCounter(int increaseAmount) {
        int currentValue = this.propertyDelegate.get(0);
        int maxCoins = BsRolePlay.CONFIG.currency.getWalletMaxCoins();
        if (currentValue + increaseAmount <= maxCoins) {
            this.blockEntity.setCurrencyCounter(currentValue + increaseAmount);
            this.propertyDelegate.set(0, currentValue + increaseAmount);
        }
    }

    public void decreaseCurrencyCounter(int decreaseAmount) {
        int currentValue = this.propertyDelegate.get(0);
        if (currentValue - decreaseAmount >= 0) {
            this.blockEntity.setCurrencyCounter(currentValue - decreaseAmount);
            this.propertyDelegate.set(0, currentValue - decreaseAmount);
        }
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot.hasStack()) {
            ItemStack newStack = slot.getStack();
            originalStack = newStack.copy();
            if (1 <= slotIndex && slotIndex < 5) {
                if (!this.insertItem(newStack, 5, 41, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(newStack, originalStack);
            } else if (5 <= slotIndex && slotIndex < 41 ?
                            (slotIndex < 32 ?
                                    !this.insertItem(newStack, 32, 41, false) :
                                    !this.insertItem(newStack, 5, 32, false)) :
                    !this.insertItem(newStack, 5, 41, false)
            ) {
                return ItemStack.EMPTY;
            }
            if (newStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
            if (newStack.getCount() == originalStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTakeItem(player, newStack);

            if (1 <= slotIndex && slotIndex < 5) {
                player.dropItem(newStack, false);
            }

            if (slot instanceof CoinOutputSlot coinOutputSlot) {
                coinOutputSlot.setStack(new ItemStack(coinOutputSlot.coinItem, this.propertyDelegate.get(1) /
                        coinOutputSlot.coinItem.currencyValue));
            }
        }

        return originalStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public static class CoinOutputSlot extends Slot {
        private final CoinItem coinItem;

        public CoinOutputSlot(Inventory inventory, int index, int x, int y, CoinItem coinItem) {
            super(inventory, index, x, y);
            this.coinItem = coinItem;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }
    }
}
