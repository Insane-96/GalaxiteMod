package net.insane96mcp.galaxite.item;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGalaxite extends Item {
	
	public ItemGalaxite(String name, CreativeTabs tab) {
		setRegistryName(name);
		setCreativeTab(tab);
		
	}
	
	@Override
	public String getTranslationKey(ItemStack stack) {
		return "item." + Galaxite.RESOURCE_PREFIX + Names.GALAXITE_ITEM;
	}
}
