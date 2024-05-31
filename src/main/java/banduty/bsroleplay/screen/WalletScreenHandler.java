
package banduty.bsroleplay.screen;

import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.item.custom.blocks.currency.CoinItem;
import banduty.bsroleplay.item.custom.item.WalletItem;
import banduty.bsroleplay.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class WalletScreenHandler extends ScreenHandler {
    private final Inventory inputInventory = new SimpleInventory(1);
    private final Inventory outputInventory = new SimpleInventory(4);
    private final ItemStack walletStack;
    private final int color;

    public WalletScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, buf.readItemStack());
    }

    public WalletScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack walletStack) {
        super(ModScreenHandlers.WALLET_SCREEN_HANDLER, syncId);
        this.walletStack = walletStack;
        this.color = ((DyeableItem) walletStack.getItem()).getColor(walletStack);

        this.addSlot(new Slot(this.inputInventory, 0, 44, 46) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.getItem() instanceof CoinItem;
            }

            @Override
            public ItemStack insertStack(ItemStack stack, int count) {
                if (!this.canInsert(stack) || !(stack.getItem() instanceof CoinItem coinItem)) return stack;
                int necessaryStack = Math.min(64, (WalletItem.MAX_COINS -
                        WalletScreenHandler.this.getCurrencyAmount()) / coinItem.currencyValue);
                WalletScreenHandler.this.setCurrencyAmount(WalletScreenHandler.this.getCurrencyAmount() +
                        coinItem.currencyValue * Math.min(count, necessaryStack));
                return stack.copyWithCount(Math.max(0, count - necessaryStack));
            }
        });

        this.addSlot(new CoinOutputSlot(this.outputInventory, 0, 125, 28, (CoinItem) ModItems.COPPER_COIN));
        this.addSlot(new CoinOutputSlot(this.outputInventory, 1, 143, 28, (CoinItem) ModItems.GOLD_COIN));
        this.addSlot(new CoinOutputSlot(this.outputInventory, 2, 125, 46, (CoinItem) ModItems.AMETHYST_COIN));
        this.addSlot(new CoinOutputSlot(this.outputInventory, 3, 143, 46, (CoinItem) ModItems.NETHERITE_COIN));

        this.onCurrencyAmountChanged(this.getCurrencyAmount());

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        return super.onButtonClick(player, id);
    }

    private void onCurrencyAmountChanged(int newCurrencyAmount) {
        for (Slot slot : this.slots) {
            if (slot instanceof CoinOutputSlot coinOutputSlot) {
                coinOutputSlot.setStack(new ItemStack(coinOutputSlot.coinItem, newCurrencyAmount /
                        coinOutputSlot.coinItem.currencyValue));
            }
        }
    }

    public int getColor() {
        return this.color;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        if (!player.getWorld().isClient()) {
            this.dropInventory(player, this.inputInventory);
            player.playSound(ModSounds.WALLET_CLOSE, 1f, 1f);
        }
    }

    public int getCurrencyAmount() {
        return WalletItem.getCurrencyFromNbt(this.walletStack);
    }

    public void setCurrencyAmount(int currencyAmount) {
        if (currencyAmount != this.getCurrencyAmount()) {
            this.onCurrencyAmountChanged(currencyAmount);
        }
        WalletItem.writeCurrencyToNbt(this.walletStack, currencyAmount);
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
                coinOutputSlot.setStack(new ItemStack(coinOutputSlot.coinItem, getCurrencyAmount() /
                        coinOutputSlot.coinItem.currencyValue));
            }
        }

        return originalStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return player.getInventory().main.contains(this.walletStack) ||
                player.getOffHandStack() == this.walletStack ||
                this.getCursorStack() == this.walletStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + 9 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + 9 + i * 18, 142));
        }
    }

    public class CoinOutputSlot extends Slot {
        private final CoinItem coinItem;

        public CoinOutputSlot(Inventory inventory, int index, int x, int y, CoinItem coinItem) {
            super(inventory, index, x, y);
            this.coinItem = coinItem;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }

        @Override
        public void onTakeItem(PlayerEntity player, ItemStack takenStack) {
            super.onTakeItem(player, takenStack);
            WalletScreenHandler.this.setCurrencyAmount(WalletScreenHandler.this.getCurrencyAmount() -
                    this.coinItem.currencyValue * takenStack.getCount());
        }

        @Override
        public void onQuickTransfer(ItemStack newItem, ItemStack original) {
            super.onQuickTransfer(newItem, original);
            WalletScreenHandler.this.setCurrencyAmount(WalletScreenHandler.this.getCurrencyAmount() -
                    this.coinItem.currencyValue * (original.getCount() - newItem.getCount()));
        }
    }
}
