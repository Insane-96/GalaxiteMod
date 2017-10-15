package net.insane96mcp.galaxite.init;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.item.ItemGalaxite;
import net.insane96mcp.galaxite.item.ItemGalaxiteArmor;
import net.insane96mcp.galaxite.item.ItemGalaxiteAxe;
import net.insane96mcp.galaxite.item.ItemGalaxiteHoe;
import net.insane96mcp.galaxite.item.ItemGalaxitePickaxe;
import net.insane96mcp.galaxite.item.ItemGalaxiteShovel;
import net.insane96mcp.galaxite.item.ItemGalaxiteSword;
import net.insane96mcp.galaxite.lib.MaterialHandler;
import net.insane96mcp.galaxite.lib.Names;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static ItemGalaxite galaxiteItem;
	
	public static ItemGalaxitePickaxe galaxitePickaxeItem;
	public static ItemGalaxiteShovel galaxiteShovelItem;
	public static ItemGalaxiteAxe galaxiteAxeItem;
	public static ItemGalaxiteHoe galaxiteHoeItem;
	public static ItemGalaxiteSword galaxiteSwordItem;

	public static ItemGalaxiteArmor galaxiteHelmetItem;
	public static ItemGalaxiteArmor galaxiteChestplateItem;
	public static ItemGalaxiteArmor galaxiteLeggingsItem;
	public static ItemGalaxiteArmor galaxiteBootsItem;
	
	public static void Init() {
		galaxiteItem = new ItemGalaxite(Names.GALAXITE_ITEM, CreativeTabs.MATERIALS);
		GameRegistry.register(galaxiteItem);

		galaxitePickaxeItem = new ItemGalaxitePickaxe(Names.GALAXITE_PICKAXE, MaterialHandler.Galaxite, CreativeTabs.TOOLS);
		GameRegistry.register(galaxitePickaxeItem);

		galaxiteShovelItem = new ItemGalaxiteShovel(Names.GALAXITE_SHOVEL, MaterialHandler.Galaxite, CreativeTabs.TOOLS);
		GameRegistry.register(galaxiteShovelItem);

		galaxiteAxeItem = new ItemGalaxiteAxe(Names.GALAXITE_AXE, MaterialHandler.Galaxite, CreativeTabs.TOOLS);
		GameRegistry.register(galaxiteAxeItem);
		
		galaxiteHoeItem = new ItemGalaxiteHoe(Names.GALAXITE_HOE, MaterialHandler.Galaxite, CreativeTabs.TOOLS);
		GameRegistry.register(galaxiteHoeItem);
		
		galaxiteSwordItem = new ItemGalaxiteSword(Names.GALAXITE_SWORD, MaterialHandler.Galaxite, CreativeTabs.COMBAT);
		GameRegistry.register(galaxiteSwordItem);

		galaxiteHelmetItem = new ItemGalaxiteArmor(Names.GALAXITE_HELMET, MaterialHandler.galaxiteArmorMaterial, 0, EntityEquipmentSlot.HEAD);
		GameRegistry.register(galaxiteHelmetItem);

		galaxiteChestplateItem = new ItemGalaxiteArmor(Names.GALAXITE_CHESTPLATE, MaterialHandler.galaxiteArmorMaterial, 0, EntityEquipmentSlot.CHEST);
		GameRegistry.register(galaxiteChestplateItem);

		galaxiteLeggingsItem = new ItemGalaxiteArmor(Names.GALAXITE_LEGGINGS, MaterialHandler.galaxiteArmorMaterial, 1, EntityEquipmentSlot.LEGS);
		GameRegistry.register(galaxiteLeggingsItem);

		galaxiteBootsItem = new ItemGalaxiteArmor(Names.GALAXITE_BOOTS, MaterialHandler.galaxiteArmorMaterial, 0, EntityEquipmentSlot.FEET);
		GameRegistry.register(galaxiteBootsItem);
	}
	
	public static void PostInit() {
		GameRegistry.addShapelessRecipe(new ItemStack(galaxiteItem, 9), ModBlocks.galaxiteBlock);
		GameRegistry.addSmelting(ModBlocks.galaxiteOre, new ItemStack(galaxiteItem), 3.0f);

		GameRegistry.addRecipe(new ItemStack(galaxitePickaxeItem), "vvv", " s ", " s ", 'v', galaxiteItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(galaxiteShovelItem), " v ", " s ", " s ", 'v', galaxiteItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(galaxiteAxeItem), " vv", " sv", " s ", 'v', galaxiteItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(galaxiteHoeItem), " vv", " s ", " s ", 'v', galaxiteItem, 's', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(galaxiteSwordItem), " v ", " v ", " s ", 'v', galaxiteItem, 's', Items.STICK);

		GameRegistry.addRecipe(new ItemStack(galaxiteHelmetItem), "vvv", "v v", 'v', galaxiteItem);
		GameRegistry.addRecipe(new ItemStack(galaxiteChestplateItem), "v v", "vvv", "vvv", 'v', galaxiteItem);
		GameRegistry.addRecipe(new ItemStack(galaxiteLeggingsItem), "vvv", "v v", "v v", 'v', galaxiteItem);
		GameRegistry.addRecipe(new ItemStack(galaxiteBootsItem), "v v", "v v", 'v', galaxiteItem);
	}
	
	@SideOnly(Side.CLIENT)
	public static void InitClient(ItemModelMesher mesher) {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_ITEM);
		ModelLoader.registerItemVariants(galaxiteItem, modelResourceLocation);
		mesher.register(galaxiteItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_PICKAXE);
		ModelLoader.registerItemVariants(galaxitePickaxeItem, modelResourceLocation);
		mesher.register(galaxitePickaxeItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_SHOVEL);
		ModelLoader.registerItemVariants(galaxiteShovelItem, modelResourceLocation);
		mesher.register(galaxiteShovelItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_AXE);
		ModelLoader.registerItemVariants(galaxiteAxeItem, modelResourceLocation);
		mesher.register(galaxiteAxeItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_HOE);
		ModelLoader.registerItemVariants(galaxiteHoeItem, modelResourceLocation);
		mesher.register(galaxiteHoeItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_SWORD);
		ModelLoader.registerItemVariants(galaxiteSwordItem, modelResourceLocation);
		mesher.register(galaxiteSwordItem, 0, modelResourceLocation);

		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_HELMET);
		ModelLoader.registerItemVariants(galaxiteHelmetItem, modelResourceLocation);
		mesher.register(galaxiteHelmetItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_CHESTPLATE);
		ModelLoader.registerItemVariants(galaxiteChestplateItem, modelResourceLocation);
		mesher.register(galaxiteChestplateItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_LEGGINGS);
		ModelLoader.registerItemVariants(galaxiteLeggingsItem, modelResourceLocation);
		mesher.register(galaxiteLeggingsItem, 0, modelResourceLocation);
		
		modelResourceLocation = new ModelResourceLocation(Galaxite.RESOURCE_PREFIX + Names.GALAXITE_BOOTS);
		ModelLoader.registerItemVariants(galaxiteBootsItem, modelResourceLocation);
		mesher.register(galaxiteBootsItem, 0, modelResourceLocation);
	}
}
