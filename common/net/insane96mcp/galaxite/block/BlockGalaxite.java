package net.insane96mcp.galaxite.block;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Stings.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGalaxite extends Block{

	public BlockGalaxite() {
		super(Material.IRON);
		ResourceLocation location = new ResourceLocation(Galaxite.MOD_ID, Names.GALAXITE_BLOCK);
		this.setRegistryName(location);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(15.0f);
		this.setResistance(10.0f);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	
	@Override
	public String getTranslationKey() {
		return "tile." + Galaxite.RESOURCE_PREFIX + Names.GALAXITE_BLOCK;
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
