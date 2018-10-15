package net.insane96mcp.galaxite.item.material;

import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterial {
	public static ToolMaterial Tool = EnumHelper.addToolMaterial("galaxite", Properties.ToolsAndWeapons.MaterialStats.harvestLevel, Properties.ToolsAndWeapons.MaterialStats.maxUses, Properties.ToolsAndWeapons.MaterialStats.efficency, Properties.ToolsAndWeapons.MaterialStats.baseDamage, Properties.ToolsAndWeapons.MaterialStats.enchantability);
	public static ArmorMaterial Armor = EnumHelper.addArmorMaterial("galaxite", "galaxite:galaxite_armor", Properties.Armor.MaterialStats.baseDurability, Properties.Armor.MaterialStats.armorPoints, Properties.Armor.MaterialStats.enchantability, SoundEvents.ITEM_ARMOR_EQUIP_IRON, Properties.Armor.MaterialStats.toughness);
}
