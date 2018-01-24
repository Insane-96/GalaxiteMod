package net.insane96mcp.galaxite.item.material;

import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterial {
	public static ToolMaterial Tool = EnumHelper.addToolMaterial("galaxite", Properties.Tool.harvestLevel, Properties.Tool.maxUses, Properties.Tool.efficency, Properties.Tool.baseDamage, Properties.Tool.enchantability);
	public static ArmorMaterial Armor = EnumHelper.addArmorMaterial("galaxite", "galaxite:galaxite_armor", Properties.Armor.baseDurability, Properties.Armor.armorPoints, Properties.Armor.enchantability, SoundEvents.ITEM_ARMOR_EQUIP_IRON, Properties.Armor.toughness);
}
