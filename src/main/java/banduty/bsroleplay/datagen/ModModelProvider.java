package banduty.bsroleplay.datagen;

import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.ROLEPLAY_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HANDCUFFS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERCUFFS, Models.GENERATED);
        itemModelGenerator.register(ModItems.HANDCUFFS_KEY, Models.GENERATED);

        itemModelGenerator.register(ModItems.POLICE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLICE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLICE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLICE_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.PROTECTION_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROTECTION_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROTECTION_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROTECTION_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_PROTECTION_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_PROTECTION_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_PROTECTION_LEGGINGS, Models.GENERATED);

        itemModelGenerator.register(ModItems.HALO, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_PIRATE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_PIRATE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_PIRATE_LEGGINGS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLUE_PIRATE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_PIRATE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_PIRATE_LEGGINGS, Models.GENERATED);

        itemModelGenerator.register(ModItems.CROWN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINI_CROWN, Models.GENERATED);

        itemModelGenerator.register(ModItems.DREAM_MASK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUNNY_MASK, Models.GENERATED);

        itemModelGenerator.register(ModItems.NEANDERTHAL_CHESTPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FUNERAL_MASK, Models.GENERATED);

        itemModelGenerator.register(ModItems.CIVIC_CROWN, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROMAN_TOGA, Models.GENERATED);

        itemModelGenerator.register(ModItems.COWBOY_HAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PONCHO, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEALKIT, Models.GENERATED);

        itemModelGenerator.register(ModItems.DEALER, Models.GENERATED);

        itemModelGenerator.register(ModItems.INVKIT, Models.GENERATED);

        itemModelGenerator.register(ModItems.FUSION_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_COIN, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_COIN_STACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIN_STACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_COIN_STACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_COIN_STACK, Models.GENERATED);

        itemModelGenerator.register(ModItems.GADGET_HAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.LAWYER_BLACKBLUE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAWYER_BLACKGOLD_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAWYER_BLACKRED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAWYER_LEGGINGS_BLACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAWYER_BOOTS_BLACK, Models.GENERATED);

        itemModelGenerator.register(ModItems.LAWYER_PURPLERED_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAWYER_LEGGINGS_PURPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAWYER_BOOTS_PURPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FEDORA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FEDORA_PURPLE, Models.GENERATED);
    }
}
