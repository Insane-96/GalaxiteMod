package net.insane96mcp.galaxite.lib;

import net.insane96mcp.galaxite.Galaxite;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;

@Config(modid = Galaxite.MOD_ID, category = "", name = "Galaxite")
public class Properties {
	
	@Name("Config")
	public static final ConfigOptions config = new ConfigOptions();
	
	public static class ConfigOptions {

		@Comment("Whenever or not enable more infos")
		public boolean showAdvancedInfo = false;
		
		
		public ToolsAndWeapons toolsAndWeapons = new ToolsAndWeapons();
		
		public static class ToolsAndWeapons {
			@Comment("Bonus Efficency % for tools when in the End (100.0 means that the tool will be twice as fast in the End)")
			public float bonusEfficiency = 100f;
			@Comment("Bonus % damage increase for Galaxite Tools and Sword when in the end")
			public float bonusDamage = 50f;
		}
		
		
		public Armor armor = new Armor();
		
		public static class Armor {
			@Comment("Percentage Chance (while full Galaxite armor) per item stack to be saved when dying into the void")
			public float saveItemsMaxChance = 90f;
			@Comment("How much every piece of armor will be damaged per item stack saved from the Void")
			public int saveItemsDamagePerItemSaved = 2;
		}
		
		
		public OreGeneration oreGeneration = new OreGeneration();
		
		public static class OreGeneration {
			
			public OuterIslands outerIslands = new OuterIslands();
			
			public static class OuterIslands {
				@Comment("Ores Generated Per Vein in outer islands")
				public int orePerVein = 3;
				@Comment("Veins that try to spawn in a chunk in the outer islands")
				public int veinPerChunk = 5;
			}
			
			
			public MainIsland mainIsland = new MainIsland();
			
			public static class MainIsland {
				@Comment("Should Veins generate in the main island when the first killed dragon dies?")
				public boolean generateOnDragonDeath = true;
				@Comment("Every how many ticks during the first dragon death animation try to spawn 'vein_per_tick' vein of galaxite in the main island?")
				public int dragonDeathTick = 1;
				@Comment("Veins that try to spawn every tick in the main island on dragon death")
				public int veinPerTick = 5;
				@Comment("Ores Generated Per Vein in the main island")
				public int orePerVein = 3;
			}
			
			
			@Comment("Should Veins only generate near Air (so mining will lead no ores) (applies to main and outer islands generation)")
			public boolean onlyNearAir = true;
		}
	}
}
