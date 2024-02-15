package banduty.bsroleplay.config;

import banduty.bsroleplay.BsRolePlay;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = BsRolePlay.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/gold_block.png")
public class ModConfigs extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject()
    public Common common = new Common();

    @Config(name = BsRolePlay.MOD_ID)
    public static final class Common implements ConfigData {

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Pharaoh Staff throw Lightnings | Default: true")
        public boolean modifyPharaohStaffLightning = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Hook spawn Evoker Fang | Default: true")
        public boolean modifyHookEvokerFang = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Judge Hammer make Sound | Default: true")
        public boolean modifyJudgeHammerSound = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Police Baton give Slowness Effect | Default: true")
        public boolean modifyPoliceBatonSlowness = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Protection Set give Effects | Default: true")
        public boolean modifyProtectionSetEffects = true;

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Allow Police Set give Effect | Default: true")
        public boolean modifyPoliceSetEffects = true;

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Pharaoh Staff Cooldown in Seconds | Default: 5
                """)
        int pharaohStaffCooldown = 5;

        public int getPharaohStaffCooldown() {
            return Math.max(0, pharaohStaffCooldown);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Hook Cooldown in Seconds | Default: 4
                """)
        int hookCooldown = 4;

        public int getHookCooldown() {
            return Math.max(0, hookCooldown);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Judge Hammer Cooldown in Seconds | Default: 1
                """)
        int judgeHammerCooldown = 1;

        public int getJudgeHammerCooldown() {
            return Math.max(0, judgeHammerCooldown);
        }

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
                Police Baton Cooldown in Seconds | Default: 15
                """)
        int policeBatonCooldown = 15;

        public int getPoliceBatonCooldown() {
            return Math.max(0, policeBatonCooldown);
        }

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
                Happy Pill Blindness Chance | Default: 0.2f
                """)
        float happyPillBlindnessChance = 0.2f;

        public float getHappyPillBlindnessChance() {
            return Math.max(0, happyPillBlindnessChance);
        }

        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                Happy Pill Weakness Time in Seconds | Default: 40
                """)
        int happyPillWeaknessTime = 40;

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
                Happy Pill Nausea Chance | Default: 0.75f
                """)
        float happyPillNauseaChance = 0.75f;

        public float getHappyPillNauseaChance() {
            return Math.max(0, happyPillNauseaChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Instant Health Chance | Default: 0.25f
                """)
        float happyPillInstantHealthChance = 0.25f;

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
                Sad Pill Consume Time in Seconds | Default: 1
                """)
        int sadPillConsumeTime = 1;

        public int getSadPillConsumeTime() {
            return Math.max(0, sadPillConsumeTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Show Item Tooltips | Default: true")
        public boolean showItemTooltips = true;
    }
}