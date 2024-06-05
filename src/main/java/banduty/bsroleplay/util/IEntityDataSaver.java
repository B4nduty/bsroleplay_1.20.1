package banduty.bsroleplay.util;

import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
    NbtCompound bsroleplay$getPersistentData();

    boolean bsroleplay$isMilkBlocked();

    void bsroleplay$setMilkBlocked(boolean milkBlocked);
}
