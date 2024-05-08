package exciision.lovecraft.item;

import exciision.lovecraft.Lovecraft;
import exciision.lovecraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FTHARIN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Lovecraft.MOD_ID, "fhtarin"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ftharin"))
                    .icon(() -> new ItemStack(ModItems.FTHARIN_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_FTHARIN);
                        entries.add(ModItems.FTHARIN_INGOT);

                        entries.add(ModBlocks.FTHARIN_BLOCK);
                        entries.add(ModBlocks.RAW_FTHARIN_BLOCK);

                        entries.add(ModBlocks.FTHARIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_FTHARIN_ORE);
                        entries.add(ModBlocks.NETHER_FTHARIN_ORE);

                        entries.add(ModItems.FTHARIN_PICKAXE);
                        entries.add(ModItems.FTHARIN_AXE);
                        entries.add(ModItems.FTHARIN_SHOVEL);
                        entries.add(ModItems.FTHARIN_SWORD);
                        entries.add(ModItems.FTHARIN_HOE);


                    }).build());

    public static void registerItemGroups() {
        Lovecraft.LOGGER.info("Registering Item Groups for" + Lovecraft.MOD_ID);
    }
}
