package Master_Cram.Master_Mod.cave;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;

public class BiggerCaves {

	public static float overallCaveSizeVariance = 4F, overallCaveSizeBase = 2F;

	public static float bigCaveSizeVariance = 2F, bigCaveSizeBase = 1F;

	public static boolean generateHugeCaves = false;
	public static int hugeCaveMaxY = 32, hugeCaveChance = 100;
	public static float hugeCaveSizeVariance = 2F, hugeCaveSizeBase = 1F;

	public void setupConfig() {
		overallCaveSizeVariance = (float) 7;//loadPropDouble("Overall Cave Size Variance", "Vanilla value is 3", 7);
		overallCaveSizeBase = (float) 0;//loadPropDouble("Overall Cave Size Minimum", "Vanilla value is 0", 0);

		bigCaveSizeVariance = (float) 8;//loadPropDouble("Big Cave Size Variance", "Vanilla value is 3", 8);
		bigCaveSizeBase = (float) 1;//loadPropDouble("Big Cave Size Minimum", "Vanilla value is 1", 1);

		generateHugeCaves = true;//loadPropBool("Huge Caves Enabled", "", true);
		hugeCaveMaxY = 32;//loadPropInt("Huge Cave Maximum Y Level", "", 32);
		hugeCaveChance = 1;//loadPropInt("Huge Cave Chance", "Given the value of this config as X, in average, 1 in X caves will be a huge cave", 1800);
		hugeCaveSizeVariance = 6;//(float) loadPropDouble("Huge Cave Size Variance", "", 6);
		hugeCaveSizeBase = (float) 14;//loadPropDouble("Huge Cave Size Minimum", "", 14);
	}

	@SubscribeEvent
	public void getCaveGenerator(InitMapGenEvent event) {
		if(event.type == EventType.CAVE)
			event.newGen = new BigCaveGenerator();
	}

	public boolean hasTerrainSubscriptions() {
		return true;
	}

}