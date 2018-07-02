package net.insane96mcp.galaxite.init;

import java.util.ArrayList;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.block.BlockGalaxite;
import net.insane96mcp.galaxite.block.BlockGalaxiteOre;
import net.insane96mcp.galaxite.lib.Names;
import net.insane96mcp.galaxite.worldgen.OreGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
