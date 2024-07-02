package banduty.bsroleplay.effect;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect SANDSTORM = new SandstormEffect(StatusEffectCategory.HARMFUL, 16749568);
    public static final StatusEffect TIDAL_SURGE = new TidalSurgeEffect(StatusEffectCategory.HARMFUL, 16776960);

    public static void registerStatusEffect(String name, StatusEffect effect) {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(BsRolePlay.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        registerStatusEffect("sandstorm", SANDSTORM);
        registerStatusEffect("tidal_surge", TIDAL_SURGE);
    }
}
