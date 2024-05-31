
package banduty.bsroleplay.util.loot_table;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class BlocksLootTableModifier {
    public static void modifyBlocksLootTables() {

        if (BsRolePlay.CONFIG.currency.oresDropCoins) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (Blocks.COPPER_ORE.getLootTableId().equals(id) || Blocks.DEEPSLATE_COPPER_ORE.getLootTableId().equals(id)) {
                    LootPool.Builder bronzeCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getCopperCoinChanceCopperOre()))
                            .with(ItemEntry.builder(ModItems.COPPER_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getCopperCoinMaxAmountCopperOre())).build());

                    tableBuilder.pool(bronzeCoin.build());
                }

                if (Blocks.GOLD_ORE.getLootTableId().equals(id) || Blocks.DEEPSLATE_GOLD_ORE.getLootTableId().equals(id)) {
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
