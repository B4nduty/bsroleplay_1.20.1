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
                .pattern(" TO")
                .pattern(" ST")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('O', Items.GOLD_INGOT)
                .input('T', Items.DARK_OAK_PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JUDGE_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JUDGE_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("BJB")
                .pattern("BBB")
                .input('B', Items.BLACK_WOOL)
                .input('J', ModItems.JUDGE_HAMMER)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.JUDGE_HAMMER), conditionsFromItem(ModItems.JUDGE_HAMMER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JUDGE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JUDGE_LEGGINGS, 1)
                .pattern("BBB")
                .pattern("B B")
                .pattern("J J")
                .input('B', Items.BLACK_WOOL)
                .input('J', ModItems.JUDGE_HAMMER)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.JUDGE_HAMMER), conditionsFromItem(ModItems.JUDGE_HAMMER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JUDGE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JUDGE_BOOTS, 1)
                .pattern("   ")
                .pattern("J J")
                .pattern("B B")
                .input('B', Items.BLACK_WOOL)
                .input('J', ModItems.JUDGE_HAMMER)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.JUDGE_HAMMER), conditionsFromItem(ModItems.JUDGE_HAMMER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.JUDGE_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_BATON, 1)
                .pattern("  B")
                .pattern(" B ")
                .pattern("I  ")
                .input('B', Items.BLACK_WOOL)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_BATON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_HELMET, 1)
                .pattern("BBB")
                .pattern("BPB")
                .pattern("   ")
                .input('B', Items.BLACK_WOOL)
                .input('P', ModItems.POLICE_BATON)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.POLICE_BATON), conditionsFromItem(ModItems.POLICE_BATON))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_CHESTPLATE, 1)
                .pattern("B B")
                .pattern("BPB")
                .pattern("BBB")
                .input('B', Items.BLACK_WOOL)
                .input('P', ModItems.POLICE_BATON)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.POLICE_BATON), conditionsFromItem(ModItems.POLICE_BATON))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_LEGGINGS, 1)
                .pattern("BBB")
                .pattern("B B")
                .pattern("P P")
                .input('B', Items.BLACK_WOOL)
                .input('P', ModItems.POLICE_BATON)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.POLICE_BATON), conditionsFromItem(ModItems.POLICE_BATON))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POLICE_BOOTS, 1)
                .pattern("   ")
                .pattern("P P")
                .pattern("B B")
                .input('B', Items.BLACK_WOOL)
                .input('P', ModItems.POLICE_BATON)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.POLICE_BATON), conditionsFromItem(ModItems.POLICE_BATON))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POLICE_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HALO, 1)
                .pattern("III")
                .pattern("I I")
                .pattern("III")
                .input('I', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HALO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RED_PIRATE_HELMET, 1)
                .pattern(" I ")
                .pattern("IBI")
                .pattern("RRR")
                .input('I', Items.GOLD_INGOT)
                .input('B', Items.BLACK_WOOL)
                .input('R', Items.RED_WOOL)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RED_PIRATE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RED_PIRATE_CHESTPLATE, 1)
                .pattern("RWR")
                .pattern("RIR")
                .pattern("IWI")
                .input('I', Items.GOLD_INGOT)
                .input('R', Items.RED_WOOL)
                .input('W', Items.WHITE_WOOL)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RED_PIRATE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HOOK, 1)
                .pattern(" GG")
                .pattern(" G ")
                .pattern("III")
                .input('I', Items.IRON_INGOT)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HOOK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RED_PIRATE_LEGGINGS, 1)
                .pattern("RRR")
                .pattern("R R")
                .pattern("G G")
                .input('R', Items.RED_WOOL)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RED_PIRATE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_PIRATE_HELMET, 1)
                .pattern(" I ")
                .pattern("IBI")
                .pattern("RRR")
                .input('I', Items.GOLD_INGOT)
                .input('B', Items.BLACK_WOOL)
                .input('R', Items.BLUE_WOOL)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_PIRATE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_PIRATE_CHESTPLATE, 1)
                .pattern("BWB")
                .pattern("BIB")
                .pattern("IWI")
                .input('I', Items.GOLD_INGOT)
                .input('B', Items.BLUE_WOOL)
                .input('W', Items.WHITE_WOOL)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_PIRATE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_PIRATE_LEGGINGS, 1)
                .pattern("BBB")
                .pattern("B B")
                .pattern("G G")
                .input('B', Items.BLUE_WOOL)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_PIRATE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MINI_CROWN, 1)
                .pattern("   ")
                .pattern("GRG")
                .pattern("GGG")
                .input('R', Items.REDSTONE)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MINI_CROWN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DREAM_MASK, 1)
                .pattern("BWB")
                .pattern("WWW")
                .pattern("BBB")
                .input('W', Items.WHITE_WOOL)
                .input('B', Items.BLACK_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DREAM_MASK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NEANDERTHAL_CHESTPLATE, 1)
                .pattern("P L")
                .pattern(" PL")
                .pattern("LLL")
                .input('P', Items.LAPIS_LAZULI)
                .input('L', Items.LEATHER)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.NEANDERTHAL_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FUNERAL_MASK, 1)
                .pattern("PGP")
                .pattern("GPG")
                .pattern("P P")
                .input('P', Items.LAPIS_LAZULI)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FUNERAL_MASK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CIVIC_CROWN, 1)
                .pattern("OOO")
                .pattern("O O")
                .pattern("OOO")
                .input('O', Items.OAK_LEAVES)
                .criterion(hasItem(Items.OAK_LEAVES), conditionsFromItem(Items.OAK_LEAVES))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CIVIC_CROWN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUNNY_MASK, 1)
                .pattern("O O")
                .pattern("RDR")
                .pattern(" O ")
                .input('O', Items.PINK_WOOL)
                .input('R', Items.RED_WOOL)
                .input('D', ModItems.DREAM_MASK)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.DREAM_MASK), conditionsFromItem(ModItems.DREAM_MASK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BUNNY_MASK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOLOR_EN_EL_PECHO_CAROLA_MUSIC_DISC, 1)
                .pattern(" H ")
                .pattern(" D ")
                .pattern(" B ")
                .input('H', ModItems.HALO)
                .input('D', ModItems.DREAM_MASK)
                .input('B', Items.BLACK_WOOL)
                .criterion(hasItem(ModItems.HALO), conditionsFromItem(ModItems.HALO))
                .criterion(hasItem(ModItems.DREAM_MASK), conditionsFromItem(ModItems.DREAM_MASK))
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PHARAOH_STAFF, 1)
                .pattern(" GN")
                .pattern(" LG")
                .pattern("G  ")
                .input('G', Items.GOLD_BLOCK)
                .input('N', Items.NETHER_STAR)
                .input('L', Items.LAPIS_BLOCK)
                .criterion(hasItem(Items.GOLD_BLOCK), conditionsFromItem(Items.GOLD_BLOCK))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(Items.LAPIS_BLOCK), conditionsFromItem(Items.LAPIS_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHARAOH_STAFF)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COWBOY_HAT, 1)
                .pattern("L L")
                .pattern("LGL")
                .pattern("LLL")
                .input('G', Items.GOLD_INGOT)
                .input('L', Items.LEATHER)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COWBOY_HAT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PONCHO, 1)
                .pattern("RRR")
                .pattern("RLL")
                .pattern("L  ")
                .input('R', Items.RED_WOOL)
                .input('L', Items.LEATHER)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PONCHO)));
    }
}
