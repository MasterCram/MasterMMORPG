package Master_Cram.Master_Mod.util;

import java.util.Random;

import Master_Cram.Master_Mod.Master_Mod;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class RandomOreGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 2:
			generateTier1(world, random, chunkX, chunkZ);
			break;
		case 3:
			generateTier2(world, random, chunkX, chunkZ);
			break;
		case 4:
			generateTier3(world, random, chunkX, chunkZ);
			break;
		case 5:
			generateTier4(world, random, chunkX, chunkZ);
			break;
		case 6:
			generateTier5(world, random, chunkX, chunkZ);
			break;
			
		}
		
	}
	
	private void generateTier1(World world, Random rand, int x, int z) {
		generateOre(Blocks.iron_ore, world, rand, x, z, 1, 8, 100, 50, 5, 100, Blocks.stone);
	}
	
	private void generateTier2(World world, Random rand, int x, int z) {
		generateOre(Blocks.iron_ore, world, rand, x, z, 1, 8, 100, 50, 5, 100, Blocks.stone);
		generateOre(Master_Mod.itemManager.blockList.get("silverOre"), world, rand, x, z, 1, 8, 100, 10, 5, 50, Blocks.stone);
	}
	
	private void generateTier3(World world, Random rand, int x, int z) {
		generateOre(Blocks.iron_ore, world, rand, x, z, 1, 8, 100, 50, 5, 100, Blocks.stone);
		generateOre(Master_Mod.itemManager.blockList.get("silverOre"), world, rand, x, z, 1, 8, 100, 10, 5, 50, Blocks.stone);
		generateOre(Blocks.diamond_ore, world, rand, x, z, 1, 4, 100, 1, 10, 50, Blocks.stone);
	}
	
	private void generateTier4(World world, Random rand, int x, int z) {
		generateOre(Blocks.iron_ore, world, rand, x, z, 1, 8, 100, 50, 5, 100, Blocks.stone);
		generateOre(Master_Mod.itemManager.blockList.get("silverOre"), world, rand, x, z, 1, 8, 100, 10, 5, 50, Blocks.stone);
		generateOre(Blocks.diamond_ore, world, rand, x, z, 1, 4, 100, 1, 10, 50, Blocks.stone);
		generateOre(Master_Mod.itemManager.blockList.get("ramestOre"), world, rand, x, z, 1, 1, 25, 1, 5, 50, Blocks.stone);
	}
	
	private void generateTier5(World world, Random rand, int x, int z) {
		generateOre(Blocks.iron_ore, world, rand, x, z, 1, 8, 100, 50, 5, 100, Blocks.stone);
		generateOre(Master_Mod.itemManager.blockList.get("silverOre"), world, rand, x, z, 1, 8, 100, 10, 5, 50, Blocks.stone);
		generateOre(Blocks.diamond_ore, world, rand, x, z, 1, 4, 100, 1, 10, 50, Blocks.stone);
		generateOre(Master_Mod.itemManager.blockList.get("ramestOre"), world, rand, x, z, 1, 1, 25, 1, 5, 50, Blocks.stone);
		generateOre(Master_Mod.itemManager.blockList.get("emrastOre"), world, rand, x, z, 1, 1, 1, 1, 1, 50, Blocks.stone);
	}

	public void generateNether(World world, Random rand, int x, int z) {
		
	}
	
	public void generateOverworld(World world, Random rand, int x, int z) {
		//generateOre(Master_Mod.itemManager.blockList.get("silverOre"), world, rand, x, z, 2, 8, 20, 0, 100, Blocks.stone);
		//generateOre(Master_Mod.itemManager.blockList.get("ramestOre"), world, rand, x, z, 2, 8, 20, 0, 100, Blocks.stone);
		//generateOre(Master_Mod.itemManager.blockList.get("emrastOre"), world, rand, x, z, 2, 8, 20, 0, 100, Blocks.stone);
		//generateOre(Master_Mod.itemManager.blockList.get("tresamOre"), world, rand, x, z, 2, 8, 20, 0, 100, Blocks.stone);
		//generateOre(Master_Mod.itemManager.blockList.get("sarmetOre"), world, rand, x, z, 2, 8, 20, 0, 100, Blocks.stone);
		//generateOre(Master_Mod.itemManager.blockList.get("astremOre"), world, rand, x, z, 2, 8, 20, 0, 100, Blocks.stone);
		//generateOre(Master_Mod.itemManager.blockList.get("mertasOre"), world, rand, x, z, 2, 8, 20, 0, 100, Blocks.stone);
	}
	
	public void generateEnd(World world, Random rand, int x, int z) {
	
	}
	
	public void generateOre(Block block, World world, Random random, int chunkX, 
			int chunkZ, int minVeinSize, int maxVeinSize, int chance, int nbPerChunk, int minY, 
			int maxY, Block generateIn) {
		int randomNumber = random.nextInt(100) + 1;
		if(randomNumber <= chance)
		{
			int veinSize= minVeinSize + random.nextInt(maxVeinSize);
			int heightRange = maxY - minY;
			WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
			for(int i = 0; i < nbPerChunk; i++) {
				int xRand = chunkX*16+random.nextInt(16);
				int yRand = random.nextInt(heightRange) + minY;
				int zRand = chunkZ*16+random.nextInt(16);
				gen.generate(world, random, xRand, yRand, zRand);
			}
		}
		
	}

}