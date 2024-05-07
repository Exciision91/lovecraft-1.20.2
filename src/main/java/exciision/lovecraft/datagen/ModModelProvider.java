package exciision.lovecraft.datagen;

import exciision.lovecraft.block.ModBlocks;
import exciision.lovecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FTHARIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_FTHARIN_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FTHARIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FTHARIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_FTHARIN_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FTHARIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FTHARIN, Models.GENERATED);

    }
}
