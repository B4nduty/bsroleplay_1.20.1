package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    POLICE("", 15, new int[] { 3, 8, 6, 3 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    HOLY("", 25, new int[] { 1, 0, 0, 0 }, 19,
            SoundEvents.BLOCK_AMETHYST_BLOCK_PLACE, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    PIRATE("", 7, new int[] { 2, 6, 4, 0 }, 19,
    SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    KING("", 10, new int[] { 3, 0, 0, 0 }, 19,
    SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    MINI_KING("", 3, new int[] { 1, 0, 0, 0 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    MASK("", 3, new int[] { 1, 0, 0, 0 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    NEANDERTHAL("", 5, new int[] { 0, 3, 0, 0 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    PHARAOH("", 20, new int[] { 5, 0, 0, 0 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),
    ROMAN("", 2, new int[] { 2, 5, 0, 0 }, 19,
            SoundEvents.BLOCK_AZALEA_LEAVES_PLACE, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    COWBOY("", 3, new int[] { 3, 0, 0, 0 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE)),

    PROTECTION("", 11, new int[] { 1, 4, 3, 2 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 2f, 0.1f, () -> Ingredient.ofItems(ModItems.ROLEPLAY_CORE))

    ;

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return BsRolePlay.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
