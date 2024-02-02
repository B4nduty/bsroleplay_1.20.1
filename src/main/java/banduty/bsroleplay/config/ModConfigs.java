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
                Happy Pill Weakness Time in Seconds | Default: 80
                """)
        int happyPillWeaknessTime = 80;

        public int getHappyPillWeaknessTime() {
            return Math.max(0, happyPillWeaknessTime);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Weakness Chance | Default: 0.25f
                """)
        float happyPillWeaknessChance = 0.25f;

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
                Happy Pill Nausea Chance | Default: 1f
                """)
        float happyPillNauseaChance = 1.0f;

        public float getHappyPillNauseaChance() {
            return Math.max(0, happyPillNauseaChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("""
                Happy Pill Instant Health Chance | Default: 0.05f
                """)
        float happyPillInstantHealthChance = 0.05f;

        public float getHappyPillInstantHealthChance() {
            return Math.max(0, happyPillInstantHealthChance);
        }

        @ConfigEntry.Gui.Tooltip(count = 0)
        @Comment("Show Item Tooltips | Default: true")
        public boolean showItemTooltips = true;
    }
}