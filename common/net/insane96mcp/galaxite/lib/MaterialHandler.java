package net.insane96mcp.galaxite.lib;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {
	public static ToolMaterial Galaxite = EnumHelper.addToolMaterial("galaxite", 3, 502, 7f, 2.5f, 12);
	public static ArmorMaterial galaxiteArmorMaterial = EnumHelper.addArmorMaterial("galaxite", "galaxite:galaxite_armor", 24, new int[]{4, 6, 5, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f);
}
