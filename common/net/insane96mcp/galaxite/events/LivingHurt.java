package net.insane96mcp.galaxite.events;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.init.ModItems;
import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = Galaxite.MOD_ID)
public class LivingHurt {
	
	@SubscribeEvent
	public static void EventLivingHurt(LivingHurtEvent event) {
		PlayerDamageDealt(event);
	}
	
	private static ItemStack[] armorList = new ItemStack[] {
		new ItemStack(ModItems.galaxiteHelmet), 
		new ItemStack(ModItems.galaxiteChestplate), 
		new ItemStack(ModItems.galaxiteLeggings), 
		new ItemStack(ModItems.galaxiteBoots)
	};
	static float[] materialPerPiece = new float[] { 5, 8, 7, 4 };
	
	private static ItemStack[] galaxiteTools = new ItemStack[] {
		new ItemStack(ModItems.galaxiteAxe),
		new ItemStack(ModItems.galaxiteHoe),
		new ItemStack(ModItems.galaxitePickaxe),
		new ItemStack(ModItems.galaxiteShovel),
		new ItemStack(ModItems.galaxiteSword)
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

		event.setAmount(damageDealt + damageDealt * (Properties.config.toolsAndWeapons.bonusDamage / 100f));
	}
}
