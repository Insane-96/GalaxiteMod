package net.insane96mcp.galaxite.events;

import net.insane96mcp.galaxite.init.ModItems;
import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerBreakSpeed {
	private static ItemStack[] validEfficencyBoost = new ItemStack[] {
			new ItemStack(ModItems.galaxiteAxeItem),
			new ItemStack(ModItems.galaxitePickaxeItem),
			new ItemStack(ModItems.galaxiteShovelItem),
	};

	@SubscribeEvent
	public static void EventPlayerBreakSpeed(PlayerEvent.BreakSpeed event) {
		EntityPlayer player = event.getEntityPlayer();
		
		if (player.dimension != 1)
			return;
	
		ItemStack mainHand = player.getHeldItemMainhand();
		Block block = event.getState().getBlock();
		boolean isValid = false;
		
		for (ItemStack itemStack : validEfficencyBoost) {
			if (!ItemStack.areItemsEqualIgnoreDurability(mainHand, itemStack))
				continue;

			if (itemStack.getItem().getDestroySpeed(itemStack, event.getState()) > 1.0f) {
				isValid = true;
				break;
			}
		}
		
		if (!isValid)
			return;
		
		float speed = event.getOriginalSpeed();
		speed += event.getOriginalSpeed() * Properties.ToolsAndWeapons.BonusStats.efficiency / 100f;
		event.setNewSpeed(speed);
	}
}
