package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.custom.*;
import banduty.bsroleplay.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item ROLEPLAY_CORE = registerItem("roleplay_core",
            new RoleplayCore(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC = registerItem("dolor_en_el_pecho_carola_music_disc",
            new MusicDiscItem(7, ModSounds.DOLOR_EN_EL_PECHO_CAROLA, new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1), 113));
    public static final Item JUDGE_HAMMER = registerItem("judge_hammer",
            new JudgeHammer(new FabricItemSettings().maxCount(1).maxDamage(0).rarity(Rarity.UNCOMMON)));

    public static final Item POLICE_BATON = registerItem("police_baton",
            new PoliceBaton(ModToolMaterial.POLICE, new FabricItemSettings().maxDamage(0).rarity(Rarity.UNCOMMON)));

    public static final Item PHARAOH_STAFF = registerItem("pharaoh_staff",
            new PharaohStaff(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item POLICE_HELMET = registerItem("police_helmet",
            new PoliceArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item POLICE_CHESTPLATE = registerItem("police_chestplate",
            new ArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item POLICE_LEGGINGS = registerItem("police_leggings",
            new ArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item POLICE_BOOTS = registerItem("police_boots",
            new ArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item HALO = registerItem("halo",
            new HaloItem(ModArmorMaterials.HOLY, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item RED_PIRATE_HELMET = registerItem("red_pirate_helmet",
            new RedPirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RED_PIRATE_CHESTPLATE = registerItem("red_pirate_chestplate",
            new RedPirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RED_PIRATE_LEGGINGS = registerItem("red_pirate_leggings",
            new RedPirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item BLUE_PIRATE_HELMET = registerItem("blue_pirate_helmet",
            new BluePirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BLUE_PIRATE_CHESTPLATE = registerItem("blue_pirate_chestplate",
            new BluePirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BLUE_PIRATE_LEGGINGS = registerItem("blue_pirate_leggings",
            new BluePirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item HOOK = registerItem("hook",
            new Hook(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item CROWN = registerItem("crown",
            new CrownItem(ModArmorMaterials.KING, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item MINI_CROWN = registerItem("mini_crown",
            new MiniCrownItem(ModArmorMaterials.MINI_KING, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item DREAM_MASK = registerItem("dream_mask",
            new DreamMaskItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item BUNNY_MASK = registerItem("bunny_mask",
            new BunnyMaskItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item NEANDERTHAL_CHESTPLATE = registerItem("neanderthal_chestplate",
            new NeanderthalItem(ModArmorMaterials.NEANDERTHAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item FUNERAL_MASK = registerItem("funeral_mask",
            new FuneralMaskItem(ModArmorMaterials.PHARAOH, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item CIVIC_CROWN= registerItem("civic_crown",
            new RomanEmperorItem(ModArmorMaterials.ROMAN, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item HAPPY_PILL= registerItem("happy_pill",
            new Item(new FabricItemSettings().food(ModFoodComponents.PILL).maxCount(BsRolePlay.CONFIG.common.getHappyPillMaxStack()).rarity(Rarity.RARE)));

    public static final Item COWBOY_HAT= registerItem("cowboy_hat",
            new CowboyItem(ModArmorMaterials.COWBOY, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item PONCHO= registerItem("poncho",
            new CowboyItem(ModArmorMaterials.COWBOY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item PROTECTION_HELMET= registerItem("protection_helmet",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PROTECTION_CHESTPLATE= registerItem("protection_chestplate",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PROTECTION_LEGGINGS= registerItem("protection_leggings",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PROTECTION_BOOTS= registerItem("protection_boots",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BsRolePlay.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BsRolePlay.LOGGER.info("Registering Mod Items for " + BsRolePlay.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
