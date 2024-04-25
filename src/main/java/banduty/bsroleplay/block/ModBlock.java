package banduty.bsroleplay.block;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.block.custom.TinyBanduty;
import banduty.bsroleplay.block.custom.coins.BronzeCoin;
import banduty.bsroleplay.block.custom.coins.GoldCoin;
import banduty.bsroleplay.block.custom.coins.NetheriteCoin;
import banduty.bsroleplay.block.custom.coins.stacks.BronzeCoinStack;
import banduty.bsroleplay.block.custom.coins.stacks.GoldCoinStack;
import banduty.bsroleplay.block.custom.coins.stacks.NetheriteCoinStack;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlock {

    public static final Block TINY_BANDUTY = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "tiny_banduty"),
            new TinyBanduty(FabricBlockSettings.copyOf(Blocks.BLACK_WOOL).sounds(BlockSoundGroup.WOOL).strength(1.0f).nonOpaque()));

    public static final Block BRONZE_COIN = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "bronze_coin"),
            new BronzeCoin(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(3.0F, 6.0F).nonOpaque()));

    public static final Block GOLD_COIN = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "gold_coin"),
            new GoldCoin(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(3.0F, 6.0F).nonOpaque()));

    public static final Block NETHERITE_COIN = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "netherite_coin"),
            new NetheriteCoin(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(50.0F, 1200.0F).nonOpaque()));

    public static final Block BRONZE_COIN_STACK = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "bronze_coin_stack"),
            new BronzeCoinStack(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(5.0F, 6.0F).nonOpaque()));

    public static final Block GOLD_COIN_STACK = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "gold_coin_stack"),
            new GoldCoinStack(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(5.0F, 6.0F).nonOpaque()));

    public static final Block NETHERITE_COIN_STACK = Registry.register(Registries.BLOCK, new Identifier(BsRolePlay.MOD_ID, "netherite_coin_stack"),
            new NetheriteCoinStack(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(80.0F, 8.0F).nonOpaque()));

    public static void registerModBlocks() {
        BsRolePlay.LOGGER.info("Registering ModBlocks for " + BsRolePlay.MOD_ID);
    }
}
