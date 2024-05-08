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


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FTHARIN_PICKAXE, 1)
                .pattern("FFF")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('F', ModItems.FTHARIN_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.FTHARIN_INGOT), conditionsFromItem(ModItems.FTHARIN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FTHARIN_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FTHARIN_AXE, 1)
                .pattern("FF")
                .pattern("FS")
                .pattern(" S")
                .input('S', Items.STICK)
                .input('F', ModItems.FTHARIN_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.FTHARIN_INGOT), conditionsFromItem(ModItems.FTHARIN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FTHARIN_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FTHARIN_SHOVEL, 1)
                .pattern("F")
                .pattern("S")
                .pattern("S")
                .input('S', Items.STICK)
                .input('F', ModItems.FTHARIN_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.FTHARIN_INGOT), conditionsFromItem(ModItems.FTHARIN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FTHARIN_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FTHARIN_SWORD, 1)
                .pattern("F")
                .pattern("F")
                .pattern("S")
                .input('S', Items.STICK)
                .input('F', ModItems.FTHARIN_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.FTHARIN_INGOT), conditionsFromItem(ModItems.FTHARIN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FTHARIN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FTHARIN_HOE, 1)
                .pattern("FF")
                .pattern(" S")
                .pattern(" S")
                .input('S', Items.STICK)
                .input('F', ModItems.FTHARIN_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.FTHARIN_INGOT), conditionsFromItem(ModItems.FTHARIN_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FTHARIN_HOE)));

    }
}
