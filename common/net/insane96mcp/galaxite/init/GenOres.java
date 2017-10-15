package net.insane96mcp.galaxite.init;

import java.util.Random;

import net.insane96mcp.galaxite.lib.CustomWorldGenMinable;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenOres implements IWorldGenerator {

	private final CustomWorldGenMinable worldGenMinable;
	
	public GenOres() {
		worldGenMinable = new CustomWorldGenMinable(ModBlocks.galaxiteOre.getDefaultState(), 8, BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		if ((chunkX < 16 && chunkX > -16) && (chunkZ < 16 && chunkZ > -16))
			return;
		
		BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		int dimension = world.provider.getDimension();

		if (dimension == 1) {
			worldGenMinable.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
		}
	}

	
}
