package net.insane96mcp.galaxite.events;

import java.util.Random;

import net.insane96mcp.galaxite.Galaxite;
import net.insane96mcp.galaxite.lib.Properties;
import net.insane96mcp.galaxite.worldgen.OreGenerator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Galaxite.MOD_ID)
public class LivingUpdate {
	@SubscribeEvent
	public static void EventLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntityLiving().getEntityWorld().isRemote)
			return;
		
		if (!Properties.config.oreGeneration.mainIsland.generateOnDragonDeath)
			return;
		
		EntityLivingBase entity = event.getEntityLiving();
		
		if (!(entity instanceof EntityDragon))
			return;
		
		EntityDragon dragon = (EntityDragon)entity;
		if (dragon.getFightManager() == null)
			return;
		
		boolean isFirstDragon = !dragon.getFightManager().hasPreviouslyKilledDragon();
		
		if (!dragon.getPhaseManager().getCurrentPhase().getType().equals(PhaseList.DYING))
			return;
		
		if (dragon.deathTicks > 0) {
			
			if (isFirstDragon && dragon.deathTicks % Properties.config.oreGeneration.mainIsland.dragonDeathTick == 0) {
				World world = dragon.getEntityWorld();
				Random random = world.rand;
				
				BlockPos pos = new BlockPos(-160, 24, -160);

				for (int i = 0; i < Properties.config.oreGeneration.mainIsland.veinPerTick; i++) {
					BlockPos randomPos = pos.add(random.nextInt(320), random.nextInt(48), random.nextInt(320));
					OreGenerator.mainIslandGenerator.generate(world, random, randomPos);
				}
			}
		}
	}
}
