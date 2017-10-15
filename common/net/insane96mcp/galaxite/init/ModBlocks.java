package net.insane96mcp.galaxite.init;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.block.BlockGalaxite;
import net.insane96mcp.galaxite.block.BlockGalaxiteOre;
import net.insane96mcp.galaxite.lib.Names;
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
		ResourceLocation location = new ResourceLocation(Galaxite.MOD_ID, Names.GALAXITE_BLOCK);
		galaxiteBlock = new BlockGalaxite();
		galaxiteBlock.setRegistryName(location);
		galaxiteBlock.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		galaxiteBlock.setHardness(15.0f);
		galaxiteBlock.setResistance(10.0f);
		galaxiteBlock.setHarvestLevel("pickaxe", 3);
		GameRegistry.register(galaxiteBlock);
		GameRegistry.register(new ItemBlock(galaxiteBlock), location);

		location = new ResourceLocation(Galaxite.MOD_ID, Names.GALAXITE_ORE);
		galaxiteOre = new BlockGalaxiteOre();
		galaxiteOre.setRegistryName(location);
		galaxiteOre.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		galaxiteOre.setHardness(12.0f);
		galaxiteOre.setResistance(33.3f);
		galaxiteOre.setHarvestLevel("pickaxe", 3);
		GameRegistry.register(galaxiteOre);
		GameRegistry.register(new ItemBlock(galaxiteOre), location);
		
		GameRegistry.registerWorldGenerator(new GenOres(), 0);
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
