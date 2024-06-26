package exciision.lovecraft;

import exciision.lovecraft.block.ModBlocks;
import exciision.lovecraft.item.ModItemGroups;
import exciision.lovecraft.item.ModItems;
import exciision.lovecraft.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lovecraft implements ModInitializer {
	public static final String MOD_ID = "lovecraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();
	}
}