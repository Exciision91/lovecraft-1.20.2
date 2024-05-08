package exciision.lovecraft.item;



import exciision.lovecraft.Lovecraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FTHARIN_INGOT = registerItem("ftharin_ingot",
            new Item(new FabricItemSettings()));
    public static final Item RAW_FTHARIN = registerItem("raw_ftharin",
            new Item(new FabricItemSettings()));


    public static final Item FTHARIN_PICKAXE = registerItem("ftharin_pickaxe",
            new PickaxeItem(ModToolMaterial.FTHARIN, 1,-2.8f, new  FabricItemSettings()));
    public static final Item FTHARIN_AXE = registerItem("ftharin_axe",
            new AxeItem(ModToolMaterial.FTHARIN, 5.0f,-3.0f, new  FabricItemSettings()));
    public static final Item FTHARIN_SHOVEL = registerItem("ftharin_shovel",
            new ShovelItem(ModToolMaterial.FTHARIN, 1.5f,-3.0f, new  FabricItemSettings()));
    public static final Item FTHARIN_SWORD = registerItem("ftharin_sword",
            new SwordItem(ModToolMaterial.FTHARIN, 3,-2.4f, new  FabricItemSettings()));
    public static final Item FTHARIN_HOE = registerItem("ftharin_hoe",
            new HoeItem(ModToolMaterial.FTHARIN, -3,0.0f, new  FabricItemSettings()));


        private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Lovecraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Lovecraft.LOGGER.info("Register Mod Items for" + Lovecraft.MOD_ID);

    }
}
