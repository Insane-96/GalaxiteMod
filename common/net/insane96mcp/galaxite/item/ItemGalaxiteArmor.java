package net.insane96mcp.galaxite.item;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Properties;
import net.insane96mcp.galaxite.lib.Tooltips;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class ItemGalaxiteArmor extends ItemArmor{

	private final String name;
	
	public ItemGalaxiteArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.name = name;
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + Galaxite.RESOURCE_PREFIX + this.name;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		if (GuiScreen.isShiftKeyDown()) {
			tooltip.add(I18n.format(Tooltips.Armor.adv_info_save_inventory, Properties.Armor.saveItemsMaxChance, Properties.Armor.saveItemsDamagePerItemSaved));
			tooltip.add(I18n.format(Tooltips.Armor.adv_info_damage_reduction, Properties.Armor.voidReducedDamage, Properties.Armor.voidDamageArmorChance, Properties.Armor.voidDamageArmor));
		}
		else {
			tooltip.add(I18n.format(Tooltips.Armor.base_info_save_inventory));
			tooltip.add(I18n.format(Tooltips.Armor.base_info_damage_reduction));
			tooltip.add(I18n.format(Tooltips.General.shiftForMore));
		}
	}
}
