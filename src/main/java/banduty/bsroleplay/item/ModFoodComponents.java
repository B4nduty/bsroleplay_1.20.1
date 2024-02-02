package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PILL = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, BsRolePlay.CONFIG.common.getHappyPillWeaknessTime()*20), BsRolePlay.CONFIG.common.getHappyPillWeaknessChance())
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, BsRolePlay.CONFIG.common.getHappyPillBlindnessTime()*20), BsRolePlay.CONFIG.common.getHappyPillBlindnessChance())
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, BsRolePlay.CONFIG.common.getHappyPillNauseaTime()*20), BsRolePlay.CONFIG.common.getHappyPillNauseaChance())
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 10), BsRolePlay.CONFIG.common.getHappyPillInstantHealthChance())
            .build();
}
