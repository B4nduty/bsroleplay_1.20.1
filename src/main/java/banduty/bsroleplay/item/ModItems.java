package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.ModBlocks;
import banduty.bsroleplay.item.custom.armor.*;
import banduty.bsroleplay.item.custom.blocks.TinyBandutyItem;
import banduty.bsroleplay.item.custom.blocks.currency.CoinItem;
import banduty.bsroleplay.item.custom.blocks.currency.CoinStackItem;
import banduty.bsroleplay.item.custom.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item ROLEPLAY_CORE = registerItem("roleplay_core",
            new Item(new FabricItemSettings()));

    public static final Item FUSION_CORE = registerItem("fusion_core",
            new Item(new FabricItemSettings()));

    public static final Item JUDGE_HAMMER = registerItem("judge_hammer",
            new JudgeHammer(new FabricItemSettings().maxCount(1)));

    public static final Item POLICE_BATON = registerItem("police_baton",
            new PoliceBaton(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item PHARAOH_STAFF = registerItem("pharaoh_staff",
            new PharaohStaff(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item POLICE_HELMET = registerItem("police_helmet",
            new PoliceArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item POLICE_CHESTPLATE = registerItem("police_chestplate",
            new PoliceArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item POLICE_LEGGINGS = registerItem("police_leggings",
            new PoliceArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item POLICE_BOOTS = registerItem("police_boots",
            new PoliceArmorItem(ModArmorMaterials.POLICE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item HALO = registerItem("halo",
            new HaloItem(ModArmorMaterials.HOLY, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item RED_PIRATE_HELMET = registerItem("red_pirate_helmet",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RED_PIRATE_CHESTPLATE = registerItem("red_pirate_chestplate",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RED_PIRATE_LEGGINGS = registerItem("red_pirate_leggings",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item BLUE_PIRATE_HELMET = registerItem("blue_pirate_helmet",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BLUE_PIRATE_CHESTPLATE = registerItem("blue_pirate_chestplate",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BLUE_PIRATE_LEGGINGS = registerItem("blue_pirate_leggings",
            new PirateArmorItem(ModArmorMaterials.PIRATE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item HOOK = registerItem("hook",
            new Hook(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item CROWN = registerItem("crown",
            new CrownItem(ModArmorMaterials.KING, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item MINI_CROWN = registerItem("mini_crown",
            new CrownItem(ModArmorMaterials.MINI_KING, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item DREAM_MASK = registerItem("dream_mask",
            new MasksItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BUNNY_MASK = registerItem("bunny_mask",
            new MasksItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item NEANDERTHAL_CHESTPLATE = registerItem("neanderthal_chestplate",
            new NeanderthalItem(ModArmorMaterials.NEANDERTHAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item FUNERAL_MASK = registerItem("funeral_mask",
            new FuneralMaskItem(ModArmorMaterials.PHARAOH, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item CIVIC_CROWN = registerItem("civic_crown",
            new RomanEmperorItem(ModArmorMaterials.ROMAN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROMAN_TOGA = registerItem("roman_toga",
            new RomanEmperorItem(ModArmorMaterials.ROMAN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item COWBOY_HAT = registerItem("cowboy_hat",
            new CowboyItem(ModArmorMaterials.COWBOY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PONCHO = registerItem("poncho",
            new CowboyItem(ModArmorMaterials.COWBOY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item PROTECTION_HELMET = registerItem("protection_helmet",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PROTECTION_CHESTPLATE = registerItem("protection_chestplate",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PROTECTION_LEGGINGS = registerItem("protection_leggings",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PROTECTION_BOOTS = registerItem("protection_boots",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item RED_PROTECTION_HELMET = registerItem("red_protection_helmet",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RED_PROTECTION_CHESTPLATE = registerItem("red_protection_chestplate",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RED_PROTECTION_LEGGINGS = registerItem("red_protection_leggings",
            new ProtectionClothingItem(ModArmorMaterials.PROTECTION, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item DEALER_MASK = registerItem("dealer_mask",
            new MasksItem(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item INVKIT = registerItem("invkit",
            new InvKit(new FabricItemSettings().maxCount(3).rarity(Rarity.UNCOMMON)));
    public static final Item HEALKIT = registerItem("healkit",
            new Item(new FabricItemSettings().food(ModFoodComponents.HEALKIT).maxCount(3).rarity(Rarity.UNCOMMON)));

    public static final Item GADGET_HAT = registerItem("gadget_hat",
            new GadgetArmor(ModArmorMaterials.MASK, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item LAWYER_BLACKBLUE_CHESTPLATE = registerItem("lawyer_blackblue_chestplate",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item LAWYER_BLACKGOLD_CHESTPLATE = registerItem("lawyer_blackgold_chestplate",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item LAWYER_BLACKRED_CHESTPLATE = registerItem("lawyer_blackred_chestplate",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item LAWYER_LEGGINGS_BLACK = registerItem("lawyer_leggings_black",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item LAWYER_BOOTS_BLACK = registerItem("lawyer_boots_black",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item LAWYER_PURPLERED_CHESTPLATE = registerItem("lawyer_purplered_chestplate",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item LAWYER_LEGGINGS_PURPLE = registerItem("lawyer_leggings_purple",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item LAWYER_BOOTS_PURPLE = registerItem("lawyer_boots_purple",
            new LawyerItem(ModArmorMaterials.MASK, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item BRIEFCASE = registerItem("briefcase",
            new BriefCase(new FabricItemSettings().maxCount(1)));
    public static final Item BLACK_BRIEFCASE = registerItem("black_briefcase",
            new BriefCase(new FabricItemSettings().maxCount(1)));
    public static final Item VIOLET_BRIEFCASE = registerItem("purple_briefcase",
            new BriefCase(new FabricItemSettings().maxCount(1)));

    public static final Item TINY_BANDUTY_ITEM = registerItem("tiny_banduty",
            new TinyBandutyItem(ModBlocks.TINY_BANDUTY, new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));

    public static final Item HANDCUFFS = registerItem("handcuffs",
            new HandCuffs(new FabricItemSettings().maxCount(1)));
    public static final Item HANDCUFFS_KEY = registerItem("handcuffs_key",
            new HandcuffsKey(new FabricItemSettings().maxCount(1)));
    public static final Item ENDERCUFFS = registerItem("endercuffs",
            new Endercuffs(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item FEDORA = registerItem("fedora",
            new ElegantItem(ModArmorMaterials.COWBOY, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)));
    public static final Item FEDORA_PURPLE = registerItem("fedora_purple",
            new ElegantItem(ModArmorMaterials.COWBOY, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)));

    public static final Item COPPER_COIN = registerItem("copper_coin",
            new CoinItem(ModBlocks.COPPER_COIN, 1, new FabricItemSettings()));
    public static final Item GOLD_COIN = registerItem("gold_coin",
            new CoinItem(ModBlocks.GOLD_COIN, 10, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item AMETHYST_COIN = registerItem("amethyst_coin",
            new CoinItem(ModBlocks.AMETHYST_COIN, 100, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item NETHERITE_COIN = registerItem("netherite_coin",
            new CoinItem(ModBlocks.NETHERITE_COIN, 1000, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item COPPER_COIN_STACK = registerItem("copper_coin_stack",
            new CoinStackItem(ModBlocks.COPPER_COIN_STACK, 9, new FabricItemSettings()));
    public static final Item GOLD_COIN_STACK = registerItem("gold_coin_stack",
            new CoinStackItem(ModBlocks.GOLD_COIN_STACK, 90, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item AMETHYST_COIN_STACK = registerItem("amethyst_coin_stack",
            new CoinStackItem(ModBlocks.AMETHYST_COIN_STACK, 900, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item NETHERITE_COIN_STACK = registerItem("netherite_coin_stack",
            new CoinStackItem(ModBlocks.NETHERITE_COIN_STACK, 9000, new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item WALLET = registerItem("wallet",
            new WalletItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BsRolePlay.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BsRolePlay.LOGGER.info("Registering Mod Items for " + BsRolePlay.MOD_ID);
    }
}