package exciision.lovecraft.item;



import exciision.lovecraft.Lovecraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FTHARIN_INGOT = registerItem("ftharin_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_FTHARIN = registerItem("raw_ftharin", new Item(new FabricItemSettings()));

    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries) {
        entries.add(FTHARIN_INGOT);
        entries.add(RAW_FTHARIN);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Lovecraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Lovecraft.LOGGER.info("Register Mod Items for" + Lovecraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngridientItemGroup);
    }
}
