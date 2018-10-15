package net.insane96mcp.galaxite.events;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.capabilities.IPlayerData;
import net.insane96mcp.galaxite.capabilities.ItemSlot;
import net.insane96mcp.galaxite.capabilities.PlayerDataProvider;
import net.insane96mcp.galaxite.init.ModItems;
import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingDeath {
	
	private static ItemStack[] armorList = new ItemStack[] {
		new ItemStack(ModItems.galaxiteHelmetItem), 
		new ItemStack(ModItems.galaxiteChestplateItem), 
		new ItemStack(ModItems.galaxiteLeggingsItem), 
		new ItemStack(ModItems.galaxiteBootsItem)
	};
	static float[] materialPerPiece = new float[] { 5, 8, 7, 4 };
	
	@SubscribeEvent 
	public static void EventLivingDeath(LivingDeathEvent event) {
		if (event.getSource() != DamageSource.OUT_OF_WORLD)
			return;
		
		Entity entity = event.getEntity();
		
		if (!(entity instanceof EntityPlayerMP))
			return;
		
		EntityPlayerMP playerMP = (EntityPlayerMP)entity;
		
		int materialsUsed = 0;
	    Iterable<ItemStack> playerArmor = playerMP.getArmorInventoryList();
	    for (ItemStack armorPiece : playerArmor) {
	    	for (int i = 0; i < armorList.length; i++) {
		        if (ItemStack.areItemsEqualIgnoreDurability(armorPiece, armorList[i])) {
					materialsUsed += materialPerPiece[i];
					break;
				}
			}
		}
	    
	    if (materialsUsed == 0) 
	    	return;
    	float maxChancePerc = Properties.Armor.BonusStats.saveItemsMaxChance / 100f;
    	float chancePerMaterial = maxChancePerc / 24f;
    	float chance = chancePerMaterial * materialsUsed;
		
		InventoryPlayer inventory = playerMP.inventory;

		IPlayerData playerData = playerMP.getCapability(PlayerDataProvider.PLAYER_DATA_CAP, null);
		
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			int slot = i;
			ItemStack itemStack = inventory.getStackInSlot(i);
			
			if (itemStack.isEmpty())
				continue;
			
			//Check for offhand slot
			if (slot == 40)
				slot = 99;
			
			//Check for Armor
			else if (slot >= 36 && slot <= 39)
				slot += 64;
			
			if (slot >= 100 && slot <= 103) {
				playerData.addItemToInventorySaved(new ItemSlot(itemStack, slot));
				continue;
			}
			
			float rng = Galaxite.random.nextFloat();
			
			if (rng > chance)	
				continue;
			
			playerData.addItemToInventorySaved(new ItemSlot(itemStack, slot));
			
			for (ItemStack armorPiece : playerArmor) {
		    	for (int armor = 0; armor < armorList.length; armor++) {
			        if (ItemStack.areItemsEqualIgnoreDurability(armorPiece, armorList[armor])) {
			        	armorPiece.damageItem(Properties.Armor.BonusStats.saveItemsDamagePerItemSaved, playerMP);
			        	break;
					}
				}
			}
		}
	}
}
