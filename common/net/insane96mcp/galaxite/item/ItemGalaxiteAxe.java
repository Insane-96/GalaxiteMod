package net.insane96mcp.galaxite.item;

import net.insane96mcp.galaxite.Galaxite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemGalaxiteAxe extends ItemAxe{
	public ItemGalaxiteAxe(String name, ToolMaterial material, CreativeTabs tab) {
		super(material, 10f, -3.0f);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + Galaxite.RESOURCE_PREFIX + net.insane96mcp.galaxite.lib.Names.GALAXITE_AXE;
	}
}
