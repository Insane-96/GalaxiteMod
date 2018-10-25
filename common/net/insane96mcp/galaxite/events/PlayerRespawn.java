package net.insane96mcp.galaxite.events;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.capabilities.IPlayerData;
import net.insane96mcp.galaxite.capabilities.ItemSlot;
import net.insane96mcp.galaxite.capabilities.PlayerDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = Galaxite.MOD_ID)
public class PlayerRespawn {
	
	@SubscribeEvent
	public static void PlayerRespawnEvent(PlayerEvent.PlayerRespawnEvent event) {
		EntityPlayerMP playerMP = (EntityPlayerMP)event.player;
		
		IPlayerData playerData = playerMP.getCapability(PlayerDataProvider.PLAYER_DATA_CAP, null);
		NonNullList<ItemSlot> inventorySaved = playerData.getInventorySaved();
		
		for (ItemSlot itemSlot : inventorySaved) {
			playerMP.replaceItemInInventory(itemSlot.slot, itemSlot.itemStack);
		}
		playerData.clearInventorySaved();
	}
}
