package net.insane96mcp.galaxite.init;

import java.util.ArrayList;

import net.insane96mcp.galaxite.block.BlockGalaxite;
import net.insane96mcp.galaxite.block.BlockGalaxiteOre;
import net.insane96mcp.galaxite.worldgen.OreGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
	
	public static BlockGalaxite galaxiteBlock;
	public static BlockGalaxiteOre galaxiteOre;
	
	public static ArrayList<Block> BLOCKS = new ArrayList<Block>();
	public static void PreInit() {
		galaxiteBlock = new BlockGalaxite();
		BLOCKS.add(galaxiteBlock);

		galaxiteOre = new BlockGalaxiteOre();
		BLOCKS.add(galaxiteOre);
		
		GameRegistry.registerWorldGenerator(new OreGenerator(), 123);
	}
	
	public static void Init() {
		OreDictionary.registerOre("oreGalaxite", galaxiteOre);
		OreDictionary.registerOre("blockGalaxite", galaxiteBlock);
	}
}
