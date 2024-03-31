package banduty.bsroleplay.datagen;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class AdvancementsProvider extends FabricAdvancementProvider {
    public AdvancementsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement roleplayCoreAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.ROLEPLAY_CORE,
                        Text.translatable("advancement.roleplay_core.title"),
                        Text.translatable("advancement.roleplay_core.desc"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("got_roleplay_core", InventoryChangedCriterion.Conditions.items(ModItems.ROLEPLAY_CORE))
                .build(consumer, BsRolePlay.MOD_ID + "/got_roleplay_core");

        Advancement pharaohStaffAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.PHARAOH_STAFF,
                        Text.translatable("advancement.pharaoh_staff.title"),
                        Text.translatable("advancement.pharaoh_staff.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("got_pharaoh_staff", InventoryChangedCriterion.Conditions.items(ModItems.PHARAOH_STAFF))
                .build(consumer, BsRolePlay.MOD_ID + "/got_pharaoh_staff");

        Advancement funeralMaskAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.FUNERAL_MASK,
                        Text.translatable("advancement.funeral_mask.title"),
                        Text.translatable("advancement.funeral_mask.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("got_funeral_mask", InventoryChangedCriterion.Conditions.items(ModItems.FUNERAL_MASK))
                .build(consumer, BsRolePlay.MOD_ID + "/got_funeral_mask");

        Advancement hookAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.HOOK,
                        Text.translatable("advancement.hook.title"),
                        Text.translatable("advancement.hook.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("got_hook", InventoryChangedCriterion.Conditions.items(ModItems.HOOK))
                .build(consumer, BsRolePlay.MOD_ID + "/got_hook");

        Advancement musicDiscAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC,
                        Text.translatable("advancement.music_disc.title"),
                        Text.translatable("advancement.music_disc.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        false,
                        false
                )
                .criterion("got_music_disc", InventoryChangedCriterion.Conditions.items(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC))
                .build(consumer, BsRolePlay.MOD_ID + "/got_music_disc");

        Advancement pillCoreAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.PILL_CORE,
                        Text.translatable("advancement.pill_core.title"),
                        Text.translatable("advancement.pill_core.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("got_pill_core", InventoryChangedCriterion.Conditions.items(ModItems.PILL_CORE))
                .build(consumer, BsRolePlay.MOD_ID + "/got_pill_core");

        Advancement policeSetAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.POLICE_BATON,
                        Text.translatable("advancement.police_set.title"),
                        Text.translatable("advancement.police_set.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("got_police_baton", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_BATON))
                .criterion("got_police_helmet", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_HELMET))
                .criterion("got_police_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_CHESTPLATE))
                .criterion("got_police_leggings", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_LEGGINGS))
                .criterion("got_police_boots", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_BOOTS))
                .criterion("got_handcuffs", InventoryChangedCriterion.Conditions.items(ModItems.HANDCUFFS))
                .build(consumer, BsRolePlay.MOD_ID + "/got_police_set");

        Advancement bsroleplayStatueAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.HOLY_CLOUD_STATUE_ITEM,
                        Text.translatable("advancement.bsroleplay_statue.title"),
                        Text.translatable("advancement.bsroleplay_statue.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("got_bsroleplay_statue", InventoryChangedCriterion.Conditions.items(ModItems.HOLY_CLOUD_STATUE_ITEM))
                .build(consumer, BsRolePlay.MOD_ID + "/got_bsroleplay_statue");

        Advancement purpleLawyerSetAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.VIOLET_BRIEFCASE,
                        Text.translatable("advancement.purple_lawyer_set.title"),
                        Text.translatable("advancement.purple_lawyer_set.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("got_purple_briefcase", InventoryChangedCriterion.Conditions.items(ModItems.VIOLET_BRIEFCASE))
                .criterion("got_purple_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.LAWYER_PURPLERED_CHESTPLATE))
                .criterion("got_purple_leggings", InventoryChangedCriterion.Conditions.items(ModItems.LAWYER_LEGGINGS_PURPLE))
                .criterion("got_purple_boots", InventoryChangedCriterion.Conditions.items(ModItems.LAWYER_BOOTS_PURPLE))
                .build(consumer, BsRolePlay.MOD_ID + "/got_purple_lawyer_set");

        Advancement tinyBandutyAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.TINY_BANDUTY_ITEM,
                        Text.translatable("advancement.tiny_banduty.title"),
                        Text.translatable("advancement.tiny_banduty.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("got_tiny_banduty", InventoryChangedCriterion.Conditions.items(ModItems.TINY_BANDUTY_ITEM))
                .build(consumer, BsRolePlay.MOD_ID + "/got_tiny_banduty");

        Advancement godsHandcuffsAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.GODS_HANDCUFFS,
                        Text.translatable("advancement.gods_handcuffs.title"),
                        Text.translatable("advancement.gods_handcuffs.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("got_gods_handcuffs", InventoryChangedCriterion.Conditions.items(ModItems.GODS_HANDCUFFS))
                .build(consumer, BsRolePlay.MOD_ID + "/got_gods_handcuffs");
    }
}
