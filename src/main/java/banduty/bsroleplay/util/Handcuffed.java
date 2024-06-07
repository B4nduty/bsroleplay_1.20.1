package banduty.bsroleplay.util;

import net.minecraft.nbt.NbtCompound;

public class Handcuffed {
    public static void setHandcuffed(IEntityDataSaver player, boolean handcuffed) {
        NbtCompound nbt = player.bsroleplay$getPersistentData();
        nbt.putBoolean("handcuffed", handcuffed);
    }
}
