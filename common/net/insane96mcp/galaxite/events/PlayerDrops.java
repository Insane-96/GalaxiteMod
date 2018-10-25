package net.insane96mcp.galaxite.events;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.capabilities.IPlayerData;
import net.insane96mcp.galaxite.capabilities.PlayerDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Galaxite.MOD_ID)
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
