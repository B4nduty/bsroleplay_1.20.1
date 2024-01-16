package banduty.bsroleplay;

import banduty.bsroleplay.datagen.ModItemTagProvider;
import banduty.bsroleplay.datagen.ModModelProvider;
import banduty.bsroleplay.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BsRolePlayDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
