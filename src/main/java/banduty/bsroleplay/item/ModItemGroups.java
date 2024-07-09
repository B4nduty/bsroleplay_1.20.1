package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BSROLEPLAY_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BsRolePlay.MOD_ID, "roleplay_item"),
            FabricItemGroup.builder().displayName(Text.literal("BsRoleplay Item"))
                    .icon(() -> new ItemStack(ModItems.ROLEPLAY_CORE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ROLEPLAY_CORE);
                        entries.add(ModItems.FUSION_CORE);
                        entries.add(ModItems.HEALKIT);
                        entries.add(ModItems.INVKIT);
                        entries.add(ModItems.WALLET);
                        entries.add(ModItems.BRIEFCASE);
                        entries.add(ModItems.BLACK_BRIEFCASE);
                        entries.add(ModItems.VIOLET_BRIEFCASE);
                        entries.add(ModItems.JUDGE_HAMMER);
                        entries.add(ModItems.POLICE_BATON);
                        entries.add(ModItems.HANDCUFFS_KEY);
                        entries.add(ModItems.HANDCUFFS);
                        entries.add(ModItems.ENDERCUFFS);
                        entries.add(ModItems.POSEIDON_TALON);
                        entries.add(ModItems.DUNE_CALLER);
                        entries.add(ModItems.SPECTRAL_SCANNER);
                    })
                    .build());

    public static final ItemGroup BSROLEPLAY_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BsRolePlay.MOD_ID, "roleplay_block"),
            FabricItemGroup.builder().displayName(Text.literal("BsRoleplay Block"))
                    .icon(() -> new ItemStack(ModItems.TINY_BANDUTY_ITEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TINY_BANDUTY_ITEM);
                        entries.add(ModItems.COPPER_COIN);
                        entries.add(ModItems.COPPER_COIN_STACK);
                        entries.add(ModItems.GOLD_COIN);
                        entries.add(ModItems.GOLD_COIN_STACK);
                        entries.add(ModItems.AMETHYST_COIN);
                        entries.add(ModItems.AMETHYST_COIN_STACK);
                        entries.add(ModItems.NETHERITE_COIN);
                        entries.add(ModItems.NETHERITE_COIN_STACK);
                        entries.add(ModItems.SHOP);
                        entries.add(ModItems.CREATIVE_SHOP);
                    })
                    .build());

    public static final ItemGroup BSROLEPLAY_ARMOR_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BsRolePlay.MOD_ID, "roleplay_armor"),
            FabricItemGroup.builder().displayName(Text.literal("BsRoleplay Armor"))
                    .icon(() -> new ItemStack(ModItems.CIVIC_CROWN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.POLICE_HELMET);
                        entries.add(ModItems.POLICE_CHESTPLATE);
                        entries.add(ModItems.POLICE_LEGGINGS);
                        entries.add(ModItems.POLICE_BOOTS);

                        entries.add(ModItems.FEDORA);

                        entries.add(ModItems.LAWYER_BLACKBLUE_CHESTPLATE);
                        entries.add(ModItems.LAWYER_BLACKGOLD_CHESTPLATE);
                        entries.add(ModItems.LAWYER_BLACKRED_CHESTPLATE);
                        entries.add(ModItems.LAWYER_LEGGINGS_BLACK);
                        entries.add(ModItems.LAWYER_BOOTS_BLACK);

                        entries.add(ModItems.FEDORA_PURPLE);

                        entries.add(ModItems.LAWYER_PURPLERED_CHESTPLATE);
                        entries.add(ModItems.LAWYER_LEGGINGS_PURPLE);
                        entries.add(ModItems.LAWYER_BOOTS_PURPLE);


                        entries.add(ModItems.PIRATE_HELMET);
                        entries.add(ModItems.PIRATE_CHESTPLATE);
                        entries.add(ModItems.PIRATE_LEGGINGS);

                        entries.add(ModItems.COWBOY_HAT);
                        entries.add(ModItems.PONCHO);

                        entries.add(ModItems.PROTECTION_HELMET);
                        entries.add(ModItems.PROTECTION_CHESTPLATE);
                        entries.add(ModItems.PROTECTION_LEGGINGS);
                        entries.add(ModItems.PROTECTION_BOOTS);

                        entries.add(ModItems.GADGET_HAT);

                        entries.add(ModItems.DREAM_MASK);
                        entries.add(ModItems.BUNNY_MASK);
                        entries.add(ModItems.DEALER_MASK);

                        entries.add(ModItems.NEANDERTHAL_CHESTPLATE);

                        entries.add(ModItems.FUNERAL_MASK);

                        entries.add(ModItems.CROWN);
                        entries.add(ModItems.MINI_CROWN);

                        entries.add(ModItems.CIVIC_CROWN);
                        entries.add(ModItems.ROMAN_TOGA);

                        entries.add(ModItems.HALO);
                    })
                    .build());

    public static void registerItemGroups() {
        BsRolePlay.LOGGER.info("Registering Item Groups for " + BsRolePlay.MOD_ID);
    }
}
