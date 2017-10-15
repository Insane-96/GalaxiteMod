package net.insane96mcp.galaxite.item;

import net.insane96mcp.galaxite.Galaxite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemGalaxiteSword extends ItemSword{
	private final float bonusDamage = 0.1f;
	
	public ItemGalaxiteSword(String name, ToolMaterial material, CreativeTabs tab) {
		super(material);
		setRegistryName(name);
		setCreativeTab(tab);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + Galaxite.RESOURCE_PREFIX + net.insane96mcp.galaxite.lib.Names.GALAXITE_SWORD;
	}
}
