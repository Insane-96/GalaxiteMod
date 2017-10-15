package net.insane96mcp.galaxite.lib;

import net.insane96mcp.galaxite.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CustomEventHandler {
	@SubscribeEvent
	public static void LivingHurtEvent(LivingHurtEvent event) {
		PlayerDamageReduction(event);
		PlayerDamageDealt(event);
	}
	
	private static final float bonusDamage = 0.5f;
	
	private static ItemStack[] galaxiteTools = new ItemStack[] {
		new ItemStack(ModItems.galaxiteAxeItem),
		new ItemStack(ModItems.galaxiteHoeItem),
		new ItemStack(ModItems.galaxitePickaxeItem),
		new ItemStack(ModItems.galaxiteShovelItem),
		new ItemStack(ModItems.galaxiteSwordItem)
	};
	
	public static void PlayerDamageReduction(LivingHurtEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			DamageSource source = event.getSource();
			
			if (source.getDamageType() != "mob" && source != DamageSource.DRAGON_BREATH)
				return;
			
			Entity entity = source.getEntity();
			ItemStack[] armorList = new ItemStack[] {
				new ItemStack(ModItems.galaxiteHelmetItem), 
				new ItemStack(ModItems.galaxiteChestplateItem), 
				new ItemStack(ModItems.galaxiteLeggingsItem), 
				new ItemStack(ModItems.galaxiteBootsItem)
			};
			
			float[] materialPerPiece = new float[] { 5, 8, 7, 4 };
			
			if (source == DamageSource.DRAGON_BREATH || entity instanceof EntityDragon || entity instanceof EntityShulker || entity instanceof EntityEnderman) {
			    int materialsUsed = 0;
			    Iterable<ItemStack> playerArmor = player.getArmorInventoryList();
			    for (ItemStack armorPiece : playerArmor) {
			    	for (int i = 0; i < armorList.length; i++) {
				        if (ItemStack.areItemsEqualIgnoreDurability(armorPiece, armorList[i])) {
							materialsUsed += materialPerPiece[i];
							break;
						}
					}
				}
			    
				float amount = event.getAmount();
			    
			    if(materialsUsed >= 1) {
			    	float maxReduction = 0.8f;
			    	float reductionPerMaterial = maxReduction / 24f;
			    	float percentageReduction = reductionPerMaterial * materialsUsed;
			    	amount = amount * (1f - percentageReduction);
			        event.setAmount(amount);
			    }
			}
		}
	}
	
	public static void PlayerDamageDealt(LivingHurtEvent event) {
		if (event.getSource().damageType != "player")
			return;
		
		for (ItemStack itemStack : galaxiteTools) {
			EntityPlayerMP player = (EntityPlayerMP) event.getSource().getEntity();
			ItemStack heldItem = player.getHeldItemMainhand();
			if (!ItemStack.areItemsEqualIgnoreDurability(heldItem, itemStack))
				continue;
			
			Entity target = event.getEntity();
			if (!(target instanceof EntityLivingBase))
				return;
			
			EntityLivingBase entity = (EntityLivingBase)target;
			
			if (entity instanceof EntityEnderman || entity instanceof EntityShulker || entity instanceof EntityDragon) {
				float health = ((EntityLivingBase)target).getHealth();
				float damageDealt = event.getAmount();
				
				float bonusDamageDealt = health * bonusDamage;
				heldItem.damageItem(1, player);
				event.setAmount(damageDealt + bonusDamageDealt);
			}
		}
	}

	@SubscribeEvent 
	public void PlayerDropsEvent(PlayerDropsEvent event) {
	    Entity entity = event.getEntity();
	    System.out.println("Drop " + entity);
	}

	@SubscribeEvent
	public void PlayerRespawnEvent(PlayerEvent.PlayerRespawnEvent event) {
	    System.out.println(event.player);
	}
	
	/*InventoryPlayer inventoryPlayer;
	
	@SubscribeEvent 
	public void PlayerDropsEvent(PlayerDropsEvent event) {
		Entity entity = event.getEntity();
		EntityPlayerMP playerMP;
		System.out.println("AAAAA " + entity);
		if (entity instanceof EntityPlayerMP) {
			playerMP = (EntityPlayerMP)entity;
			inventoryPlayer = playerMP.inventory;
			System.out.println("Saved inventory " + inventoryPlayer);
		}
	}
	
	@SubscribeEvent
	public void PlayerRespawnEvent(PlayerEvent.PlayerRespawnEvent event) {
		System.out.println("Loading inventory " + inventoryPlayer);
		if (inventoryPlayer != null) {
			event.player.inventory.copyInventory(inventoryPlayer);
			inventoryPlayer = null;
		}
	}*/
}
