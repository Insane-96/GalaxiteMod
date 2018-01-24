package net.insane96mcp.galaxite.events;

import javax.swing.text.html.parser.Entity;

import net.insane96mcp.galaxite.capabilities.IPlayerData;
import net.insane96mcp.galaxite.capabilities.PlayerDataProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerDrops {
	
	@SubscribeEvent
	public static void PlayerDropsEvent(PlayerDropsEvent event) {
		if (!(event.getEntityPlayer() instanceof EntityPlayerMP))
			return;
		EntityPlayerMP playerMP = (EntityPlayerMP)event.getEntityPlayer();
		IPlayerData playerData = playerMP.getCapability(PlayerDataProvider.PLAYER_DATA_CAP, null);
		
		if (!playerData.getInventorySaved().isEmpty())
			event.setCanceled(true);
	}
}
