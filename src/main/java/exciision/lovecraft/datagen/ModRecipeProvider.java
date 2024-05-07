package exciision.lovecraft.datagen;

import exciision.lovecraft.block.ModBlocks;
import exciision.lovecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private  static final List<ItemConvertible> FTHARIN_SMELTABLES = List.of(ModItems.RAW_FTHARIN,
            ModBlocks.FTHARIN_ORE, ModBlocks.DEEPSLATE_FTHARIN_ORE, ModBlocks.NETHER_FTHARIN_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, FTHARIN_SMELTABLES, RecipeCategory.MISC, ModItems.FTHARIN_INGOT,
                0.7f, 200, "ftharin_ingot");
        offerBlasting(exporter, FTHARIN_SMELTABLES, RecipeCategory.MISC, ModItems.FTHARIN_INGOT,
                0.7f, 100, "ftharin_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FTHARIN_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.FTHARIN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_FTHARIN,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_FTHARIN_BLOCK);


        //ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FTHARIN,1)
        //        .pattern("###")
        //        .pattern("#F#")
        //        .pattern("###")
        //        .input("#", Items.STONE)
        //        .input("F", ModItems.RAW_FTHARIN)
        //        .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STONE))
        //        .criterion(hasItem(ModItems.RAW_FTHARIN),conditionsFromItem(ModItems.RAW_FTHARIN))
        //        .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_FTHARIN)));
    }
}
