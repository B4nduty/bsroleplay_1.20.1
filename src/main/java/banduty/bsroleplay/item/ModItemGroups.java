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
    public static final ItemGroup BSROLEPLAY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BsRolePlay.MOD_ID,"crown"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bsroleplay"))
                    .icon(() -> new ItemStack(ModItems.CROWN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.JUDGE_CHESTPLATE);
                        entries.add(ModItems.JUDGE_LEGGINGS);
                        entries.add(ModItems.JUDGE_BOOTS);

                        entries.add(ModItems.POLICE_HELMET);
                        entries.add(ModItems.POLICE_CHESTPLATE);
                        entries.add(ModItems.POLICE_LEGGINGS);
                        entries.add(ModItems.POLICE_BOOTS);

                        entries.add(ModItems.RED_PIRATE_HELMET);
                        entries.add(ModItems.RED_PIRATE_CHESTPLATE);
                        entries.add(ModItems.RED_PIRATE_LEGGINGS);

                        entries.add(ModItems.BLUE_PIRATE_HELMET);
                        entries.add(ModItems.BLUE_PIRATE_CHESTPLATE);
                        entries.add(ModItems.BLUE_PIRATE_LEGGINGS);

                        entries.add(ModItems.DREAM_MASK);
                        entries.add(ModItems.BUNNY_MASK);

                        entries.add(ModItems.NEANDERTHAL_CHESTPLATE);

                        entries.add(ModItems.FUNERAL_MASK);

                        entries.add(ModItems.CROWN);
                        entries.add(ModItems.MINI_CROWN);

                        entries.add(ModItems.CIVIC_CROWN);

                        entries.add(ModItems.COWBOY_HAT);
                        entries.add(ModItems.PONCHO);

                        entries.add(ModItems.HALO);

                        entries.add(ModItems.JUDGE_HAMMER);
                        entries.add(ModItems.POLICE_BATON);
                        entries.add(ModItems.HOOK);
                        entries.add(ModItems.PHARAOH_STAFF);

                        entries.add(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC);

                        entries.add(ModItems.HAPPY_PILL);

                    }).build());

    public static void registerItemGroups() {
        BsRolePlay.LOGGER.info("Registering Item Groups for " + BsRolePlay.MOD_ID);
    }
}
