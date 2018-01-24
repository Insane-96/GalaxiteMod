package net.insane96mcp.galaxite.lib;

public class Properties {
	
	public static void Init() {
		Tool.Init();
		Armor.Init();
		OreGeneration.Init();
	}
	
	public static class Tool{
		public static int harvestLevel;
		public static int maxUses;
		public static float efficency;
		public static float baseDamage;
		public static int enchantability;

		public static float endEfficencyBonus;
		public static float endDamageBonus;
		
		public static void Init() {
			harvestLevel = Config.LoadIntProperty("tools_and_weapons", "material_harvest_level", "Harvest Level for Galaxite Tools\n(0: Wood/Gold; 1: Stone, 2: Iron, 3: Diamond)\n", 3);
			maxUses = Config.LoadIntProperty("tools_and_weapons", "material_max_uses", "Durability for Galaxite Tools and Sword", 502);
			efficency = Config.LoadFloatProperty("tools_and_weapons", "material_efficency", "Efficency for Galaxite Tools", 7f);
			baseDamage = Config.LoadFloatProperty("tools_and_weapons", "material_base_damage", "Base damage for Galaxite Tools and Sword", 2.5f);
			enchantability = Config.LoadIntProperty("tools_and_weapons", "material_enchantability", "Enchantability for Galaxite Tools and Sword", 12);

			endEfficencyBonus = Config.LoadFloatProperty("tools_and_weapons", "end_bonus_efficency", "Efficency Percentage bonus for Galaxite Tools when in the end", 100.0f);
			endDamageBonus = Config.LoadFloatProperty("tools_and_weapons", "end_bonus_damage", "Percentage damage increase for Galaxite Tools and Sword when in the end", 50.0f);
		}
	}
	
	public static class Armor{
		public static int baseDurability;
		public static int[] armorPoints;
		public static int enchantability;
		public static float toughness;

		public static float voidReducedDamage;
		public static int voidDamageArmor;
		public static float voidDamageArmorChance;
		
		public static float saveItemsMaxChance;
		public static int saveItemsDamagePerItemSaved;
		
		public static void Init() {
			baseDurability = Config.LoadIntProperty("armor", "material_base_durability", "Base durability for Galaxite Armor\n(this value is multiplied by [11, 16, 15, 13] respectively from boots to helmet)\n", 22);
			armorPoints = Config.LoadIntListProperty("armor", "material_armor_points", "Armor points for Galaxite Armor", new int[] {4, 6, 5, 3});
			enchantability = Config.LoadIntProperty("armor", "material_enchantability", "Enchantability for Galaxite Armor", 9);
			toughness = Config.LoadFloatProperty("armor", "material_toughness", "Toughness for Galaxite Armor", 0f);
			
			voidReducedDamage = Config.LoadFloatProperty("armor", "void_reduced_damage", "How much damage should armor reduce from the void", 50.0f);
			voidDamageArmor = Config.LoadIntProperty("armor", "void_damage_armor", "How much an armor piece will get damaged when taking damage by the void (Only works when void_reduced_damage is more than 0)\n", 1);
			voidDamageArmorChance = Config.LoadFloatProperty("armor", "void_damage_armor_chance", "Percentage chance for an armor piece to damage itself when valid_damage_armor is more than 0", 50.0f);
			
			saveItemsMaxChance = Config.LoadFloatProperty("armor", "save_items_max_chance", "Max Percentage Chance per item stack to be saved when dying into the void", 90.0f);
			saveItemsDamagePerItemSaved = Config.LoadIntProperty("armor", "save_items_damage_per_item", "How much every piece of armor will be damaged per item stack saved from the Void", 2);
		}
	}
	
	public static class OreGeneration{
		public static int orePerVein;
		public static int veinPerChunk;
		public static boolean onlyNearAir;
		public static boolean generateOnMainIsland;
		
		public static void Init() {
			orePerVein = Config.LoadIntProperty("ore_generation", "ore_per_vein", "Ores Generated Per Vein", 2);
			veinPerChunk = Config.LoadIntProperty("ore_generation", "vein_per_chunk", "Veins that try to spawn in a chunk", 1);
			onlyNearAir = Config.LoadBoolProperty("ore_generation", "only_near_air", "Should Veins only generate near Air (so mining will lead no ores)", true);
			generateOnMainIsland = Config.LoadBoolProperty("ore_generation", "generate_on_main_island", "Should Veins generate in the main island (x: 0, z: 0, where the portal is)", true);
		}
	}
}
