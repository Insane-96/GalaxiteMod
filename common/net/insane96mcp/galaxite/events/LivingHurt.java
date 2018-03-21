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
		//PlayerDamageReduction(event);
		PlayerDamageDealt(event);
	}
	
	public static void PlayerDamageReduction(LivingHurtEvent event) {
		/*//May not work
		if (Properties.Armor.voidReducedDamage == 0.0f)
			return;
		
		EntityLivingBase entityLivingBase = event.getEntityLiving();
		if (!(entityLivingBase instanceof EntityPlayer))
			return;
			
		EntityPlayer player = (EntityPlayer)entityLivingBase;
		DamageSource source = event.getSource();
		Entity entity = source.getEntity();
		
		if (source != DamageSource.OUT_OF_WORLD)
			return;
		
	    int materialsUsed = 0;
	    Iterable<ItemStack> playerArmor = player.getArmorInventoryList();
	    for (ItemStack armorPiece : playerArmor) {
	    	for (int i = 0; i < armorList.length; i++) {
		        if (ItemStack.areItemsEqualIgnoreDurability(armorPiece, armorList[i])) {
					materialsUsed += materialPerPiece[i];
					
		        	if (player.world.rand.nextDouble() < Properties.Armor.voidDamageArmorChance / 100f) { 
		        		armorPiece.damageItem(Properties.Armor.voidDamageArmor, player);
		        		player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0f, 0.5f);
		        	}

					break;
				}
			}
		}
	    
	    if(materialsUsed == 0)
	    	return;
		
		float amount = event.getAmount();
	    
    	float reductionPerMaterial = Properties.Armor.voidReducedDamage / 100f / 24f;
    	float percentageReduction = reductionPerMaterial * materialsUsed;
    	amount = amount * (1f - percentageReduction);
        event.setAmount(amount);*/
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

		event.setAmount(damageDealt + damageDealt * (Properties.Tool.endDamageBonus / 100f));
	}
}
