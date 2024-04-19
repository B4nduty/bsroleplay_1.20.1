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

    @Config(name = BsRolePlay.MOD_ID)
    public static final class Common implements ConfigData {

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Pharaoh Staff throw Lightnings | Default: true")
        public boolean modifyPharaohStaffLightning = true;


        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Pharaoh Staff Cooldown in Seconds | Default: 15
                """)
        int pharaohStaffCooldown = 15;

        public int getPharaohStaffCooldown() {
            return Math.max(0, pharaohStaffCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Pharaoh Staff Spawns in Chests Chance | Default: 0.05f
                """)
        float pharaohStaffChestsChance = 0.05f;

        public float getPharaohStaffChestsChance() {
            return Math.max(0, pharaohStaffChestsChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Hook spawn Evoker Fang | Default: true")
        public boolean modifyHookEvokerFang = true;


        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Hook Cooldown in Seconds | Default: 8
                """)
        int hookCooldown = 8;

        public int getHookCooldown() {
            return Math.max(0, hookCooldown);
        }


        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Hook Spawns in Chests Chance | Default: 0.5f
                """)
        float hookChestsChance = 0.5f;

        public float getHookChestsChance() {
            return Math.max(0, hookChestsChance);
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
                Police Set Speed Level | Default: 1
                """)
        int policeSetSpeedLevel = 1;

        public int getPoliceSetSpeedLevel() {
            return Math.max(0, policeSetSpeedLevel);
        }

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

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Handcuffs Cooldown in Seconds | Default: 3
                """)
        int handcuffsCooldown = 3;

        public int getHandcuffsCooldown() {
            return Math.max(0, handcuffsCooldown);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Anti-God Handcuffs work as a Flint and Steel | Default: true")
        public boolean modifyAntiGodHandcuffsFire = true;

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Happy Pill Blindness Time in Seconds | Default: 40
                """)
        int happyPillBlindnessTime = 40;

        public int getHappyPillBlindnessTime() {
            return Math.max(0, happyPillBlindnessTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Blindness Chance | Default: 0.1f
                """)
        float happyPillBlindnessChance = 0.1f;

        public float getHappyPillBlindnessChance() {
            return Math.max(0, happyPillBlindnessChance);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Happy Pill Weakness Time in Seconds | Default: 30
                """)
        int happyPillWeaknessTime = 30;

        public int getHappyPillWeaknessTime() {
            return Math.max(0, happyPillWeaknessTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Weakness Chance | Default: 1f
                """)
        float happyPillWeaknessChance = 1f;

        public float getHappyPillWeaknessChance() {
            return Math.max(0, happyPillWeaknessChance);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Happy Pill Nausea Time in Seconds | Default: 30
                """)
        int happyPillNauseaTime = 30;

        public int getHappyPillNauseaTime() {
            return Math.max(0, happyPillNauseaTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Nausea Chance | Default: 0.1f
                """)
        float happyPillNauseaChance = 0.1f;

        public float getHappyPillNauseaChance() {
            return Math.max(0, happyPillNauseaChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Instant Health Chance | Default: 0.5f
                """)
        float happyPillInstantHealthChance = 0.5f;

        public float getHappyPillInstantHealthChance() {
            return Math.max(0, happyPillInstantHealthChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Max Stack | Default: 3
                """)
        int happyPillMaxStack = 3;

        public int getHappyPillMaxStack() {
            return Math.max(0, happyPillMaxStack);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Sad Pill Max Stack | Default: 3
                """)
        int sadPillMaxStack = 3;

        public int getSadPillMaxStack() {
            return Math.max(0, sadPillMaxStack);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Sad Pill Consume Time in Seconds | Default: 2
                """)
        int sadPillConsumeTime = 2;

        public int getSadPillConsumeTime() {
            return Math.max(0, sadPillConsumeTime);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Sad Pill 1st Stage in Seconds | Default: 30
                """)
        int sadPill1stStageTime = 30;

        public int getSadPill1stStageTime() {
            return Math.max(0, sadPill1stStageTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Pill Core Spawns in Chests Chance | Default: 0.25f
                """)
        float pillCoreChestsChance = 0.25f;

        public float getPillCoreChestsChance() {
            return Math.max(0, pillCoreChestsChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Funeral Mask Spawns in Chests Chance | Default: 0.2f
                """)
        float funeralMaskChestsChance = 0.2f;

        public float getFuneralMaskChestsChance() {
            return Math.max(0, funeralMaskChestsChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Gadget Hat Spawns in Chests Chance | Default: 0.1f
                """)
        float gadgetHatChestsChance = 0.1f;

        public float getGadgetHatChestsChance() {
            return Math.max(0, gadgetHatChestsChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Show Item Tooltips | Default: true")
        public boolean showItemTooltips = true;
    }
}