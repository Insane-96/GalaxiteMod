package net.insane96mcp.galaxite.proxies;

import net.insane96mcp.galaxite.capabilities.CapabilityHandler;
import net.insane96mcp.galaxite.capabilities.IPlayerData;
import net.insane96mcp.galaxite.capabilities.PlayerData;
import net.insane96mcp.galaxite.capabilities.PlayerDataStorage;
import net.insane96mcp.galaxite.events.LivingDeath;
import net.insane96mcp.galaxite.events.LivingHurt;
import net.insane96mcp.galaxite.events.PlayerBreakSpeed;
import net.insane96mcp.galaxite.events.PlayerDrops;
import net.insane96mcp.galaxite.events.PlayerRespawn;
import net.insane96mcp.galaxite.init.ModBlocks;
import net.insane96mcp.galaxite.init.ModItems;
import net.insane96mcp.galaxite.lib.Config;
import net.insane96mcp.galaxite.lib.Properties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		Config.config = new Configuration(event.getSuggestedConfigurationFile());
		Config.SyncConfig();
		Properties.Init();
		
		ModItems.Init();
		ModBlocks.Init();
	}
	
	public void Init(FMLInitializationEvent event) {
		ModItems.PostInit();
		ModBlocks.PostInit();
		MinecraftForge.EVENT_BUS.register(CapabilityHandler.class);
		MinecraftForge.EVENT_BUS.register(LivingDeath.class);
		MinecraftForge.EVENT_BUS.register(LivingHurt.class);
		MinecraftForge.EVENT_BUS.register(PlayerBreakSpeed.class);
		MinecraftForge.EVENT_BUS.register(PlayerRespawn.class);
		MinecraftForge.EVENT_BUS.register(PlayerDrops.class);
		
		CapabilityManager.INSTANCE.register(IPlayerData.class, new PlayerDataStorage(), PlayerData.class);
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		Config.SaveConfig();
	}
}
