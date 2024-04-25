package banduty.bsroleplay.datagen;

import banduty.bsroleplay.block.ModBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlock.BRONZE_COIN)
                .add(ModBlock.BRONZE_COIN_STACK)
                .add(ModBlock.GOLD_COIN)
                .add(ModBlock.GOLD_COIN_STACK)
                .add(ModBlock.NETHERITE_COIN)
                .add(ModBlock.NETHERITE_COIN_STACK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlock.BRONZE_COIN)
                .add(ModBlock.BRONZE_COIN_STACK)
                .add(ModBlock.GOLD_COIN)
                .add(ModBlock.GOLD_COIN_STACK)
                .add(ModBlock.NETHERITE_COIN)
                .add(ModBlock.NETHERITE_COIN_STACK);
    }
}
