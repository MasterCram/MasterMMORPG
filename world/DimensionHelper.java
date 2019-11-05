package Master_Cram.Master_Mod.world;

import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.world.arcana.WorldProviderArcana;
import Master_Cram.Master_Mod.world.biomes.BiomeGenArcana;
import Master_Cram.Master_Mod.world.tier1.WorldProviderTier1;
import Master_Cram.Master_Mod.world.tier2.WorldProviderTier2;
import Master_Cram.Master_Mod.world.tier3.WorldProviderTier3;
import Master_Cram.Master_Mod.world.tier4.WorldProviderTier4;
import Master_Cram.Master_Mod.world.tier5.WorldProviderTier5;
import Master_Cram.Master_Mod.world.voidworld.WorldProviderVoidWorld;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class DimensionHelper {

	//protected static final BiomeGenBase.Height iceikaHeight = new BiomeGenBase.Height(0.0F, 0.7F); 
	//protected static final BiomeGenBase.Height vetheaHeight = new BiomeGenBase.Height(-1.0F, 0.0F);
	
	//public static BiomeGenBase Eden 		= new BiomeGenEden(ConfigurationHelper.edenBiome);
	//public static BiomeGenBase WildWoods 	= new BiomeGenWildWoods(ConfigurationHelper.wildwoodBiome);
	//public static BiomeGenBase Apalachia 	= new BiomeGenApalachia(ConfigurationHelper.apalachiaBiome);
	//public static BiomeGenBase Skythern 	= new BiomeGenSkythern(ConfigurationHelper.skythernBiome);
	//public static BiomeGenBase Mortum 		= new BiomeGenMortum(ConfigurationHelper.mortumBiome);
	//public static BiomeGenBase Iceika 		= new BiomeGenIceika(ConfigurationHelper.iceikaBiome).setHeight(iceikaHeight);
	//public static BiomeGenBase Vethea 		= new BiomeGenVethea(ConfigurationHelper.vetheaBiome).setHeight(vetheaHeight);
	//public static BiomeGenBase Arcana 		= new BiomeGenArcana(46);

	public static void init(){
	    //LogHelper.info("Adding dimensions");
		//addDimension(ConfigurationHelper.eden, WorldProviderEden.class, ConfigurationHelper.keepLoadingEden);
		//addDimension(ConfigurationHelper.wildwood, WorldProviderWildWoods.class, ConfigurationHelper.keepLoadingWildwood);
		addDimension(References.ARCANA_DIM, WorldProviderArcana.class, true);
		addDimension(References.TIER1_DIM, WorldProviderTier1.class, true);
		addDimension(References.TIER2_DIM, WorldProviderTier2.class, true);
		addDimension(References.TIER3_DIM, WorldProviderTier3.class, true);
		addDimension(References.TIER4_DIM, WorldProviderTier4.class, true);
		addDimension(References.TIER5_DIM, WorldProviderTier5.class, true);
		addDimension(References.VOID_WORLD, WorldProviderVoidWorld.class, true);
		//addDimension(ConfigurationHelper.iceika, WorldProviderIceika.class, ConfigurationHelper.keepLoadingIceika);
		//addDimension(ConfigurationHelper.vethea, WorldProviderVethea.class, ConfigurationHelper.keepLoadingVethea);
		//addDimension(ConfigurationHelper.apalachia, WorldProviderApalachia.class, ConfigurationHelper.keepLoadingApalachia);
		//addDimension(ConfigurationHelper.skythern, WorldProviderSkythern.class, ConfigurationHelper.keepLoadingSkythern);
		//addDimension(ConfigurationHelper.mortum, WorldProviderMortum.class, ConfigurationHelper.keepLoadingMortum);
	}

	private static void addDimension(int id, Class<? extends WorldProvider> w, boolean keeploading){
	    //LogHelper.info("Registering dimension ID: " + id);
		DimensionManager.registerProviderType(id, w, keeploading);
		DimensionManager.registerDimension(id, id);
	}

}