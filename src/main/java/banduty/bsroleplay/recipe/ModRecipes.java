package banduty.bsroleplay.recipe;

import banduty.bsroleplay.BsRolePlay;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(BsRolePlay.MOD_ID, HolyCloudGeneratorRecipe.Serializer.ID),
                HolyCloudGeneratorRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(BsRolePlay.MOD_ID, HolyCloudGeneratorRecipe.Type.ID),
                HolyCloudGeneratorRecipe.Type.INSTANCE);
    }
}
