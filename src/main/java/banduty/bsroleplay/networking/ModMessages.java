package banduty.bsroleplay.networking;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.networking.packet.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier POLICE_SPEED_ID = new Identifier(BsRolePlay.MOD_ID, "police_speed");
    public static final Identifier STAMINA_INT_ID = new Identifier(BsRolePlay.MOD_ID, "stamina_int");
    public static final Identifier STAMINA_BOOLEAN_ID = new Identifier(BsRolePlay.MOD_ID, "stamina_boolean");
    public static final Identifier STAMINA_ZERO_ID = new Identifier(BsRolePlay.MOD_ID, "stamina_zero");
    public static final Identifier REGEN_STAMINA_ID = new Identifier(BsRolePlay.MOD_ID, "regen_stamina");
    public static final Identifier SET_STAMINA_ZERO_ID = new Identifier(BsRolePlay.MOD_ID, "set_stamina_zero");
    public static final Identifier SET_REGEN_STAMINA_TRUE_ID = new Identifier(BsRolePlay.MOD_ID, "set_regen_stamina_true");
    public static final Identifier SET_REGEN_STAMINA_FALSE_ID = new Identifier(BsRolePlay.MOD_ID, "set_regen_stamina_false");
    public static final Identifier CURRENCY_COUNTER = new Identifier(BsRolePlay.MOD_ID, "currency_counter");
    public static final Identifier VELOCITY_UPDATE = new Identifier(BsRolePlay.MOD_ID, "velocity_update");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(POLICE_SPEED_ID, PoliceEffectsC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SET_STAMINA_ZERO_ID, StaminaZeroC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SET_REGEN_STAMINA_TRUE_ID, RegenStaminaTrueC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SET_REGEN_STAMINA_FALSE_ID, RegenStaminaFalseC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(CURRENCY_COUNTER, UpdateCurrencyCounterPacketC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(STAMINA_INT_ID, StaminaIntS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(STAMINA_BOOLEAN_ID, StaminaBooleanS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(STAMINA_ZERO_ID, StaminaZeroS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(REGEN_STAMINA_ID, RegenStaminaS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(VELOCITY_UPDATE, VelocityUpdateS2CPacket::receive);
    }
}
