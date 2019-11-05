package Master_Cram.Master_Mod;

import java.util.ArrayList;
import java.util.Random;

import Master_Cram.Master_Mod.cave.BiggerCaves;
import Master_Cram.Master_Mod.clan.ClanManager;
import Master_Cram.Master_Mod.commands.CommandChangeWorld;
import Master_Cram.Master_Mod.commands.CommandsClan;
import Master_Cram.Master_Mod.data.MasterWorldData;
import Master_Cram.Master_Mod.event.EventItemCrafted;
import Master_Cram.Master_Mod.event.EventPlayerLoginLogout;
import Master_Cram.Master_Mod.event.EventWorldSave;
import Master_Cram.Master_Mod.event.MasterEventHandler;
import Master_Cram.Master_Mod.event.OnCreateArmorEvent;
import Master_Cram.Master_Mod.event.OnCreateWeaponEvent;
import Master_Cram.Master_Mod.event.OreGenerationEvent;
import Master_Cram.Master_Mod.event.SkillsEvent;
import Master_Cram.Master_Mod.handler.MasterGuiHandler;
import Master_Cram.Master_Mod.item.ItemManager;
import Master_Cram.Master_Mod.item.MasterFace;
import Master_Cram.Master_Mod.packet.PacketPipeline;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.proxy.CommonProxy;
import Master_Cram.Master_Mod.util.RandomOreGeneration;
import Master_Cram.Master_Mod.world.DimensionHelper;
import Master_Cram.Master_Mod.world.arcana.WorldProviderArcana;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "mm", name = "Master_Mod", version = "1.0")
public class Master_Mod {
	
	public static ItemManager itemManager = new ItemManager();
	public static Item masterFace;
	public static Random random = new Random();
	public static ArrayList<EntityPlayer> PlayerOnline = new ArrayList<EntityPlayer>();
	
	@SidedProxy(clientSide = "Master_Cram.Master_Mod.proxy.ClientProxy", serverSide = "Master_Cram.Master_Mod.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
    public static Master_Mod instance = new Master_Mod();
	
	public static PacketPipeline packetPipeline;
	
	public static ClanManager clanManager;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		masterFace = new MasterFace().setUnlocalizedName("masterFace").setTextureName("mm:masterFace");
		GameRegistry.registerItem(masterFace, "masterFace");
		itemManager.preInit();
		clanManager = new ClanManager();
		packetPipeline = new PacketPipeline();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//if(!event.getSide().isServer())
		packetPipeline.initialize();
		itemManager.addRecipes();
		DimensionHelper.init();
		MinecraftForge.EVENT_BUS.register(new MasterEventHandler());
		//MinecraftForge.EVENT_BUS.register(new EventWorldSave());
		MinecraftForge.EVENT_BUS.register(new SkillsEvent());
		GameRegistry.registerWorldGenerator(new RandomOreGeneration(), 0);
		FMLCommonHandler.instance().bus().register(new OnCreateWeaponEvent());
		FMLCommonHandler.instance().bus().register(new OnCreateArmorEvent());
		FMLCommonHandler.instance().bus().register(new EventPlayerLoginLogout());
		MinecraftForge.TERRAIN_GEN_BUS.register(new BiggerCaves());
		MinecraftForge.ORE_GEN_BUS.register(new OreGenerationEvent());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new MasterGuiHandler());
		
		proxy.registerProxies();
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{

		event.registerServerCommand(new CommandChangeWorld());
		event.registerServerCommand(new CommandsClan());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if(!event.getSide().isServer())
			packetPipeline.postInitialize();
	}
	
	public static CreativeTabs tabMasterMod = new CreativeTabs("tabMasterMod") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(masterFace).getItem();
		}
	};
	
	public static EntityPlayer getPlayerWithName(String name) {
		for(EntityPlayer player : PlayerOnline) {
			if(player.getDisplayName().equalsIgnoreCase(name))
				return player;
		}
		return null;
	}
	
	public static boolean isPlayerInList(EntityPlayer playerToCheck) {
		if(PlayerOnline.isEmpty())
			return false;
		for(EntityPlayer player : PlayerOnline) {
			if(player != null) {
				//if(player.getDisplayName().equalsIgnoreCase(playerToCheck.getDisplayName()))
					//return true;
			}
		}
		return false;
	}
	
	public static void addPlayerToOnlineList(EntityPlayer playerToAdd) {
		if(!isPlayerInList(playerToAdd)) {
			PlayerOnline.add(playerToAdd);
		}
	}
	
	public static void removePlayerFromOnlineList(EntityPlayer playerToRemove) {
		if(isPlayerInList(playerToRemove)) {
			PlayerOnline.remove(playerToRemove);
		}
	}
	
}
