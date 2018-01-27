package net.insane96mcp.galaxite.worldgen;

import java.util.Random;

import net.insane96mcp.galaxite.init.ModBlocks;
import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	private final CustomOreGenenerator worldGenMinable;
	
	public OreGenerator() {
		worldGenMinable = new CustomOreGenenerator(ModBlocks.galaxiteOre.getDefaultState(), Properties.OreGeneration.orePerVein, BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if ((chunkX < 16 && chunkX > -16) && (chunkZ < 16 && chunkZ > -16) && !Properties.OreGeneration.generateOnMainIsland)
			return;
		
		BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		int dimension = world.provider.getDimension();

		for (int i = 0; i < Properties.OreGeneration.veinPerChunk; i++) {
			if (dimension == 1) {
				worldGenMinable.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(128), random.nextInt(16)));
			}
		}
		
	}	
}
