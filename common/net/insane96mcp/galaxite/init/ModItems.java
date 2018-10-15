package net.insane96mcp.galaxite.init;

import java.util.ArrayList;

import net.insane96mcp.galaxite.item.ItemGalaxite;
import net.insane96mcp.galaxite.item.ItemGalaxiteArmor;
import net.insane96mcp.galaxite.item.ItemGalaxiteAxe;
import net.insane96mcp.galaxite.item.ItemGalaxiteHoe;
import net.insane96mcp.galaxite.item.ItemGalaxitePickaxe;
import net.insane96mcp.galaxite.item.ItemGalaxiteShovel;
import net.insane96mcp.galaxite.item.ItemGalaxiteSword;
import net.insane96mcp.galaxite.item.material.ModMaterial;
import net.insane96mcp.galaxite.lib.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
	
	public static ItemGalaxite galaxite;
	
	public static ItemGalaxitePickaxe galaxitePickaxe;
	public static ItemGalaxiteShovel galaxiteShovel;
	public static ItemGalaxiteAxe galaxiteAxe;
	public static ItemGalaxiteHoe galaxiteHoe;
	public static ItemGalaxiteSword galaxiteSword;

	public static ItemGalaxiteArmor galaxiteHelmet;
	public static ItemGalaxiteArmor galaxiteChestplate;
	public static ItemGalaxiteArmor galaxiteLeggings;
	public static ItemGalaxiteArmor galaxiteBoots;
	
	public static ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	public static void PreInit() {
		galaxite = new ItemGalaxite(Names.GALAXITE_ITEM, CreativeTabs.MATERIALS);
		ITEMS.add(galaxite);

		galaxitePickaxe = new ItemGalaxitePickaxe(Names.GALAXITE_PICKAXE, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxitePickaxe);

		galaxiteShovel = new ItemGalaxiteShovel(Names.GALAXITE_SHOVEL, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxiteShovel);

		galaxiteAxe = new ItemGalaxiteAxe(Names.GALAXITE_AXE, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxiteAxe);
		
		galaxiteHoe = new ItemGalaxiteHoe(Names.GALAXITE_HOE, ModMaterial.Tool, CreativeTabs.TOOLS);
		ITEMS.add(galaxiteHoe);
		
		galaxiteSword = new ItemGalaxiteSword(Names.GALAXITE_SWORD, ModMaterial.Tool, CreativeTabs.COMBAT);
		ITEMS.add(galaxiteSword);
		
		galaxiteHelmet = new ItemGalaxiteArmor(Names.GALAXITE_HELMET, ModMaterial.Armor, 0, EntityEquipmentSlot.HEAD);
		ITEMS.add(galaxiteHelmet);

		galaxiteChestplate = new ItemGalaxiteArmor(Names.GALAXITE_CHESTPLATE, ModMaterial.Armor, 0, EntityEquipmentSlot.CHEST);
		ITEMS.add(galaxiteChestplate);

		galaxiteLeggings = new ItemGalaxiteArmor(Names.GALAXITE_LEGGINGS, ModMaterial.Armor, 1, EntityEquipmentSlot.LEGS);
		ITEMS.add(galaxiteLeggings);

		galaxiteBoots = new ItemGalaxiteArmor(Names.GALAXITE_BOOTS, ModMaterial.Armor, 0, EntityEquipmentSlot.FEET);
		ITEMS.add(galaxiteBoots);
	}
	
	public static void Init() {
		GameRegistry.addSmelting(ModBlocks.galaxiteOre, new ItemStack(galaxite), 3.0f);
		
		OreDictionary.registerOre("gemGalaxite", galaxite);
	}
}
