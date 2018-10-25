package net.insane96mcp.galaxite.item;

import java.util.List;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Properties;
import net.insane96mcp.galaxite.lib.Stings.Names;
import net.insane96mcp.galaxite.lib.Stings.Tooltips;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGalaxiteAxe extends ItemAxe{
	
	public ItemGalaxiteAxe(String name, ToolMaterial material, CreativeTabs tab) {
		super(material, 9, -3.05f);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return "item." + Galaxite.RESOURCE_PREFIX + Names.GALAXITE_AXE;
	}
	

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (GuiScreen.isShiftKeyDown() && Properties.config.showAdvancedInfo) {
			tooltip.add(I18n.format(Tooltips.Tools.adv_info_increased_efficency, Properties.config.toolsAndWeapons.bonusEfficiency));
			tooltip.add(I18n.format(Tooltips.Tools.adv_info_increased_damage, Properties.config.toolsAndWeapons.bonusDamage));
		}
		else {
			tooltip.add(I18n.format(Tooltips.Tools.base_info_increased_efficency));
			tooltip.add(I18n.format(Tooltips.Tools.base_info_increased_damage));
			if (Properties.config.showAdvancedInfo)
				tooltip.add(I18n.format(Tooltips.General.shiftForMore));
		}
	}
}
