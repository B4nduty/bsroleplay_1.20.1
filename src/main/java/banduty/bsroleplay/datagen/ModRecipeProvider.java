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
                .input('B', Items.BLUE_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
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
                .pattern("WOW")
                .input('O', Items.PINK_WOOL)
                .input('R', Items.RED_WOOL)
                .input('W', Items.WHITE_WOOL)
                .input('D', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BUNNY_MASK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC, 1)
                .pattern(" D ")
                .pattern(" R ")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('D', ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC)
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .criterion(hasItem(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC), conditionsFromItem(ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC))
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
                .pattern("BBB")
                .pattern("BGB")
                .pattern("YRY")
                .input('B', Items.BLACK_WOOL)
                .input('Y', Items.YELLOW_WOOL)
                .input('G', Items.GLASS)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("YRI")
                .pattern("BBB")
                .input('Y', Items.YELLOW_WOOL)
                .input('B', Items.BLACK_WOOL)
                .input('I', Items.IRON_INGOT)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_LEGGINGS, 1)
                .pattern("BRB")
                .pattern("Y Y")
                .pattern("I I")
                .input('Y', Items.YELLOW_WOOL)
                .input('I', Items.IRON_INGOT)
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_BOOTS, 1)
                .pattern("B B")
                .pattern("GRG")
                .input('B', Items.BLACK_WOOL)
                .input('G', Items.RED_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
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
                .input('P', ModItems.FUSION_CORE)
                .criterion(hasItem(Items.WITHER_ROSE), conditionsFromItem(Items.WITHER_ROSE))
                .criterion(hasItem(ModItems.FUSION_CORE), conditionsFromItem(ModItems.FUSION_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HAPPY_PILL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SAD_PILL, 1)
                .pattern("   ")
                .pattern(" N ")
                .pattern(" P ")
                .input('N', Items.NETHER_STAR)
                .input('P', ModItems.FUSION_CORE)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(ModItems.FUSION_CORE), conditionsFromItem(ModItems.FUSION_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SAD_PILL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_LEGGINGS_BLACK, 1)
                .pattern("BRB")
                .pattern("B B")
                .pattern("B B")
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_leggings_black_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BOOTS_BLACK, 1)
                .pattern("   ")
                .pattern("B B")
                .pattern("BRB")
                .input('B', Items.BLACK_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_boots_black_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_LEGGINGS_PURPLE, 1)
                .pattern(" BP")
                .input('P', Items.PURPLE_DYE)
                .input('B', ModItems.LAWYER_LEGGINGS_BLACK)
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(ModItems.LAWYER_LEGGINGS_BLACK), conditionsFromItem(ModItems.LAWYER_LEGGINGS_BLACK))
                .offerTo(exporter, new Identifier("lawyer_leggings_purple_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BOOTS_PURPLE, 1)
                .pattern(" BP")
                .input('P', Items.PURPLE_DYE)
                .input('B', ModItems.LAWYER_BOOTS_BLACK)
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(ModItems.LAWYER_BOOTS_BLACK), conditionsFromItem(ModItems.LAWYER_BOOTS_BLACK))
                .offerTo(exporter, new Identifier("lawyer_boots_purple_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_LEGGINGS_PURPLE, 1)
                .pattern("BRB")
                .pattern("B B")
                .pattern("B B")
                .input('B', Items.PURPLE_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_leggings_purple_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BOOTS_PURPLE, 1)
                .pattern("   ")
                .pattern("B B")
                .pattern("BRB")
                .input('B', Items.PURPLE_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_boots_purple_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_LEGGINGS_BLACK, 1)
                .pattern(" BP")
                .input('P', Items.BLACK_DYE)
                .input('B', ModItems.LAWYER_LEGGINGS_PURPLE)
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .criterion(hasItem(ModItems.LAWYER_LEGGINGS_PURPLE), conditionsFromItem(ModItems.LAWYER_LEGGINGS_PURPLE))
                .offerTo(exporter, new Identifier("lawyer_leggings_black_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BOOTS_BLACK, 1)
                .pattern(" BP")
                .input('P', Items.BLACK_DYE)
                .input('B', ModItems.LAWYER_BOOTS_PURPLE)
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .criterion(hasItem(ModItems.LAWYER_BOOTS_PURPLE), conditionsFromItem(ModItems.LAWYER_BOOTS_PURPLE))
                .offerTo(exporter, new Identifier("lawyer_boots_black_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKBLUE_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("BLB")
                .pattern("BRB")
                .input('B', Items.BLACK_WOOL)
                .input('L', Items.BLUE_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_blackblue_chestplate_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKBLUE_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.BLUE_DYE)
                .input('B', ModItems.LAWYER_BLACKGOLD_CHESTPLATE)
                .criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE))
                .criterion(hasItem(ModItems.LAWYER_BLACKGOLD_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKGOLD_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackblue_chestplate_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKBLUE_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.BLUE_DYE)
                .input('B', ModItems.LAWYER_BLACKRED_CHESTPLATE)
                .criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE))
                .criterion(hasItem(ModItems.LAWYER_BLACKRED_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKRED_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackblue_chestplate_3"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKBLUE_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.BLUE_DYE)
                .input('B', ModItems.LAWYER_PURPLERED_CHESTPLATE)
                .criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE))
                .criterion(hasItem(ModItems.LAWYER_PURPLERED_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_PURPLERED_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackblue_chestplate_4"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKGOLD_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("BLB")
                .pattern("BRB")
                .input('B', Items.BLACK_WOOL)
                .input('L', Items.GOLD_INGOT)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_blackgold_chestplate_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKGOLD_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.GOLD_INGOT)
                .input('B', ModItems.LAWYER_BLACKBLUE_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.LAWYER_BLACKBLUE_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKBLUE_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackgold_chestplate_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKGOLD_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.GOLD_INGOT)
                .input('B', ModItems.LAWYER_PURPLERED_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.LAWYER_PURPLERED_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_PURPLERED_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackgold_chestplate_3"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKGOLD_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.GOLD_INGOT)
                .input('B', ModItems.LAWYER_BLACKRED_CHESTPLATE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.LAWYER_BLACKRED_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKRED_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackgold_chestplate_4"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKRED_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("BLB")
                .pattern("BRB")
                .input('B', Items.BLACK_WOOL)
                .input('L', Items.RED_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_blackred_chestplate_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKRED_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.RED_DYE)
                .input('B', ModItems.LAWYER_BLACKBLUE_CHESTPLATE)
                .criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE))
                .criterion(hasItem(ModItems.LAWYER_BLACKBLUE_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKBLUE_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackred_chestplate_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKRED_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.RED_DYE)
                .input('B', ModItems.LAWYER_PURPLERED_CHESTPLATE)
                .criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE))
                .criterion(hasItem(ModItems.LAWYER_PURPLERED_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_PURPLERED_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackred_chestplate_3"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_BLACKRED_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.RED_DYE)
                .input('B', ModItems.LAWYER_BLACKGOLD_CHESTPLATE)
                .criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE))
                .criterion(hasItem(ModItems.LAWYER_BLACKGOLD_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKGOLD_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_blackred_chestplate_4"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_PURPLERED_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("BLB")
                .pattern("BRB")
                .input('B', Items.PURPLE_WOOL)
                .input('L', Items.RED_WOOL)
                .input('R', ModItems.ROLEPLAY_CORE)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier("lawyer_purplered_chestplate_1"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_PURPLERED_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.PURPLE_DYE)
                .input('B', ModItems.LAWYER_BLACKBLUE_CHESTPLATE)
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(ModItems.LAWYER_BLACKBLUE_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKBLUE_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_purplered_chestplate_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_PURPLERED_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.PURPLE_DYE)
                .input('B', ModItems.LAWYER_BLACKRED_CHESTPLATE)
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(ModItems.LAWYER_BLACKRED_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKRED_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_purplered_chestplate_3"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAWYER_PURPLERED_CHESTPLATE, 1)
                .pattern(" BP")
                .input('P', Items.PURPLE_DYE)
                .input('B', ModItems.LAWYER_BLACKGOLD_CHESTPLATE)
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(ModItems.LAWYER_BLACKGOLD_CHESTPLATE), conditionsFromItem(ModItems.LAWYER_BLACKGOLD_CHESTPLATE))
                .offerTo(exporter, new Identifier("lawyer_purplered_chestplate_4"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRIEFCASE, 1)
                .pattern("GGG")
                .pattern("LRL")
                .pattern("LLL")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('L', Items.LEATHER)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BRIEFCASE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLACK_BRIEFCASE, 1)
                .pattern(" BD")
                .input('B', ModItems.BRIEFCASE)
                .input('D', Items.BLACK_DYE)
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .criterion(hasItem(ModItems.BRIEFCASE), conditionsFromItem(ModItems.BRIEFCASE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLACK_BRIEFCASE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIOLET_BRIEFCASE, 1)
                .pattern(" BP")
                .input('B', ModItems.BRIEFCASE)
                .input('P', Items.PURPLE_DYE)
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(ModItems.BRIEFCASE), conditionsFromItem(ModItems.BRIEFCASE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VIOLET_BRIEFCASE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRIEFCASE, 1)
                .pattern(" BP")
                .input('B', ModItems.VIOLET_BRIEFCASE)
                .input('P', Items.BROWN_DYE)
                .criterion(hasItem(Items.BROWN_DYE), conditionsFromItem(Items.BROWN_DYE))
                .criterion(hasItem(ModItems.VIOLET_BRIEFCASE), conditionsFromItem(ModItems.VIOLET_BRIEFCASE))
                .offerTo(exporter, new Identifier("violet_briefcase_to_briefcase"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLACK_BRIEFCASE, 1)
                .pattern(" BP")
                .input('B', ModItems.VIOLET_BRIEFCASE)
                .input('P', Items.BLACK_DYE)
                .criterion(hasItem(Items.BROWN_DYE), conditionsFromItem(Items.BLACK_DYE))
                .criterion(hasItem(ModItems.VIOLET_BRIEFCASE), conditionsFromItem(ModItems.VIOLET_BRIEFCASE))
                .offerTo(exporter, new Identifier("violet_briefcase_to_black_briefcase"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRIEFCASE, 1)
                .pattern(" BP")
                .input('B', ModItems.BLACK_BRIEFCASE)
                .input('P', Items.BROWN_DYE)
                .criterion(hasItem(Items.BROWN_DYE), conditionsFromItem(Items.BROWN_DYE))
                .criterion(hasItem(ModItems.BLACK_BRIEFCASE), conditionsFromItem(ModItems.BLACK_BRIEFCASE))
                .offerTo(exporter, new Identifier("black_briefcase_to_briefcase"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIOLET_BRIEFCASE, 1)
                .pattern(" BP")
                .input('B', ModItems.BLACK_BRIEFCASE)
                .input('P', Items.PURPLE_DYE)
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(ModItems.BLACK_BRIEFCASE), conditionsFromItem(ModItems.BLACK_BRIEFCASE))
                .offerTo(exporter, new Identifier("black_briefcase_to_violet_briefcase"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROMAN_TOGA, 1)
                .pattern("D W")
                .pattern("DRD")
                .pattern("WWW")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('W', Items.WHITE_WOOL)
                .input('D', Items.RED_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ROMAN_TOGA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TINY_BANDUTY_ITEM, 1)
                .pattern("GGG")
                .pattern("BRB")
                .pattern("GPG")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('G', Items.GRAY_WOOL)
                .input('B', Items.BLACK_STAINED_GLASS)
                .input('P', Items.PINK_WOOL)
                .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                .criterion(hasItem(Items.BLACK_STAINED_GLASS), conditionsFromItem(Items.BLACK_STAINED_GLASS))
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TINY_BANDUTY_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HANDCUFFS, 1)
                .pattern("III")
                .pattern("IRI")
                .pattern("III")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('I', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HANDCUFFS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HANDCUFFS_KEY, 1)
                .pattern("AAR")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HANDCUFFS_KEY)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FEDORA, 1)
                .pattern("BBB")
                .pattern("WWW")
                .pattern("BRB")
                .input('R', ModItems.ROLEPLAY_CORE)
                .input('B', Items.BLACK_WOOL)
                .input('W', Items.WHITE_WOOL)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(ModItems.ROLEPLAY_CORE), conditionsFromItem(ModItems.ROLEPLAY_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FEDORA)));

        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.BRONZE_COIN, RecipeCategory.MISC,
                ModItems.BRONZE_COIN_STACK, "bronze_coin_stack_from_bronze_coin", "bronze_coin");

        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.BRONZE_COIN_STACK, RecipeCategory.MISC,
                ModItems.GOLD_COIN, "gold_coin_from_bronze_coin_stack", "bronze_coin_stack");

        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.GOLD_COIN, RecipeCategory.MISC,
                ModItems.GOLD_COIN_STACK, "gold_coin_stack_from_gold_coin", "gold_coin");

        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.GOLD_COIN_STACK, RecipeCategory.MISC,
                ModItems.NETHERITE_COIN, "netherite_coin_from_gold_coin_stack", "gold_coin_stack");

        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.NETHERITE_COIN, RecipeCategory.MISC,
                ModItems.NETHERITE_COIN_STACK, "netherite_coin_stack_from_netherite_coin", "netherite_coin");
    }
}
