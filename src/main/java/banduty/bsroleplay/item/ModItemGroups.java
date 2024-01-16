package banduty.bsroleplay.item;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BSROLEPLAY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BsRolePlay.MOD_ID,"holy_seeds"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bsroleplay"))
                    .icon(() -> new ItemStack(ModItems.HOLY_SEEDS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC);

                        entries.add(ModItems.HOLY_SEEDS);

                        entries.add(ModItems.JUDGE_HAMMER);

                        entries.add(ModItems.JUDGE_CHESTPLATE);
                        entries.add(ModItems.JUDGE_LEGGINGS);
                        entries.add(ModItems.JUDGE_BOOTS);

                        entries.add(ModItems.POLICE_BATON);

                        entries.add(ModItems.POLICE_HELMET);
                        entries.add(ModItems.POLICE_CHESTPLATE);
                        entries.add(ModItems.POLICE_LEGGINGS);
                        entries.add(ModItems.POLICE_BOOTS);

                        entries.add(ModItems.HOLY_WEAPON);

                        entries.add(ModItems.HALO);

                        entries.add(ModItems.HOLY_CLOUD_SPAWN_EGG);

                        entries.add(ModBlocks.HOLY_CLOUD_GENERATOR_STATION);

                        entries.add(ModBlocks.HOLY_CLOUD_EGG_BLOCK);

                        entries.add(ModItems.RED_PIRATE_HELMET);
                        entries.add(ModItems.RED_PIRATE_CHESTPLATE);
                        entries.add(ModItems.RED_PIRATE_LEGGINGS);

                        entries.add(ModItems.BLUE_PIRATE_HELMET);
                        entries.add(ModItems.BLUE_PIRATE_CHESTPLATE);
                        entries.add(ModItems.BLUE_PIRATE_LEGGINGS);

                        entries.add(ModItems.HOOK);

                        entries.add(ModItems.CROWN);
                        entries.add(ModItems.MINI_CROWN);

                        entries.add(ModItems.DREAM_MASK);

                        entries.add(ModItems.BUNNY_MASK);

                    }).build());

    public static void registerItemGroups() {
        BsRolePlay.LOGGER.info("Registering Item Groups for " + BsRolePlay.MOD_ID);
    }
}
