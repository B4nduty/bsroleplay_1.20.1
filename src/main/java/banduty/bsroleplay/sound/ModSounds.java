package banduty.bsroleplay.sound;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent JUDGE_HAMMER_RIGHT_CLICK = registerSoundEvent("judge_hammer_right_click");
    public static final SoundEvent DOLOR_EN_EL_PECHO_CAROLA = registerSoundEvent("dolor_en_el_pecho_carola");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(BsRolePlay.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
        BsRolePlay.LOGGER.info("Registering Sounds for " + BsRolePlay.MOD_ID);
    }
}
