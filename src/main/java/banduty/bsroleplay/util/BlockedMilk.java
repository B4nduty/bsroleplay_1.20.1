package banduty.bsroleplay.util;

public class BlockedMilk {
    public static void setMilkBlocked(IEntityDataSaver player, boolean milkBlocked) {
        player.bsroleplay$setMilkBlocked(milkBlocked);
    }

    public static boolean isMilkBlocked(IEntityDataSaver player) {
        return player.bsroleplay$isMilkBlocked();
    }
}
