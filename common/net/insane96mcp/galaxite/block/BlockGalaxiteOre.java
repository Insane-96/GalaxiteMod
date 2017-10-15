package net.insane96mcp.galaxite.block;

import java.util.Random;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.init.ModItems;
import net.insane96mcp.galaxite.lib.Names;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGalaxiteOre extends BlockOre{
	
	public BlockGalaxiteOre() {
		super();
	}
	
	@Override
	public String getUnlocalizedName() {
		return "tile." + Galaxite.RESOURCE_PREFIX + Names.GALAXITE_ORE;
	}
}
