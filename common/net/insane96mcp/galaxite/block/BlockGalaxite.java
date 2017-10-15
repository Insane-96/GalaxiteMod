package net.insane96mcp.galaxite.block;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGalaxite extends Block{

	public BlockGalaxite() {
		super(Material.IRON);
	}
	
	
	@Override
	public String getUnlocalizedName() {
		return "tile." + Galaxite.RESOURCE_PREFIX + Names.GALAXITE_BLOCK;
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
