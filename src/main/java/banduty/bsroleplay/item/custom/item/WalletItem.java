
package banduty.bsroleplay.item.custom.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.blocks.currency.CoinItem;
import banduty.bsroleplay.screen.wallet.WalletScreenHandler;
import banduty.bsroleplay.sound.ModSounds;
import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class WalletItem extends Item implements DyeableItem {
    public static final String STORED_CURRENCY_KEY = "storedCurrency";
    public static final int MAX_COINS = BsRolePlay.CONFIG.currency.getWalletMaxCoins();
    private static final int ITEM_BAR_COLOR = 0x006666ff;

    public WalletItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BsRolePlay.CONFIG.currency.showCoinPrice) {
            tooltip.add(Text.literal(WalletItem.getCurrencyFromNbt(stack) + "/" + MAX_COINS + " RP").formatted(Formatting.AQUA));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    public static int getCurrencyFromNbt(ItemStack walletItemStack) {
        NbtCompound nbt = walletItemStack.getNbt();
        if (nbt != null && nbt.contains(STORED_CURRENCY_KEY, NbtElement.INT_TYPE)) {
            return walletItemStack.getOrCreateNbt().getInt(STORED_CURRENCY_KEY);
        }
        return 0;
    }

    public static void writeCurrencyToNbt(ItemStack walletItemStack, int currencyAmount) {
        walletItemStack.getOrCreateNbt().putInt(STORED_CURRENCY_KEY, currencyAmount);
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);
        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE)) {
            return nbtCompound.getInt(COLOR_KEY);
        }
        return DEFAULT_COLOR;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack walletItemStack = user.getStackInHand(hand);
        if (!world.isClient()) {
            user.openHandledScreen(new ExtendedScreenHandlerFactory() {

                @Override
                public @NotNull ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                    return new WalletScreenHandler(syncId, playerInventory, walletItemStack);
                }

                @Override
                public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
                    buf.writeItemStack(walletItemStack);
                }

                @Override
                public Text getDisplayName() {
                    return Text.literal("Wallet");
                }
            });
            user.playSound(ModSounds.WALLET_CLOSE, 1f, 1f);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public boolean onStackClicked(ItemStack walletStack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT) {
            return false;
        }
        ItemStack otherStack = slot.getStack();
        if (!otherStack.isEmpty() && otherStack.getItem() instanceof CoinItem coinItem) {
            int itemsToBeAdded = (MAX_COINS - WalletItem.getCurrencyFromNbt(walletStack)) / coinItem.currencyValue;
            int addedItems = WalletItem.addToWallet(walletStack, slot.takeStackRange(otherStack.getCount(), itemsToBeAdded, player));
            if (addedItems > 0) {
                this.playInsertSound(player);
            }
        }
        return true;
    }

    @Override
    public boolean onClicked(ItemStack walletStack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType != ClickType.RIGHT || !slot.canTakePartial(player) || otherStack.isEmpty()) {
            return false;
        }
        int addedItemsCount = WalletItem.addToWallet(walletStack, otherStack);
        if (addedItemsCount > 0) {
            this.playInsertSound(player);
            otherStack.decrement(addedItemsCount);
        }
        return true;
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return WalletItem.getCurrencyFromNbt(stack) > 0;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        return Math.min(1 + 12 * WalletItem.getCurrencyFromNbt(stack) / MAX_COINS, 13);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }

    private static int addToWallet(ItemStack wallet, ItemStack stackToAdd) {
        if (!(stackToAdd.getItem() instanceof CoinItem coinItem)) {
            return 0;
        }
        int walletCurrency = WalletItem.getCurrencyFromNbt(wallet);
        int itemsToBeAdded = Math.min(stackToAdd.getCount(), (MAX_COINS - walletCurrency) / coinItem.currencyValue);
        if (itemsToBeAdded == 0) {
            return 0;
        }
        WalletItem.writeCurrencyToNbt(wallet, WalletItem.getCurrencyFromNbt(wallet) + coinItem.currencyValue * itemsToBeAdded);
        return itemsToBeAdded;
    }

    private static Stream<ItemStack> getStacksForCurrency(int currencyAmount) {
        List<ItemStack> itemsToDrop = new ArrayList<>();


        List<CoinItem> coinItems = Lists.reverse(Registries.ITEM.stream().filter(item -> item instanceof CoinItem)
                .map(item -> (CoinItem) item)
                .sorted(Comparator.comparingInt(item -> item.currencyValue))
                .toList());

        for (CoinItem coinItem : coinItems) {
            if (coinItem.currencyValue <= currencyAmount) {
                int count = currencyAmount / coinItem.currencyValue;
                currencyAmount -= count * coinItem.currencyValue;
                itemsToDrop.add(new ItemStack(coinItem, count));
            }
        }
        return itemsToDrop.stream();
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, WalletItem.getStacksForCurrency(WalletItem.getCurrencyFromNbt(entity.getStack())));
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8f, 0.8f + entity.getWorld().getRandom().nextFloat() * 0.4f);
    }
}
