package net.insane96mcp.galaxite;

import java.util.Random;

import net.insane96mcp.galaxite.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Galaxite.MOD_ID, name = Galaxite.MOD_NAME, version = Galaxite.VERSION, acceptedMinecraftVersions = Galaxite.MINECRAFT_VERSIONS)
public class Galaxite {
	
	public static final String MOD_ID = "galaxite";
	public static final String MOD_NAME = "Galaxite";
	public static final String VERSION = "1.0.2";
	public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":";
	public static final String MINECRAFT_VERSIONS = "[1.12,1.12.2]";

	public static Random random = new Random();
	
	@Instance(MOD_ID)
	public static Galaxite instance;
	
	@SidedProxy(clientSide = "net.insane96mcp.galaxite.proxies.ClientProxy", serverSide = "net.insane96mcp.galaxite.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		proxy.PreInit(event);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.Init(event);
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
		proxy.PostInit(event);
	}
}
