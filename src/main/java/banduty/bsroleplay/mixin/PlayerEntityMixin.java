package banduty.bsroleplay.mixin;

import banduty.bsroleplay.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements IEntityDataSaver {
    @Unique
    private NbtCompound persistentData;

    @Override
    public NbtCompound bsroleplay$getPersistentData() {
        if(this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Unique
    private boolean milkBlocked = false;

    @Override
    public boolean bsroleplay$isMilkBlocked() {
        return milkBlocked;
    }

    @Override
    public void bsroleplay$setMilkBlocked(boolean milkBlocked) {
        this.milkBlocked = milkBlocked;
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfo ci) {
        if (milkBlocked) {
            nbt.putBoolean("BlockedMilk", true);
        }
        if(persistentData != null) {
            nbt.put("bsroleplay.data", persistentData);
        }
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("BlockedMilk")) {
            milkBlocked = nbt.getBoolean("BlockedMilk");
        }
        if (nbt.contains("bsroleplay.data", 10)) {
            persistentData = nbt.getCompound("bsroleplay.data");
        }
    }
}