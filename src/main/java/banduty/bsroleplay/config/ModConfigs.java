package banduty.bsroleplay.config;

import banduty.bsroleplay.BsRolePlay;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = BsRolePlay.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
public class ModConfigs extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject()
    public Common common = new Common();

    @ConfigEntry.Category("currency")
    @ConfigEntry.Gui.TransitiveObject()
    public ModCurrency currency = new ModCurrency();

    @Config(name = BsRolePlay.MOD_ID + "-common")
    public static final class Common implements ConfigData {
        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Dune Caller Cooldown in Seconds | Default: 90
                Min Limit to 20 sec
                """)
        int duneCallerCooldown = 90;

        public int getDuneCallerCooldown() {
            return Math.max(20, duneCallerCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Dune Caller Spawns in Chests Chance | Default: 0.01f
                """)
        float duneCallerChestsChance = 0.01f;

        public float getDuneCallerChestsChance() {
            return Math.min(1, Math.max(0, duneCallerChestsChance));
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Poseidon's Talon Cooldown in Seconds | Default: 60
                """)
        int poseidonTalonCooldown = 60;

        public int getPoseidonTalonCooldown() {
            return Math.max(0, poseidonTalonCooldown);
        }


        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Poseidon's Talon Spawns in Chests Chance | Default: 0.1f
                """)
        float poseidonTalonChestsChance = 0.1f;

        public float getPoseidonTalonChestsChance() {
            return Math.min(1, Math.max(0, poseidonTalonChestsChance));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Judge Hammer make Sound | Default: true")
        public boolean modifyJudgeHammerSound = true;


        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Judge Hammer Cooldown in Seconds | Default: 1
                """)
        int judgeHammerCooldown = 1;

        public int getJudgeHammerCooldown() {
            return Math.max(0, judgeHammerCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Police Baton give Slowness Effect | Default: true")
        public boolean modifyPoliceBatonSlowness = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Police Baton Slowness Level | Default: 3
                """)
        int policeBatonSlownessLevel = 3;

        public int getPoliceBatonSlownessLevel() {
            return Math.max(0, policeBatonSlownessLevel);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Police Baton Slowness Duration in Seconds | Default: 4
                """)
        int policeBatonSlownessDuration = 4;

        public int getPoliceBatonSlownessDuration() {
            return Math.max(0, policeBatonSlownessDuration);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Police Baton Cooldown in Seconds | Default: 10
                """)
        int policeBatonCooldown = 10;

        public int getPoliceBatonCooldown() {
            return Math.max(0, policeBatonCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Protection Set give Effects | Default: true")
        public boolean modifyProtectionSetEffects = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Police Set give Effect | Default: true")
        public boolean modifyPoliceSetEffects = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Handcuffs Slowness Level | Default: 6
                """)
        int handcuffsSlownessLevel = 6;

        public int getHandcuffsSlownessLevel() {
            return Math.max(0, handcuffsSlownessLevel);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Handcuffs Weakness Level | Default: 6
                """)
        int handcuffsWeaknessLevel = 6;

        public int getHandcuffsWeaknessLevel() {
            return Math.max(0, handcuffsWeaknessLevel);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Endercuffs work as a Flint and Steel | Default: true")
        public boolean modifyEndercuffsFire = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Fusion Core drop chance by Golems | Default: 0.05f
                """)
        float fusionCoreChanceGolem = 0.05f;

        public float getFusionCoreChanceGolem() {
            return Math.min(1, Math.max(0, fusionCoreChanceGolem));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Fusion Core amount drop by Golems | Default: 3.0f
                """)
        float fusionCoreAmountDropGolem = 1.0f;

        public float getFusionCoreAmountDropGolem() {
            return Math.max(0, fusionCoreAmountDropGolem);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                HealKit Blindness Time in Seconds | Default: 60
                """)
        int healKitBlindnessTime = 60;

        public int getHealKitBlindnessTime() {
            return Math.max(0, healKitBlindnessTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                HealKit Blindness Chance | Default: 0.01f
                """)
        float healKitBlindnessChance = 0.01f;

        public float getHealKitBlindnessChance() {
            return Math.min(1, Math.max(0, healKitBlindnessChance));
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                HealKit Weakness Time in Seconds | Default: 40
                """)
        int healKitWeaknessTime = 40;

        public int getHealKitWeaknessTime() {
            return Math.max(0, healKitWeaknessTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                HealKit Weakness Chance | Default: 0.2f
                """)
        float healKitWeaknessChance = 0.2f;

        public float getHealKitWeaknessChance() {
            return Math.min(1, Math.max(0, healKitWeaknessChance));
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                HealKit Nausea Time in Seconds | Default: 25
                """)
        int healKitNauseaTime = 25;

        public int getHealKitNauseaTime() {
            return Math.max(0, healKitNauseaTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                HealKit Nausea Chance | Default: 0.03f
                """)
        float healKitNauseaChance = 0.03f;

        public float getHealKitNauseaChance() {
            return Math.min(1, Math.max(0, healKitNauseaChance));
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                HealKit Fire Resistance Time in Seconds | Default: 90
                """)
        int healKitFireResistanceTime = 90;

        public int getHealKitFireResistanceTime() {
            return Math.max(0, healKitFireResistanceTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                HealKit Fire Resistance Chance | Default: 1.0f
                """)
        float healKitFireResistanceChance = 1.0f;

        public float getHealKitFireResistanceChance() {
            return Math.min(1, Math.max(0, healKitFireResistanceChance));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                HealKit Instant Health Chance | Default: 1.0f
                """)
        float healKitInstantHealthChance = 1.0f;

        public float getHealKitInstantHealthChance() {
            return Math.min(1, Math.max(0, healKitInstantHealthChance));
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                InvKit Consume Time in Seconds | Default: 0.5
                """)
        double invKitConsumeTime = 0.5;

        public double getInvKitConsumeTime() {
            return Math.max(0, invKitConsumeTime);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                InvKit 1st Stage in Seconds | Default: 20
                """)
        int invKit1stStageTime = 20;

        public int getInvKit1stStageTime() {
            return Math.max(0, invKit1stStageTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Funeral Mask Spawns in Chests Chance | Default: 0.05f
                """)
        float funeralMaskChestsChance = 0.05f;

        public float getFuneralMaskChestsChance() {
            return Math.min(1, Math.max(0, funeralMaskChestsChance));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Gadget Hat Spawns in Chests Chance | Default: 0.15f
                """)
        float gadgetHatChestsChance = 0.15f;

        public float getGadgetHatChestsChance() {
            return Math.min(1, Math.max(0, gadgetHatChestsChance));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Show Item Tooltips | Default: true")
        public boolean showItemTooltips = true;
    }

    @Config(name = BsRolePlay.MOD_ID + "-currency")
    public static final class ModCurrency implements ConfigData {
        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Coin Price | Default: true")
        public boolean showCoinPrice = true;

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Wallet Max Coins | Default: 99999
                """)
        int walletMaxCoins = 99999;

        public int getWalletMaxCoins() {
            return Math.min(99999, Math.max(0, walletMaxCoins));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Hostile Mobs Drop Coins | Default: true")
        public boolean hostileMobsDropCoins = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Boss Mobs Drop Coins | Default: true")
        public boolean bossMobsDropCoins = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Ender Dragon Drop Coins | Default: true")
        public boolean enderDragonDropCoins = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Ores Drop Coins | Default: true")
        public boolean oresDropCoins = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Copper Coin drop chance by Hostile Mobs | Default: 0.15f
                """)
        float copperCoinChanceHostileMobs = 0.15f;

        public float getCopperCoinChanceHostileMobs() {
            return Math.min(1, Math.max(0, copperCoinChanceHostileMobs));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Copper Coin amount drop by Hostile Mobs | Default: 3.0f
                """)
        float copperCoinMaxAmountHostileMobs = 3.0f;

        public float getCopperCoinMaxAmountHostileMobs() {
            return Math.max(0, copperCoinMaxAmountHostileMobs);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Gold Coin drop chance by Hostile Mobs | Default: 0.05f
                """)
        float goldCoinChanceHostileMobs = 0.05f;

        public float getGoldCoinChanceHostileMobs() {
            return Math.min(1, Math.max(0, goldCoinChanceHostileMobs));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Gold Coin amount drop by Hostile Mobs | Default: 1.0f
                """)
        float goldCoinMaxAmountHostileMobs = 1.0f;

        public float getGoldCoinMaxAmountHostileMobs() {
            return Math.max(0, goldCoinMaxAmountHostileMobs);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Gold Coin drop chance by Boss Mobs | Default: 1.0f
                """)
        float goldCoinChanceBossMobs = 1.0f;

        public float getGoldCoinChanceBossMobs() {
            return Math.min(1, Math.max(0, goldCoinChanceBossMobs));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Gold Coin amount drop by Boss Mobs | Default: 3.0f
                """)
        float goldCoinMaxAmountBossMobs = 2.0f;

        public float getGoldCoinMaxAmountBossMobs() {
            return Math.max(0, goldCoinMaxAmountBossMobs);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Amethyst Coin drop chance by Boss Mobs | Default: 0.2f
                """)
        float amethystCoinChanceBossMobs = 0.2f;

        public float getAmethystCoinChanceBossMobs() {
            return Math.min(1, Math.max(0, amethystCoinChanceBossMobs));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Amethyst Coin amount drop by Boss Mobs | Default: 1.0f
                """)
        float amethystCoinMaxAmountBossMobs = 1.0f;

        public float getAmethystCoinMaxAmountBossMobs() {
            return Math.max(0, amethystCoinMaxAmountBossMobs);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Amethyst Coin drop chance by Ender Dragon | Default: 1.0f
                """)
        float amethystCoinChanceEnderDragon = 1.0f;

        public float getAmethystCoinChanceEnderDragon() {
            return Math.min(1, Math.max(0, amethystCoinChanceEnderDragon));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Amethyst Coin amount drop by Ender Dragon | Default: 2.0f
                """)
        float amethystCoinMaxAmountEnderDragon = 2.0f;

        public float getAmethystCoinMaxAmountEnderDragon() {
            return Math.max(0, amethystCoinMaxAmountEnderDragon);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Netherite Coin drop chance by Ender Dragon | Default: 0.05f
                """)
        float netheriteCoinChanceEnderDragon = 0.05f;

        public float getNetheriteCoinChanceEnderDragon() {
            return Math.min(1, Math.max(0, netheriteCoinChanceEnderDragon));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Netherite Coin amount drop by Ender Dragon | Default: 1.0f
                """)
        float netheriteCoinMaxAmountEnderDragon = 1.0f;

        public float getNetheriteCoinMaxAmountEnderDragon() {
            return Math.max(0, netheriteCoinMaxAmountEnderDragon);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Copper Coin drop chance by Ores | Default: 0.05f
                """)
        float copperCoinChanceOres = 0.05f;

        public float getCopperCoinChanceOres() {
            return Math.min(1, Math.max(0, copperCoinChanceOres));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Copper Coin amount drop by Ores | Default: 2.0f
                """)
        float copperCoinMaxAmountOres = 2.0f;

        public float getCopperCoinMaxAmountOres() {
            return Math.max(0, copperCoinMaxAmountOres);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Gold Coin drop chance by Ores | Default: 0.005f
                """)
        float goldCoinChanceOres = 0.005f;

        public float getGoldCoinChanceOres() {
            return Math.min(1, Math.max(0, goldCoinChanceOres));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Gold Coin amount drop by Ores | Default: 1.0f
                """)
        float goldCoinMaxAmountOres = 1.0f;

        public float getGoldCoinMaxAmountOres() {
            return Math.max(0, goldCoinMaxAmountOres);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Amethyst Coin drop chance by Ores | Default: 0.0001f
                """)
        float amethystCoinChanceOres = 0.0001f;

        public float getAmethystCoinChanceOres() {
            return Math.min(1, Math.max(0, amethystCoinChanceOres));
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Max Amethyst Coin amount drop by Ores | Default: 1.0f
                """)
        float amethystCoinMaxAmountOres = 1.0f;

        public float getAmethystCoinMaxAmountOres() {
            return Math.max(0, amethystCoinMaxAmountOres);
        }
    }
}