
package banduty.bsroleplay.screen.creative_shop;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.entity.shops.CreativeShopBlockEntity;
import banduty.bsroleplay.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CreativeShopScreenHandler extends ScreenHandler {
    private final Inventory sellInventory;
    private final PropertyDelegate propertyDelegate;
    public final CreativeShopBlockEntity blockEntity;

    public CreativeShopScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(1));
    }

    public CreativeShopScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.CREATIVE_SHOP_SCREEN_HANDLER, syncId);
        this.blockEntity = ((CreativeShopBlockEntity) blockEntity);
        this.sellInventory = ((Inventory) blockEntity);
        sellInventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;

        this.addSlot(new Slot(this.sellInventory, 0, 80, 59));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        return super.onButtonClick(player, id);
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
            if (1 <= slotIndex) {
                if (!this.insertItem(newStack, 2, 41, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(newStack, originalStack);
            } else if (!this.insertItem(newStack, 2, 41, false)) return ItemStack.EMPTY;
            if (newStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
            if (newStack.getCount() == originalStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTakeItem(player, newStack);

            if (1 <= slotIndex) {
                player.dropItem(newStack, false);
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
}
