package net.insane96mcp.galaxite.init;

import java.util.ArrayList;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.item.ItemGalaxite;
import net.insane96mcp.galaxite.item.ItemGalaxiteArmor;
import net.insane96mcp.galaxite.item.ItemGalaxiteAxe;
import net.insane96mcp.galaxite.item.ItemGalaxiteHoe;
import net.insane96mcp.galaxite.item.ItemGalaxitePickaxe;
import net.insane96mcp.galaxite.item.ItemGalaxiteShovel;
import net.insane96mcp.galaxite.item.ItemGalaxiteSword;
import net.insane96mcp.galaxite.item.material.ModMaterial;
import net.insane96mcp.galaxite.lib.Names;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
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
	
	public static ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	public static void Init() {
		galaxiteItem = new ItemGalaxite(Names.GALAXITE_ITEM, CreativeTabs.MATERIALS);
		ITEMS.add(galaxiteItem);

		galaxitePickaxeItem = new ItemGalaxitePickaxe(Names.GALAXITE_PICKAXE, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxitePickaxeItem);

		galaxiteShovelItem = new ItemGalaxiteShovel(Names.GALAXITE_SHOVEL, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxiteShovelItem);

		galaxiteAxeItem = new ItemGalaxiteAxe(Names.GALAXITE_AXE, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxiteAxeItem);
		
		galaxiteHoeItem = new ItemGalaxiteHoe(Names.GALAXITE_HOE, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxiteHoeItem);
		
		galaxiteSwordItem = new ItemGalaxiteSword(Names.GALAXITE_SWORD, ModMaterial.Tool, CreativeTabs.COMBAT);
		ITEMS.add(galaxiteSwordItem);
		
		galaxiteHelmetItem = new ItemGalaxiteArmor(Names.GALAXITE_HELMET, ModMaterial.Armor, 0, EntityEquipmentSlot.HEAD);
		ITEMS.add(galaxiteHelmetItem);

		galaxiteChestplateItem = new ItemGalaxiteArmor(Names.GALAXITE_CHESTPLATE, ModMaterial.Armor, 0, EntityEquipmentSlot.CHEST);
		ITEMS.add(galaxiteChestplateItem);

		galaxiteLeggingsItem = new ItemGalaxiteArmor(Names.GALAXITE_LEGGINGS, ModMaterial.Armor, 1, EntityEquipmentSlot.LEGS);
		ITEMS.add(galaxiteLeggingsItem);

		galaxiteBootsItem = new ItemGalaxiteArmor(Names.GALAXITE_BOOTS, ModMaterial.Armor, 0, EntityEquipmentSlot.FEET);
		ITEMS.add(galaxiteBootsItem);
	}
	
	public static void PostInit() {
		GameRegistry.addSmelting(ModBlocks.galaxiteOre, new ItemStack(galaxiteItem), 3.0f);
	}
}
