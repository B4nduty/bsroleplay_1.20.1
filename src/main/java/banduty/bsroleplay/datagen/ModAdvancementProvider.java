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

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
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
                        true,
                        false
                )
                .criterion("got_roleplay_core", InventoryChangedCriterion.Conditions.items(ModItems.ROLEPLAY_CORE))
                .build(consumer, BsRolePlay.MOD_ID + "/got_roleplay_core");

        Advancement supremePlayerAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.FUNERAL_MASK,
                        Text.translatable("advancement.funeral_mask.title"),
                        Text.translatable("advancement.funeral_mask.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_funeral_mask", InventoryChangedCriterion.Conditions.items(ModItems.FUNERAL_MASK))
                .criterion("got_dune_caller", InventoryChangedCriterion.Conditions.items(ModItems.DUNE_CALLER))
                .build(consumer, BsRolePlay.MOD_ID + "/be_supreme_player");

        Advancement hookAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.POSEIDON_TALON,
                        Text.translatable("advancement.poseidonTalon.title"),
                        Text.translatable("advancement.poseidonTalon.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_poseidon_talon", InventoryChangedCriterion.Conditions.items(ModItems.POSEIDON_TALON))
                .build(consumer, BsRolePlay.MOD_ID + "/got_poseidon_talon");

        Advancement fusionCoreAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.FUSION_CORE,
                        Text.translatable("advancement.fusion_core.title"),
                        Text.translatable("advancement.fusion_core.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_fusion_core", InventoryChangedCriterion.Conditions.items(ModItems.FUSION_CORE))
                .build(consumer, BsRolePlay.MOD_ID + "/got_fusion_core");

        Advancement policeSetAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.POLICE_BATON,
                        Text.translatable("advancement.police_set.title"),
                        Text.translatable("advancement.police_set.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_police_baton", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_BATON))
                .criterion("got_police_helmet", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_HELMET))
                .criterion("got_police_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_CHESTPLATE))
                .criterion("got_police_leggings", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_LEGGINGS))
                .criterion("got_police_boots", InventoryChangedCriterion.Conditions.items(ModItems.POLICE_BOOTS))
                .criterion("got_handcuffs", InventoryChangedCriterion.Conditions.items(ModItems.HANDCUFFS))
                .build(consumer, BsRolePlay.MOD_ID + "/got_police_set");

        Advancement purpleLawyerSetAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.VIOLET_BRIEFCASE,
                        Text.translatable("advancement.purple_lawyer_set.title"),
                        Text.translatable("advancement.purple_lawyer_set.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_purple_briefcase", InventoryChangedCriterion.Conditions.items(ModItems.VIOLET_BRIEFCASE))
                .criterion("got_purple_fedora", InventoryChangedCriterion.Conditions.items(ModItems.FEDORA_PURPLE))
                .criterion("got_purple_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.LAWYER_PURPLERED_CHESTPLATE))
                .criterion("got_purple_leggings", InventoryChangedCriterion.Conditions.items(ModItems.LAWYER_LEGGINGS_PURPLE))
                .criterion("got_purple_boots", InventoryChangedCriterion.Conditions.items(ModItems.LAWYER_BOOTS_PURPLE))
                .build(consumer, BsRolePlay.MOD_ID + "/got_purple_lawyer_set");

        Advancement enderHandcuffsAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.ENDERCUFFS,
                        Text.translatable("advancement.endercuffs.title"),
                        Text.translatable("advancement.endercuffs.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("got_ender_handcuffs", InventoryChangedCriterion.Conditions.items(ModItems.ENDERCUFFS))
                .build(consumer, BsRolePlay.MOD_ID + "/got_ender_handcuffs");

        Advancement coinAdvancement = Advancement.Builder.create().parent(roleplayCoreAdvancement)
                .display(
                        ModItems.NETHERITE_COIN_STACK,
                        Text.translatable("advancement.netherite_coin_stack.title"),
                        Text.translatable("advancement.netherite_coin_stack.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("got_netherite_coin_stack", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_COIN_STACK))
                .criterion("got_fedora", InventoryChangedCriterion.Conditions.items(ModItems.FEDORA))
                .build(consumer, BsRolePlay.MOD_ID + "/got_netherite_coin_stack");
    }
}