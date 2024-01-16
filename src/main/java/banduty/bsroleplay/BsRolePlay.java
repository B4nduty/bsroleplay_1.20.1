package banduty.bsroleplay;

import banduty.bsroleplay.block.ModBlocks;
import banduty.bsroleplay.block.entity.ModBlockEntities;
import banduty.bsroleplay.entity.ModEntities;
import banduty.bsroleplay.entity.custom.HolyCloudEntity;
import banduty.bsroleplay.item.ModItemGroups;
import banduty.bsroleplay.item.ModItems;
import banduty.bsroleplay.recipe.ModRecipes;
import banduty.bsroleplay.screen.ModScreenHandlers;
import banduty.bsroleplay.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class BsRolePlay implements ModInitializer {
	public static final String MOD_ID = "bsroleplay";
	public static final Logger LOGGER = LoggerFactory.getLogger("bsroleplay");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();

		ModSounds.registerSounds();

		ModRecipes.registerRecipes();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.HOLY_CLOUD, HolyCloudEntity.createHolyCloudAttributes());

		ModEntities.registerModEntities();

		ModScreenHandlers.registerScreenHandlers();

		GeckoLib.initialize();
	}
}