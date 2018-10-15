package net.insane96mcp.galaxite.events;

import net.insane96mcp.galaxite.init.ModItems;
import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingHurt {
	
	private static ItemStack[] armorList = new ItemStack[] {
		new ItemStack(ModItems.galaxiteHelmetItem), 
		new ItemStack(ModItems.galaxiteChestplateItem), 
		new ItemStack(ModItems.galaxiteLeggingsItem), 
		new ItemStack(ModItems.galaxiteBootsItem)
	};
	static float[] materialPerPiece = new float[] { 5, 8, 7, 4 };
	
	@SubscribeEvent
	public static void EventLivingHurt(LivingHurtEvent event) {
		PlayerDamageDealt(event);
	}
	
	private static ItemStack[] galaxiteTools = new ItemStack[] {
		new ItemStack(ModItems.galaxiteAxeItem),
		new ItemStack(ModItems.galaxiteHoeItem),
		new ItemStack(ModItems.galaxitePickaxeItem),
		new ItemStack(ModItems.galaxiteShovelItem),
		new ItemStack(ModItems.galaxiteSwordItem)
	};
	
	public static void PlayerDamageDealt(LivingHurtEvent event) {
		Entity sourceEntity = event.getSource().getTrueSource();
		if (!(sourceEntity instanceof EntityPlayerMP))
			return;
		
		Entity target = event.getEntity();
		if (!(target instanceof EntityLivingBase))
			return;
		
		EntityLivingBase entity = (EntityLivingBase)target;

		EntityPlayerMP player = (EntityPlayerMP) sourceEntity;
		ItemStack heldItem = player.getHeldItemMainhand();
		
		boolean applyBonusDamage = false;
		for (ItemStack tool : galaxiteTools) {
			if (ItemStack.areItemsEqualIgnoreDurability(heldItem, tool)) {
				applyBonusDamage = true;
				break;
			}
		}
		
		if (!applyBonusDamage)
			return;
		
		float damageDealt = event.getAmount();

		event.setAmount(damageDealt + damageDealt * (Properties.ToolsAndWeapons.BonusStats.damage / 100f));
	}
}
