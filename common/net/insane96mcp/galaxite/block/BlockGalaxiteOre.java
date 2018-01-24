package net.insane96mcp.galaxite.block;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Names;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class BlockGalaxiteOre extends BlockOre{
	
	public BlockGalaxiteOre() {
		super();
		ResourceLocation location = new ResourceLocation(Galaxite.MOD_ID, Names.GALAXITE_ORE);
		this.setRegistryName(location);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(12.0f);
		this.setResistance(33.3f);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public String getUnlocalizedName() {
		return "tile." + Galaxite.RESOURCE_PREFIX + Names.GALAXITE_ORE;
	}
}
