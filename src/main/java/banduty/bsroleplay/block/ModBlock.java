package banduty.bsroleplay.block;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.custom.TinyBanduty;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlock {
    public static final Block TINY_BANDUTY = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "tiny_banduty"),
            new TinyBanduty(FabricBlockSettings.copyOf(Blocks.BLACK_WOOL).sounds(BlockSoundGroup.WOOL).strength(1.0f).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(BsRolePlay.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void registerModBlocks() {
        BsRolePlay.LOGGER.info("Registering ModBlocks for " + BsRolePlay.MOD_ID);
    }
}
