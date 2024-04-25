package banduty.bsroleplay.util.loot_table;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class BlocksLootTableModifier {

    private static final Identifier COPPER_ORE_ID
            = new Identifier("minecraft", "blocks/copper_ore");

    private static final Identifier DEEPSLATE_COPPER_ORE_ID
            = new Identifier("minecraft", "blocks/deepslate_copper_ore");

    private static final Identifier GOLD_ORE_ID
            = new Identifier("minecraft", "blocks/gold_ore");

    private static final Identifier DEEPSLATE_GOLD_ORE_ID
            = new Identifier("minecraft", "blocks/deepslate_gold_ore");

    public static void modifyBlocksLootTables() {
        if (BsRolePlay.CONFIG.currency.oresDropCoins) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (COPPER_ORE_ID.equals(id) || DEEPSLATE_COPPER_ORE_ID.equals(id)) {
                    LootPool.Builder bronzeCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getBronzeCoinChanceCopperOre()))
                            .with(ItemEntry.builder(ModItems.BRONZE_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getBronzeCoinMaxAmountCopperOre())).build());

                    tableBuilder.pool(bronzeCoin.build());
                }

                if (GOLD_ORE_ID.equals(id) || DEEPSLATE_GOLD_ORE_ID.equals(id)) {
                    LootPool.Builder goldCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getGoldCoinChanceGoldOre()))
                            .with(ItemEntry.builder(ModItems.GOLD_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getGoldCoinMaxAmountGoldOre())).build());

                    tableBuilder.pool(goldCoin.build());
                }
            });
        }
    }
}
