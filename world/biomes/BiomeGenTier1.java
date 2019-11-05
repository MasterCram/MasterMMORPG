package Master_Cram.Master_Mod.world.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenTier1 extends BiomeGenBase {
	
    public BiomeGenTier1(int id) {
        super(id);
        this.setBiomeName("Tier1");
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.topBlock = (Block)null;
        this.fillerBlock = (Block)null;
        this.waterColorMultiplier = 0xE42D17; //2368548;
    }
}