package banduty.bsroleplay.block;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.custom.HolyCloudEggBlock;
import banduty.bsroleplay.block.custom.HolyCloudGeneratorBlock;
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

public class ModBlocks {

    public static final Block HOLY_CLOUD_EGG_BLOCK = registerBlock("holy_cloud_egg_block",
            new HolyCloudEggBlock(FabricBlockSettings.copyOf(Blocks.SNIFFER_EGG).sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block HOLY_CLOUD_GENERATOR_STATION = registerBlock("holy_cloud_generator_station",
            new HolyCloudGeneratorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BsRolePlay.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BsRolePlay.LOGGER.info("Registering ModBlocks for " + BsRolePlay.MOD_ID);
    }
}
