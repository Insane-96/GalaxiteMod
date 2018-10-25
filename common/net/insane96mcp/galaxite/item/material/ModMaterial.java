package net.insane96mcp.galaxite.item.material;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterial {
	public static ToolMaterial Tool = EnumHelper.addToolMaterial("galaxite", 3, 502, 7f, 2.5f, 15);
	public static ArmorMaterial Armor = EnumHelper.addArmorMaterial("galaxite", "galaxite:galaxite_armor", 33, new int[] {2, 5, 4, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
}
