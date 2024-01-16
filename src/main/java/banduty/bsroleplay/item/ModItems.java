package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.entity.ModEntities;
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
    public static final Item DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC = registerItem("dolor_en_el_pecho_carola_music_disc",
            new MusicDiscItem(7, ModSounds.DOLOR_EN_EL_PECHO_CAROLA, new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1), 193));
    public static final Item HOLY_SEEDS = registerItem("holy_seeds",
            new HolySeeds(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item JUDGE_HAMMER = registerItem("judge_hammer",
            new JudgeHammer(new FabricItemSettings().maxCount(1).maxDamage(0).rarity(Rarity.RARE)));

    public static final Item POLICE_BATON = registerItem("police_baton",
            new SwordItem(ModToolMaterial.POLICE, 3, 1f, new FabricItemSettings().maxDamage(0).rarity(Rarity.UNCOMMON)));

    public static final Item HOLY_WEAPON = registerItem("holy_weapon",
            new HolyWeapon(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item JUDGE_CHESTPLATE = registerItem("judge_chestplate",
            new ArmorItem(ModArmorMaterials.JUDGE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item JUDGE_LEGGINGS = registerItem("judge_leggings",
            new ArmorItem(ModArmorMaterials.JUDGE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item JUDGE_BOOTS = registerItem("judge_boots",
            new ArmorItem(ModArmorMaterials.JUDGE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

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

    public static final Item HOLY_CLOUD_SPAWN_EGG = registerItem("holy_cloud_spawn_egg",
            new SpawnEggItem(ModEntities.HOLY_CLOUD, 0xCDCDCD, 0xffff00, new FabricItemSettings()));

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
            new Hook(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item CROWN = registerItem("crown",
            new CrownItem(ModArmorMaterials.KING, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item MINI_CROWN = registerItem("mini_crown",
            new MiniCrownItem(ModArmorMaterials.MINI_KING, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item DREAM_MASK = registerItem("dream_mask",
            new DreamMaskItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE)));

    public static final Item BUNNY_MASK = registerItem("bunny_mask",
            new BunnyMaskItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(HOLY_SEEDS);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BsRolePlay.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BsRolePlay.LOGGER.info("Registering Mod Items for " + BsRolePlay.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
