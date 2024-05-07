package exciision.lovecraft.datagen;

import exciision.lovecraft.block.ModBlocks;
import exciision.lovecraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.FTHARIN_BLOCK);
        addDrop(ModBlocks.RAW_FTHARIN_BLOCK);

        addDrop(ModBlocks.FTHARIN_ORE, copperlikeOreDrops(ModBlocks.FTHARIN_ORE, ModItems.RAW_FTHARIN));
        addDrop(ModBlocks.DEEPSLATE_FTHARIN_ORE, copperlikeOreDrops(ModBlocks.DEEPSLATE_FTHARIN_ORE, ModItems.RAW_FTHARIN));
        addDrop(ModBlocks.NETHER_FTHARIN_ORE, copperlikeOreDrops(ModBlocks.NETHER_FTHARIN_ORE, ModItems.RAW_FTHARIN));
    }

    public LootTable.Builder copperlikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 7.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
