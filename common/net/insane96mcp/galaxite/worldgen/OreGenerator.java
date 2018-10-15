package net.insane96mcp.galaxite.worldgen;

import java.util.Random;

import net.insane96mcp.galaxite.init.ModBlocks;
import net.insane96mcp.galaxite.lib.Properties;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	public static GalaxiteGenerator generator;
	public static GalaxiteGenerator mainIslandGenerator;
	
	public OreGenerator() {
		generator = new GalaxiteGenerator(ModBlocks.galaxiteOre.getDefaultState(), Properties.OreGeneration.OuterIslands.orePerVein, BlockMatcher.forBlock(Blocks.END_STONE));
		mainIslandGenerator = new GalaxiteGenerator(ModBlocks.galaxiteOre.getDefaultState(), Properties.OreGeneration.MainIsland.orePerVein, BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		boolean isEnd = world.provider instanceof WorldProviderEnd;
	
		if (!isEnd)
			return;
		
		if ((chunkX < 16 && chunkX > -16) && (chunkZ < 16 && chunkZ > -16))
			return;

		BlockPos chunkPos = new BlockPos(chunkX * 16, 32, chunkZ * 16);

		int dimension = world.provider.getDimension();

		for (int i = 0; i < Properties.OreGeneration.OuterIslands.veinPerChunk; i++) {
			generator.generate(world, random, chunkPos.add(random.nextInt(12) + 2, random.nextInt(64), random.nextInt(12) + 2));
		}
	}	
}
