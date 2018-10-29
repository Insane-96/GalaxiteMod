package net.insane96mcp.galaxite.lib;

import net.insane96mcp.galaxite.Galaxite;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;

@Config(modid = Galaxite.MOD_ID, category = "", name = "Galaxite")
public class Properties {
	
	@Name("Config")
	public static final ConfigOptions config = new ConfigOptions();
	
	public static class ConfigOptions {

		@Name("More Info")
		@Comment("Whenever or not enable more infos")
		public boolean showAdvancedInfo = false;
		
		@Name("Tools And Weapons")
		public ToolsAndWeapons toolsAndWeapons = new ToolsAndWeapons();
		
		public static class ToolsAndWeapons {
			@Name("Bonus Efficiency")
			@Comment("Bonus Efficency % for tools when in the End (100.0 means that the tool will be twice as fast in the End)")
			public float bonusEfficiency = 100f;
			@Name("Bonus Damage")
			@Comment("Bonus % damage increase for Galaxite Tools and Sword when in the end")
			public float bonusDamage = 50f;
		}
		
		
		public Armor armor = new Armor();
		
		public static class Armor {
			@Name("Save Items Max Chance")
			@Comment("Percentage Chance (while full Galaxite armor) per item stack to be saved when dying into the void")
			@RangeDouble(min = 0, max = 100)
			public float saveItemsMaxChance = 90f;
			@Name("Save Items Damage Per Item Saved")
			@Comment("How much every piece of armor will be damaged per item stack saved from the Void")
			public int saveItemsDamagePerItemSaved = 2;
		}
		
		@Name("Ore Generation")
		public OreGeneration oreGeneration = new OreGeneration();
		
		public static class OreGeneration {
			
			@Name("Outer Islands")
			public OuterIslands outerIslands = new OuterIslands();
			
			public static class OuterIslands {
				@Name("Ore per Vein")
				@Comment("Ores Generated Per Vein in outer islands")
				public int orePerVein = 3;
				@Name("Vein per Chunk")
				@Comment("Veins that try to spawn in a chunk in the outer islands")
				public int veinPerChunk = 5;
			}
			
			@Name("Main Island")
			public MainIsland mainIsland = new MainIsland();
			
			public static class MainIsland {
				@Name("Generate on Dragon Death")
				@Comment("Should Veins generate in the main island when the first killed dragon dies?")
				public boolean generateOnDragonDeath = true;
				@Name("Dragon Death Tick")
				@Comment("Every how many ticks during the first dragon death animation try to spawn 'vein_per_tick' vein of galaxite in the main island?")
				@RangeInt(min = 1, max = 101)
				public int dragonDeathTick = 1;
				@Name("Vein per Tick")
				@Comment("Veins that try to spawn every tick in the main island on dragon death")
				public int veinPerTick = 5;
				@Name("Ore Per Vein")
				@Comment("Ores Generated Per Vein in the main island")
				public int orePerVein = 3;
			}
			
			@Name("Only Near Air")
			@Comment("Should Veins only generate near Air (so mining will lead no ores) (applies to main and outer islands generation)")
			public boolean onlyNearAir = true;
		}
	}
}
