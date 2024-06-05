
package banduty.bsroleplay;

import banduty.bsroleplay.block.ModBlocks;
import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.config.ModConfigs;
import banduty.bsroleplay.event.PlayerTickHandler;
import banduty.bsroleplay.item.ModItemGroups;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.networking.ModMessages;
import banduty.bsroleplay.screen.ModScreenHandlers;
import banduty.bsroleplay.sound.ModSounds;
import banduty.bsroleplay.util.loot_table.BlocksLootTableModifier;
import banduty.bsroleplay.util.loot_table.ChestLootTableModifier;
import banduty.bsroleplay.util.loot_table.MobsLootTableModifier;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class BsRolePlay implements ModInitializer {
	public static final String MOD_ID = "bsroleplay";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ModConfigs CONFIG;

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfigs.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
		CONFIG = AutoConfig.getConfigHolder(ModConfigs.class).getConfig();

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();

		ModSounds.registerSounds();

		ModScreenHandlers.registerScreenHandlers();

		GeckoLib.initialize();

		ModMessages.registerC2SPackets();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();

		ChestLootTableModifier.modifyChestLootTables();
		MobsLootTableModifier.modifyMobsLootTables();
		BlocksLootTableModifier.modifyBlocksLootTables();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}
