package net.insane96mcp.galaxite.lib;

public class Properties {
	
	public static void Init() {
		ToolsAndWeapons.Init();
		Armor.Init();
		OreGeneration.Init();
		General.Init();
	}
	
	public static class General{
		public static final String CATEGORY = "general";
		
		public static boolean showAdvancedInfo;
		
		public static void Init() {
			showAdvancedInfo = Config.LoadBoolProperty(CATEGORY, "show_advanced_info", "Whenever or not enable the \"Press SHIFT to show more infos\" thing", false);
		}
	}
	
	public static class ToolsAndWeapons{
		public static final String CATEGORY = "tools_and_weapons";
		
		public static class MaterialStats{
			public static final String SUBCATEGORY = CATEGORY + ".material_stats";
			
			public static int harvestLevel;
			public static int maxUses;
			public static float efficency;
			public static float baseDamage;
			public static int enchantability;
			
			public static void Init() {
				harvestLevel = Config.LoadIntProperty(SUBCATEGORY, "harvest_level", "Harvest level for Galaxite Tools\n(0 for wood, 1 for stone, 2 for iron, 3 for diamond)\n", 3);
				maxUses = Config.LoadIntProperty(SUBCATEGORY, "max_uses", "Durability for Galaxite Tools and Sword", 502);
				efficency = Config.LoadFloatProperty(SUBCATEGORY, "efficency", "Efficency for Galaxite Tools", 7f);
				baseDamage = Config.LoadFloatProperty(SUBCATEGORY, "base_damage", "Base Damage for Galaxite Tools and Sword (each tools then adds a custom attack damage, e.g. sword adds 3.0 attack damage)", 2.5f);
				enchantability = Config.LoadIntProperty(SUBCATEGORY, "enchantability", "Enchantability for Galaxite Tools and Sword", 15);
			}
		}

		public static class BonusStats{
			public static final String SUBCATEGORY = CATEGORY + ".bonus_stats";

			public static float efficiency;
			public static float damage;
			
			public static void Init() {
				efficiency = Config.LoadFloatProperty(SUBCATEGORY, "end_bonus_efficency", "Bonus Efficency % for tools when in the End (100.0 means that the tool will be twice as fast in the End)", 100.0f);
				damage = Config.LoadFloatProperty(SUBCATEGORY, "end_bonus_damage", "Bonus % damage increase for Galaxite Tools and Sword when in the end", 50.0f);
			}
		}
		
		
		public static void Init() {
			MaterialStats.Init();
			BonusStats.Init();
		}
	}
	
	public static class Armor{
		public static final String CATEGORY = "armor";
		
		public static class MaterialStats{
			public static final String SUBCATEGORY = CATEGORY + ".material_stats";
			
			public static int baseDurability;
			public static int[] armorPoints;
			public static int enchantability;
			public static float toughness;
			
			public static void Init() {
				baseDurability = Config.LoadIntProperty(SUBCATEGORY, "base_durability", "Base durability for Galaxite Armor\n(this value is multiplied by [13, 16, 15, 11] respectively from helmet to boots)\n", 33);
				armorPoints = Config.LoadIntListProperty(SUBCATEGORY, "armor_points", "Armor points for Galaxite Armor", new int[] {2, 5, 4, 2});
				enchantability = Config.LoadIntProperty(SUBCATEGORY, "enchantability", "Enchantability for Galaxite Armor", 15);
				toughness = Config.LoadFloatProperty(SUBCATEGORY, "toughness", "Toughness for Galaxite Armor", 0f);
			}
		}
		
		public static class BonusStats{
			public static final String SUBCATEGORY = CATEGORY + ".bonus_stats";
			
			public static float saveItemsMaxChance;
			public static int saveItemsDamagePerItemSaved;
			
			public static void Init() {
				saveItemsMaxChance = Config.LoadFloatProperty(SUBCATEGORY, "save_items_max_chance", "Percentage Chance (while full Galaxite armor) per item stack to be saved when dying into the void", 90.0f);
				saveItemsDamagePerItemSaved = Config.LoadIntProperty(SUBCATEGORY, "save_items_damage_per_item", "How much every piece of armor will be damaged per item stack saved from the Void", 2);
			}
		}
		
		public static void Init() {
			MaterialStats.Init();
			BonusStats.Init();
		}
	}
	
	public static class OreGeneration{
		public static final String CATEGORY = "ore_generation";
		
		public static int orePerVein;
		public static int veinPerChunk;
		public static boolean onlyNearAir;
		public static boolean generateOnDragonDeath;
		public static int firstDragonDeathTick;
		public static int dragonDeathTick;
		
		public static void Init() {
			orePerVein = Config.LoadIntProperty(CATEGORY, "ore_per_vein", "Ores Generated Per Vein", 5);
			veinPerChunk = Config.LoadIntProperty(CATEGORY, "vein_per_chunk", "Veins that try to spawn in a chunk", 5);
			onlyNearAir = Config.LoadBoolProperty(CATEGORY, "only_near_air", "Should Veins only generate near Air (so mining will lead no ores)", true);

			generateOnDragonDeath = Config.LoadBoolProperty(CATEGORY, "generate_on_dragon_death", "Should Veins generate in the main island when he dragon death animation is playing?", true);
			firstDragonDeathTick = Config.LoadIntProperty(CATEGORY, "first_dragon_death_tick", "Every how many ticks during the first dragon death animation try to spawn a vein of galaxite in the main island?", 1);
			dragonDeathTick = Config.LoadIntProperty(CATEGORY, "dragon_death_tick", "Every how many ticks during the non-first dragon death animation try to spawn a vein of galaxite in the main island?", 10);
		}
	}
}
