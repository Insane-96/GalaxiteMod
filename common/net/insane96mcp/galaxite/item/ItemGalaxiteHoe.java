package net.insane96mcp.galaxite.item;

import net.insane96mcp.galaxite.Galaxite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemGalaxiteHoe extends ItemHoe{
	public ItemGalaxiteHoe(String name, ToolMaterial material, CreativeTabs tab) {
		super(material);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + Galaxite.RESOURCE_PREFIX + net.insane96mcp.galaxite.lib.Names.GALAXITE_HOE;
	}
}
