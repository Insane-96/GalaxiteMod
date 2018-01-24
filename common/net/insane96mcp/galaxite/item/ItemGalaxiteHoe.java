package net.insane96mcp.galaxite.item;

import java.util.List;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Names;
import net.insane96mcp.galaxite.lib.Tooltips;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
		return "item." + Galaxite.RESOURCE_PREFIX + Names.GALAXITE_HOE;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format(Tooltips.Hoe.base_info));
	}
}
