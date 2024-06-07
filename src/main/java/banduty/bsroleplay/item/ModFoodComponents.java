
package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent HEALKIT = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, BsRolePlay.CONFIG.common.getHealKitWeaknessTime() * 20), BsRolePlay.CONFIG.common.getHealKitWeaknessChance())
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, BsRolePlay.CONFIG.common.getHealKitBlindnessTime() * 20), BsRolePlay.CONFIG.common.getHealKitBlindnessChance())
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, BsRolePlay.CONFIG.common.getHealKitNauseaTime() * 20), BsRolePlay.CONFIG.common.getHealKitNauseaChance())
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 10), BsRolePlay.CONFIG.common.getHealKitInstantHealthChance())
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, BsRolePlay.CONFIG.common.getHealKitFireResistanceTime() * 20), BsRolePlay.CONFIG.common.getHealKitFireResistanceChance())
            .build();
}