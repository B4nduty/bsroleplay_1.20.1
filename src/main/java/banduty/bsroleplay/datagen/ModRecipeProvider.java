package banduty.bsroleplay.datagen;

import banduty.bsroleplay.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JUDGE_HAMMER, 1)
                .pattern(" TR")
                .pattern(" ST")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('T', Items.DARK_OAK_PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JUDGE_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_BATON, 1)
                .pattern("  B")
                .pattern(" B ")
                .pattern("R  ")
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_BATON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_HELMET, 1)
                .pattern("BBB")
                .pattern(" RB")
                .pattern("BBB")
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("BRB")
                .pattern("WWW")
                .input('B', Items.BLUE_WOOL)
                .input('W', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.POLICE_BATON), conditionsFromItem(ModItems.POLICE_BATON))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_LEGGINGS, 1)
                .pattern("BRB")
                .pattern("B B")
                .pattern("B B")
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.POLICE_BATON)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_BOOTS, 1)
                .pattern("   ")
                .pattern("L L")
                .pattern("LRL")
                .input('L', Items.LEATHER)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HALO, 1)
                .pattern("III")
                .pattern("IRI")
                .pattern("III")
                .input('I', Items.GOLD_INGOT)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HALO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RED_PIRATE_HELMET, 1)
                .pattern(" I ")
                .pattern("IBI")
                .pattern("RRR")
                .input('I', Items.GOLD_INGOT)
                .input('B', ModItems.ROLEPLAY_CORE)
                .input('R', Items.RED_WOOL)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RED_PIRATE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RED_PIRATE_CHESTPLATE, 1)
                .pattern("RWR")
                .pattern("RCR")
                .pattern("IWI")
                .input('I', Items.GOLD_INGOT)
                .input('R', Items.RED_WOOL)
                .input('W', Items.WHITE_WOOL)
                .input('C', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RED_PIRATE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RED_PIRATE_LEGGINGS, 1)
                .pattern("RCR")
                .pattern("R R")
                .pattern("G G")
                .input('R', Items.RED_WOOL)
                .input('G', Items.GOLD_INGOT)
                .input('C', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RED_PIRATE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_PIRATE_HELMET, 1)
                .pattern(" I ")
                .pattern("IBI")
                .pattern("RRR")
                .input('I', Items.GOLD_INGOT)
                .input('B', ModItems.ROLEPLAY_CORE)
                .input('R', Items.BLUE_WOOL)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_PIRATE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_PIRATE_CHESTPLATE, 1)
                .pattern("RWR")
                .pattern("RCR")
                .pattern("IWI")
                .input('I', Items.GOLD_INGOT)
                .input('R', Items.BLUE_WOOL)
                .input('W', Items.WHITE_WOOL)
                .input('C', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_PIRATE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_PIRATE_LEGGINGS, 1)
                .pattern("RCR")
                .pattern("R R")
                .pattern("G G")
                .input('R', Items.BLUE_WOOL)
                .input('G', Items.GOLD_INGOT)
                .input('C', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_PIRATE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MINI_CROWN, 1)
                .pattern("   ")
                .pattern("GRG")
                .pattern("GGG")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MINI_CROWN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DREAM_MASK, 1)
                .pattern("BWB")
                .pattern("WRW")
                .pattern("BBB")
                .input('W', Items.WHITE_WOOL)
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DREAM_MASK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NEANDERTHAL_CHESTPLATE, 1)
                .pattern("P L")
                .pattern(" PL")
                .pattern("LLR")
                .input('P', Items.LAPIS_LAZULI)
                .input('L', Items.LEATHER)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.NEANDERTHAL_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CIVIC_CROWN, 1)
                .pattern("OOO")
                .pattern("ORO")
                .pattern("OOO")
                .input('O', Items.OAK_LEAVES)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.OAK_LEAVES), conditionsFromItem(Items.OAK_LEAVES))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CIVIC_CROWN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUNNY_MASK, 1)
                .pattern("O O")
                .pattern("RDR")
                .pattern(" O ")
                .input('O', Items.PINK_WOOL)
                .input('R', Items.RED_WOOL)
                .input('D', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BUNNY_MASK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC, 1)
                .pattern(" H ")
                .pattern(" R ")
                .pattern(" B ")
                .input('H', ModItems.HALO)
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('B', Items.BLACK_WOOL)
                .criterion(hasItem(ModItems.HALO), conditionsFromItem(ModItems.HALO))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CROWN, 1)
                .pattern("G G")
                .pattern("LME")
                .pattern("   ")
                .input('L', Items.LAPIS_LAZULI)
                .input('E', Items.EMERALD)
                .input('G', Items.GOLD_INGOT)
                .input('M', ModItems.MINI_CROWN)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(ModItems.MINI_CROWN), conditionsFromItem(ModItems.MINI_CROWN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CROWN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COWBOY_HAT, 1)
                .pattern("L L")
                .pattern("BGB")
                .pattern("LRL")
                .input('G', Items.GOLD_INGOT)
                .input('L', Items.LEATHER)
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COWBOY_HAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PONCHO, 1)
                .pattern("RBR")
                .pattern("RLL")
                .pattern("L  ")
                .input('R', Items.RED_WOOL)
                .input('L', Items.LEATHER)
                .input('B', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PONCHO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_HELMET, 1)
                .pattern("YYY")
                .pattern("BGB")
                .pattern("BRB")
                .input('Y', Items.YELLOW_WOOL)
                .input('B', Items.BLACK_WOOL)
                .input('G', Items.GLASS)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("YRY")
                .pattern("BBB")
                .input('Y', Items.YELLOW_WOOL)
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_LEGGINGS, 1)
                .pattern("BRB")
                .pattern("Y Y")
                .pattern("Y Y")
                .input('Y', Items.YELLOW_WOOL)
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_BOOTS, 1)
                .pattern("   ")
                .pattern("B B")
                .pattern("BRB")
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROLEPLAY_CORE, 2)
                .pattern("   ")
                .pattern("RGR")
                .pattern("III")
                .input('I', Items.IRON_INGOT)
                .input('R', Items.REDSTONE)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ROLEPLAY_CORE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DEALER, 1)
                .pattern("BBB")
                .pattern("WRW")
                .pattern("   ")
                .input('B', Items.BLACK_WOOL)
                .input('W', Items.WHITE_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DEALER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HAPPY_PILL, 1)
                .pattern("   ")
                .pattern(" W ")
                .pattern(" P ")
                .input('W', Items.WITHER_ROSE)
                .input('P', ModItems.PILL_CORE)
                .criterion(hasItem(Items.WITHER_ROSE), conditionsFromItem(Items.WITHER_ROSE))
                .criterion(hasItem(ModItems.PILL_CORE), conditionsFromItem(ModItems.PILL_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HAPPY_PILL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SAD_PILL, 1)
                .pattern("   ")
                .pattern(" N ")
                .pattern(" P ")
                .input('N', Items.NETHER_STAR)
                .input('P', ModItems.PILL_CORE)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(ModItems.PILL_CORE), conditionsFromItem(ModItems.PILL_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SAD_PILL)));
    }
}
