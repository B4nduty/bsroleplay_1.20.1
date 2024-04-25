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

public class MobsLootTableModifier {
    private static final Identifier BLAZE_ID
            = new Identifier("minecraft", "entities/blaze");

    private static final Identifier CREEPER_ID
            = new Identifier("minecraft", "entities/creeper");

    private static final Identifier DROWNED_ID
            = new Identifier("minecraft", "entities/drowned");

    private static final Identifier EVOKER_ID
            = new Identifier("minecraft", "entities/evoker");

    private static final Identifier HUSK_ID
            = new Identifier("minecraft", "entities/husk");

    private static final Identifier MAGMA_CUBE_ID
            = new Identifier("minecraft", "entities/magma_cube");

    private static final Identifier PHANTOM_ID
            = new Identifier("minecraft", "entities/phantom");

    private static final Identifier PILLAGER_ID
            = new Identifier("minecraft", "entities/pillager");

    private static final Identifier RAVAGER_ID
            = new Identifier("minecraft", "entities/ravager");

    private static final Identifier SKELETON_ID
            = new Identifier("minecraft", "entities/skeleton");

    private static final Identifier STRAY_ID
            = new Identifier("minecraft", "entities/stray");

    private static final Identifier VINDICATOR_ID
            = new Identifier("minecraft", "entities/vindicator");

    private static final Identifier WITCH_ID
            = new Identifier("minecraft", "entities/witch");

    private static final Identifier WITHER_SKELETON_ID
            = new Identifier("minecraft", "entities/wither_skeleton");

    private static final Identifier ZOMBIE_ID
            = new Identifier("minecraft", "entities/zombie");

    private static final Identifier ELDER_GUARDIAN_ID
            = new Identifier("minecraft", "entities/elder_guardian");

    private static final Identifier ENDER_DRAGON_ID
            = new Identifier("minecraft", "entities/ender_dragon");

    private static final Identifier WARDEN_ID
            = new Identifier("minecraft", "entities/warden");

    private static final Identifier WITHER_ID
            = new Identifier("minecraft", "entities/wither");

    private static final Identifier IRON_GOLEM_ID
            = new Identifier("minecraft", "entities/iron_golem");

    private static final Identifier SNOW_GOLEM_ID
            = new Identifier("minecraft", "entities/snow_golem");

    public static void modifyMobsLootTables() {
        if (BsRolePlay.CONFIG.currency.hostileMobsDropCoins) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (BLAZE_ID.equals(id) || CREEPER_ID.equals(id) || DROWNED_ID.equals(id) || EVOKER_ID.equals(id) ||
                        HUSK_ID.equals(id) || MAGMA_CUBE_ID.equals(id) || PHANTOM_ID.equals(id) ||
                        PILLAGER_ID.equals(id) || RAVAGER_ID.equals(id) || SKELETON_ID.equals(id) ||
                        STRAY_ID.equals(id) || VINDICATOR_ID.equals(id) || WITCH_ID.equals(id) ||
                        WITHER_SKELETON_ID.equals(id) || ZOMBIE_ID.equals(id)) {
                    LootPool.Builder bronzeCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getBronzeCoinChanceHostileMobs()))
                            .with(ItemEntry.builder(ModItems.BRONZE_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getBronzeCoinMaxAmountHostileMobs())).build());

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
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (ELDER_GUARDIAN_ID.equals(id) || ENDER_DRAGON_ID.equals(id) || WARDEN_ID.equals(id) || WITHER_ID.equals(id)) {
                    LootPool.Builder bronzeCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getBronzeCoinChanceBossMobs()))
                            .with(ItemEntry.builder(ModItems.BRONZE_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getBronzeCoinMaxAmountBossMobs())).build());

                    tableBuilder.pool(bronzeCoin.build());

                    LootPool.Builder goldCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getGoldCoinChanceBossMobs()))
                            .with(ItemEntry.builder(ModItems.GOLD_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getGoldCoinMaxAmountBossMobs())).build());

                    tableBuilder.pool(goldCoin.build());

                    LootPool.Builder netheriteCoin = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(BsRolePlay.CONFIG.currency.getNetheriteCoinChanceBossMobs()))
                            .with(ItemEntry.builder(ModItems.NETHERITE_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, BsRolePlay.CONFIG.currency.getNetheriteCoinMaxAmountBossMobs())).build());

                    tableBuilder.pool(netheriteCoin.build());
                }
            });
        }

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (IRON_GOLEM_ID.equals(id) || SNOW_GOLEM_ID.equals(id)) {
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
