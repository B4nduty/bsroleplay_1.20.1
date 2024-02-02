package banduty.bsroleplay.datagen;

import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.JUDGE_CHESTPLATE, ModItems.JUDGE_LEGGINGS, ModItems.JUDGE_BOOTS)
                .add(ModItems.POLICE_CHESTPLATE, ModItems.POLICE_LEGGINGS, ModItems.POLICE_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC);
    }

}
