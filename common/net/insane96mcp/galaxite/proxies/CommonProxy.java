package net.insane96mcp.galaxite.proxies;

import net.insane96mcp.galaxite.capabilities.IPlayerData;
import net.insane96mcp.galaxite.capabilities.PlayerData;
import net.insane96mcp.galaxite.capabilities.PlayerDataStorage;
import net.insane96mcp.galaxite.init.ModBlocks;
import net.insane96mcp.galaxite.init.ModItems;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		ModItems.PreInit();
		ModBlocks.PreInit();
	}
	
	public void Init(FMLInitializationEvent event) {
		ModItems.Init();
		ModBlocks.Init();
		
		CapabilityManager.INSTANCE.register(IPlayerData.class, new PlayerDataStorage(), PlayerData.class);
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
	}
}
