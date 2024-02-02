package banduty.bsroleplay.datagen;

import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.JUDGE_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.JUDGE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.JUDGE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.JUDGE_BOOTS));

        itemModelGenerator.register(ModItems.POLICE_BATON, Models.HANDHELD);

        itemModelGenerator.register(ModItems.POLICE_HELMET, Models.GENERATED);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POLICE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POLICE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POLICE_BOOTS));

        itemModelGenerator.register(ModItems.PHARAOH_STAFF, Models.HANDHELD);

        itemModelGenerator.register(ModItems.HALO, Models.GENERATED);

        itemModelGenerator.register(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_PIRATE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_PIRATE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_PIRATE_LEGGINGS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLUE_PIRATE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_PIRATE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_PIRATE_LEGGINGS, Models.GENERATED);

        itemModelGenerator.register(ModItems.HOOK, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CROWN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINI_CROWN, Models.GENERATED);

        itemModelGenerator.register(ModItems.DREAM_MASK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUNNY_MASK, Models.GENERATED);

        itemModelGenerator.register(ModItems.NEANDERTHAL_CHESTPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FUNERAL_MASK, Models.GENERATED);

        itemModelGenerator.register(ModItems.CIVIC_CROWN, Models.GENERATED);

        itemModelGenerator.register(ModItems.COWBOY_HAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PONCHO, Models.GENERATED);

        itemModelGenerator.register(ModItems.HAPPY_PILL, Models.GENERATED);
    }
}
