
package banduty.bsroleplay.util.loot_table;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.stream.Stream;

public class MobsLootTableModifier {

    public static void modifyMobsLootTables() {
        if (BsRolePlay.CONFIG.currency.hostileMobsDropCoins) {
            List<Identifier> lootTableIds = Stream.of(
                    EntityType.BLAZE, EntityType.CREEPER, EntityType.DROWNED, EntityType.EVOKER,
                    EntityType.HUSK, EntityType.MAGMA_CUBE, EntityType.PHANTOM, EntityType.PILLAGER,
                    EntityType.RAVAGER, EntityType.SKELETON, EntityType.STRAY, EntityType.VINDICATOR,
                    EntityType.WITCH, EntityType.WITHER_SKELETON, EntityType.ZOMBIE
            ).map(EntityType::getLootTableId).toList();

            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (lootTableIds.stream().anyMatch(id::equals)) {
                    LootPool.Builder bronzeCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getCopperCoinChanceHostileMobs()))
                            .with(ItemEntry.builder(ModItems.COPPER_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getCopperCoinMaxAmountHostileMobs())).build());

                    tableBuilder.pool(bronzeCoin.build());

                    LootPool.Builder goldCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getGoldCoinChanceHostileMobs()))
                            .with(ItemEntry.builder(ModItems.GOLD_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getGoldCoinMaxAmountHostileMobs())).build());

                    tableBuilder.pool(goldCoin.build());
                }
            });
        }

        if (BsRolePlay.CONFIG.currency.bossMobsDropCoins) {
            List<Identifier> lootTableIds = Stream.of(
                    EntityType.ELDER_GUARDIAN, EntityType.WARDEN, EntityType.WITHER
            ).map(EntityType::getLootTableId).toList();

            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (lootTableIds.stream().anyMatch(id::equals)) {
                    LootPool.Builder goldCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getGoldCoinChanceBossMobs()))
                            .with(ItemEntry.builder(ModItems.GOLD_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getGoldCoinMaxAmountBossMobs())).build());

                    tableBuilder.pool(goldCoin.build());

                    LootPool.Builder amethystCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getAmethystCoinChanceBossMobs()))
                            .with(ItemEntry.builder(ModItems.AMETHYST_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getAmethystCoinMaxAmountBossMobs())).build());

                    tableBuilder.pool(amethystCoin.build());
                }
            });
        }

        if (BsRolePlay.CONFIG.currency.enderDragonDropCoins) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (EntityType.ENDER_DRAGON.getLootTableId().equals(id)) {
                    LootPool.Builder amethystCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getAmethystCoinChanceEnderDragon()))
                            .with(ItemEntry.builder(ModItems.AMETHYST_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getAmethystCoinMaxAmountEnderDragon())).build());

                    tableBuilder.pool(amethystCoin.build());

                    LootPool.Builder netheriteCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getNetheriteCoinChanceEnderDragon()))
                            .with(ItemEntry.builder(ModItems.NETHERITE_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getNetheriteCoinMaxAmountEnderDragon())).build());

                    tableBuilder.pool(netheriteCoin.build());

                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.05f))
                            .with(ItemEntry.builder(ModItems.ENDERCUFFS))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    tableBuilder.pool(poolBuilder.build());
                }
            });
        }

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (EntityType.IRON_GOLEM.getLootTableId().equals(id) || EntityType.SNOW_GOLEM.getLootTableId().equals(id)) {
                LootPool.Builder bronzeCoin = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.common.getFusionCoreChanceGolem()))
                        .with(ItemEntry.builder(ModItems.FUSION_CORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.common.getFusionCoreAmountDropGolem())).build());

                tableBuilder.pool(bronzeCoin.build());
            }
        });
    }
}
