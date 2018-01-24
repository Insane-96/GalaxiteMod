package net.insane96mcp.galaxite.init;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.block.BlockGalaxite;
import net.insane96mcp.galaxite.block.BlockGalaxiteOre;
import net.insane96mcp.galaxite.lib.Names;
import net.insane96mcp.galaxite.worldgen.OreGenerator;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	
	public static BlockGalaxite galaxiteBlock;
	public static BlockGalaxiteOre galaxiteOre;
	public static void Init() {
		galaxiteBlock = new BlockGalaxite();
		GameRegistry.register(galaxiteBlock);
		GameRegistry.register(new ItemBlock(galaxiteBlock), galaxiteBlock.getRegistryName());

		galaxiteOre = new BlockGalaxiteOre();
		GameRegistry.register(galaxiteOre);
		GameRegistry.register(new ItemBlock(galaxiteOre), galaxiteOre.getRegistryName());
		GameRegistry.registerWorldGenerator(new OreGenerator(), 123);
	}
	
	public static void PostInit() {
		GameRegistry.addRecipe(new ItemStack(galaxiteBlock, 1), "xxx", "xxx", "xxx", 'x', ModItems.galaxiteItem);
	}
	
	@SideOnly(Side.CLIENT)
	public static void InitClient(ItemModelMesher mesher) {
		Item item = Item.getItemFromBlock(galaxiteBlock);
		ModelResourceLocation model = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_BLOCK);
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
		
		item = Item.getItemFromBlock(galaxiteOre);
		model = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_ORE);
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
}
