package Master_Cram.Master_Mod.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.block.GoldOre;
import Master_Cram.Master_Mod.block.IronOre;
import Master_Cram.Master_Mod.block.NewBlock;
import Master_Cram.Master_Mod.block.portal.DiamondPortalBlock;
import Master_Cram.Master_Mod.block.portal.DiamondPortalFrame;
import Master_Cram.Master_Mod.block.portal.EmrastPortalBlock;
import Master_Cram.Master_Mod.block.portal.EmrastPortalFrame;
import Master_Cram.Master_Mod.block.portal.IronPortalBlock;
import Master_Cram.Master_Mod.block.portal.IronPortalFrame;
import Master_Cram.Master_Mod.block.portal.RamestPortalBlock;
import Master_Cram.Master_Mod.block.portal.RamestPortalFrame;
import Master_Cram.Master_Mod.block.portal.SilverPortalBlock;
import Master_Cram.Master_Mod.block.portal.SilverPortalFrame;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemManager {
	
	public static Map<String, NewIcon> iconList = new HashMap<String, NewIcon>();
	
	public static Map<String, Item> itemList = new HashMap<String, Item>();
	
	public static Map<String, NewRing> ringList = new HashMap<String, NewRing>();
	
	public static Map<String, NewAmulet> amuletList = new HashMap<String, NewAmulet>();
	
	public static Map<String, NewBackpack> backpackList = new HashMap<String, NewBackpack>();
	
	public static Map<String, Block> blockList = new HashMap<String, Block>();
	
	public static Map<String, Item> toolList = new HashMap<String, Item>();
	
	public static Map<String, Item> armorList = new HashMap<String, Item>();
	
	public static IronPortalBlock ironPortal;
	public static SilverPortalBlock silverPortal;
	public static DiamondPortalBlock diamondPortal;
	public static RamestPortalBlock ramestPortal;
	public static EmrastPortalBlock emrastPortal;
	
	public static IronPortalFrame ironPortalFrame;
	public static SilverPortalFrame silverPortalFrame;
	public static DiamondPortalFrame diamondPortalFrame;
	public static RamestPortalFrame ramestPortalFrame;
	public static EmrastPortalFrame emrastPortalFrame;
	
	public String[] materialList = new String[] {"iron", "silver", "diamond", "ramest", "emrast"};
	
	public ItemManager() {
	}
	
	public void preInit() {
		
		
		this.createBackpack("backpack");
		
		
		this.createIcon("emptyAmuletIcon");
		this.createIcon("emptyRingIcon");
		this.createIcon("emptyBackpackIcon");
		this.createIcon("emptyLockIcon");

		this.createItem("iron2");
		this.createItem("iron3");
		this.createItem("iron4");
		this.createItem("iron5");
		this.createItem("iron6");
		
		this.createItem("silver");
		this.createItem("silver2");
		this.createItem("silver3");
		this.createItem("silver4");
		this.createItem("silver5");
		this.createItem("silver6");
		
		this.createItem("gold2");
		this.createItem("gold3");
		this.createItem("gold4");
		this.createItem("gold5");
		this.createItem("gold6");
		
		this.createItem("diamond2");
		this.createItem("diamond3");
		this.createItem("diamond4");
		this.createItem("diamond5");
		this.createItem("diamond6");
		
		this.createItem("ramest");
		this.createItem("ramest2");
		this.createItem("ramest3");
		this.createItem("ramest4");
		this.createItem("ramest5");
		this.createItem("ramest6");
		
		this.createItem("emrast");
		this.createItem("emrast2");
		this.createItem("emrast3");
		this.createItem("emrast4");
		this.createItem("emrast5");
		this.createItem("emrast6");
		
		this.createItem("tresam");
		this.createItem("tresam2");
		this.createItem("tresam3");
		this.createItem("tresam4");
		this.createItem("tresam5");
		this.createItem("tresam6");
		
		this.createItem("sarmet");
		this.createItem("sarmet2");
		this.createItem("sarmet3");
		this.createItem("sarmet4");
		this.createItem("sarmet5");
		this.createItem("sarmet6");
		
		this.createItem("astrem");
		this.createItem("astrem2");
		this.createItem("astrem3");
		this.createItem("astrem4");
		this.createItem("astrem5");
		this.createItem("astrem6");
		
		this.createItem("mertas");
		this.createItem("mertas2");
		this.createItem("mertas3");
		this.createItem("mertas4");
		this.createItem("mertas5");
		this.createItem("mertas6");
		
		this.createItem("master");
		this.createItem("master2");
		this.createItem("master3");
		this.createItem("master4");
		this.createItem("master5");
		this.createItem("master6");
		
		this.createBlock("ironOre2", Material.rock);
		this.createBlock("ironOre3", Material.rock);
		this.createBlock("ironOre4", Material.rock);
		this.createBlock("ironOre5", Material.rock);
		this.createBlock("ironOre6", Material.rock);
		
		this.createBlock("silverOre", Material.rock);
		this.createBlock("silverOre2", Material.rock);
		this.createBlock("silverOre3", Material.rock);
		this.createBlock("silverOre4", Material.rock);
		this.createBlock("silverOre5", Material.rock);
		this.createBlock("silverOre6", Material.rock);
		
		this.createBlock("goldOre2", Material.rock);
		this.createBlock("goldOre3", Material.rock);
		this.createBlock("goldOre4", Material.rock);
		this.createBlock("goldOre5", Material.rock);
		this.createBlock("goldOre6", Material.rock);
		
		this.createBlock("diamondOre2", Material.rock);
		this.createBlock("diamondOre3", Material.rock);
		this.createBlock("diamondOre4", Material.rock);
		this.createBlock("diamondOre5", Material.rock);
		this.createBlock("diamondOre6", Material.rock);
		
		this.createBlock("ramestOre", Material.rock);
		this.createBlock("ramestOre2", Material.rock);
		this.createBlock("ramestOre3", Material.rock);
		this.createBlock("ramestOre4", Material.rock);
		this.createBlock("ramestOre5", Material.rock);
		this.createBlock("ramestOre6", Material.rock);
		
		this.createBlock("emrastOre", Material.rock);
		this.createBlock("emrastOre2", Material.rock);
		this.createBlock("emrastOre3", Material.rock);
		this.createBlock("emrastOre4", Material.rock);
		this.createBlock("emrastOre5", Material.rock);
		this.createBlock("emrastOre6", Material.rock);
		
		this.createBlock("tresamOre", Material.rock);
		this.createBlock("tresamOre2", Material.rock);
		this.createBlock("tresamOre3", Material.rock);
		this.createBlock("tresamOre4", Material.rock);
		this.createBlock("tresamOre5", Material.rock);
		this.createBlock("tresamOre6", Material.rock);
		
		this.createBlock("sarmetOre", Material.rock);
		this.createBlock("sarmetOre2", Material.rock);
		this.createBlock("sarmetOre3", Material.rock);
		this.createBlock("sarmetOre4", Material.rock);
		this.createBlock("sarmetOre5", Material.rock);
		this.createBlock("sarmetOre6", Material.rock);
		
		this.createBlock("astremOre", Material.rock);
		this.createBlock("astremOre2", Material.rock);
		this.createBlock("astremOre3", Material.rock);
		this.createBlock("astremOre4", Material.rock);
		this.createBlock("astremOre5", Material.rock);
		this.createBlock("astremOre6", Material.rock);
		
		this.createBlock("mertasOre", Material.rock);
		this.createBlock("mertasOre2", Material.rock);
		this.createBlock("mertasOre3", Material.rock);
		this.createBlock("mertasOre4", Material.rock);
		this.createBlock("mertasOre5", Material.rock);
		this.createBlock("mertasOre6", Material.rock);
		
		this.createBlock("masterOre", Material.rock);
		this.createBlock("masterOre2", Material.rock);
		this.createBlock("masterOre3", Material.rock);
		this.createBlock("masterOre4", Material.rock);
		this.createBlock("masterOre5", Material.rock);
		this.createBlock("masterOre6", Material.rock);
		

		
		for(int i = 2; i <= 6; i++) {
			for(int j = 0; j < materialList.length; j++)
			{
				this.createTool(materialList[j] + "Sword" + Integer.toString(i), "Sword", 2 + j, (j*251) + 251, 5.0F + j, 2.0F + j, 10 + j);
				this.createTool(materialList[j] + "Pickaxe" + Integer.toString(i), "Pickaxe", 2 + j, (j*251) + 251, 5.0F + j, 2.0F + j, 10 + j);
				this.createTool(materialList[j] + "Axe" + Integer.toString(i), "Axe", 2 + j, (j*251) + 251, 5.0F + j, 2.0F + j, 10 + j);
				this.createTool(materialList[j] + "Shovel" + Integer.toString(i), "Shovel", 2 + j, (j*251) + 251, 5.0F + j, 2.0F + j, 10 + j);
				this.createTool(materialList[j] + "Hoe" + Integer.toString(i), "Pickaxe", 2 + j, (j*251) + 251, 5.0F + j, 2.0F + j, 10 + j);
			
				this.createArmor(materialList[j], materialList[j] + "Helmet" + Integer.toString(i), "Helmet", (j*251) + 251, new int[] {2 + j,6 + j,5 + j,2 + j}, 10 + j);
				this.createArmor(materialList[j], materialList[j] + "Chestplate" + Integer.toString(i), "Chestplate", (j*251) + 251, new int[] {2 + j,6 + j,5 + j,2 + j}, 10 + j);
				this.createArmor(materialList[j], materialList[j] + "Leggings" + Integer.toString(i), "Leggings", (j*251) + 251, new int[] {2 + j,6 + j,5 + j,2 + j}, 10 + j);
				this.createArmor(materialList[j], materialList[j] + "Boots" + Integer.toString(i), "Boots", (j*251) + 251, new int[] {2 + j,6 + j,5 + j,2 + j}, 10 + j);
			}
		}
		
		ironPortal = new IronPortalBlock("ironPortal");
		GameRegistry.registerBlock(ironPortal, "ironPortal");
		
		silverPortal = new SilverPortalBlock("silverPortal");
		GameRegistry.registerBlock(silverPortal, "silverPortal");
		
		diamondPortal = new DiamondPortalBlock("diamondPortal");
		GameRegistry.registerBlock(diamondPortal, "diamondPortal");
		
		ramestPortal = new RamestPortalBlock("ramestPortal");
		GameRegistry.registerBlock(ramestPortal, "ramestPortal");
		
		emrastPortal = new EmrastPortalBlock("emrastPortal");
		GameRegistry.registerBlock(emrastPortal, "emrastPortal");
		
		ironPortalFrame = new IronPortalFrame(Material.rock);
		ironPortalFrame.setBlockName("ironPortalFrame").setBlockTextureName(("mm:ironPortalFrame")).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerBlock(ironPortalFrame, "ironPortalFrame");
		
		silverPortalFrame = new SilverPortalFrame(Material.rock);
		silverPortalFrame.setBlockName("silverPortalFrame").setBlockTextureName(("mm:silverPortalFrame")).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerBlock(silverPortalFrame, "silverPortalFrame");
		
		diamondPortalFrame = new DiamondPortalFrame(Material.rock);
		diamondPortalFrame.setBlockName("diamondPortalFrame").setBlockTextureName(("mm:diamondPortalFrame")).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerBlock(diamondPortalFrame, "diamondPortalFrame");
		
		ramestPortalFrame = new RamestPortalFrame(Material.rock);
		ramestPortalFrame.setBlockName("ramestPortalFrame").setBlockTextureName(("mm:ramestPortalFrame")).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerBlock(ramestPortalFrame, "ramestPortalFrame");
		
		emrastPortalFrame = new EmrastPortalFrame(Material.rock);
		emrastPortalFrame.setBlockName("emrastPortalFrame").setBlockTextureName(("mm:emrastPortalFrame")).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerBlock(emrastPortalFrame, "emrastPortalFrame");
		
		for(int i=1;i<=4;i++) {
			this.createItem("ironPortal" + Integer.toString(i));
			this.createItem("silverPortal" + Integer.toString(i));
			this.createItem("diamondPortal" + Integer.toString(i));
			this.createItem("ramestPortal" + Integer.toString(i));
			this.createItem("emrastPortal" + Integer.toString(i));
		}
		
		this.createRing("ringTest");
		this.createAmulet("amuletTest");
		
	}
	
	public void addRecipes() {
		for(int i = 2; i <= 6; i++) {
			for(int j = 0; j < materialList.length; j++) {
				this.addCraftingRecipe(Master_Mod.itemManager.toolList.get(materialList[j] + "Sword" + Integer.toString(i)), "Sword", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.toolList.get(materialList[j] + "Pickaxe" + Integer.toString(i)), "Pickaxe", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.toolList.get(materialList[j] + "Axe" + Integer.toString(i)), "Axe", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.toolList.get(materialList[j] + "Shovel" + Integer.toString(i)), "Shovel", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.toolList.get(materialList[j] + "Hoe" + Integer.toString(i)), "Hoe", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.armorList.get(materialList[j] + "Helmet" + Integer.toString(i)), "Helmet", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.armorList.get(materialList[j] + "Chestplate" + Integer.toString(i)), "Chestplate", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.armorList.get(materialList[j] + "Leggings" + Integer.toString(i)), "Leggings", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
				this.addCraftingRecipe(Master_Mod.itemManager.armorList.get(materialList[j] + "Boots" + Integer.toString(i)), "Boots", Master_Mod.itemManager.itemList.get(materialList[j] + Integer.toString(i)));
			}
		}
		GameRegistry.addRecipe(new ItemStack(Master_Mod.itemManager.ironPortalFrame), 
				new Object[]{" b ","a c"," d ", 
						'a', Master_Mod.itemManager.itemList.get("ironPortal1"),
						'b', Master_Mod.itemManager.itemList.get("ironPortal2"), 
						'c', Master_Mod.itemManager.itemList.get("ironPortal3"),
						'd', Master_Mod.itemManager.itemList.get("ironPortal4")});
		
			GameRegistry.addRecipe(new ItemStack(Master_Mod.itemManager.silverPortalFrame), 
					new Object[]{"ebf","aic","gdh", 
							'a', Master_Mod.itemManager.itemList.get("silverPortal1"),
							'b', Master_Mod.itemManager.itemList.get("silverPortal2"), 
							'c', Master_Mod.itemManager.itemList.get("silverPortal3"),
							'd', Master_Mod.itemManager.itemList.get("silverPortal4"),
							'e', Master_Mod.itemManager.itemList.get("iron2"),
							'f', Master_Mod.itemManager.itemList.get("iron3"),
							'g', Master_Mod.itemManager.itemList.get("iron4"),
							'h', Master_Mod.itemManager.itemList.get("iron5"),
							'i', Master_Mod.itemManager.itemList.get("iron6")});
			
			GameRegistry.addRecipe(new ItemStack(Master_Mod.itemManager.diamondPortalFrame), 
					new Object[]{"ebf","aic","gdh", 
							'a', Master_Mod.itemManager.itemList.get("diamondPortal1"),
							'b', Master_Mod.itemManager.itemList.get("diamondPortal2"), 
							'c', Master_Mod.itemManager.itemList.get("diamondPortal3"),
							'd', Master_Mod.itemManager.itemList.get("diamondPortal4"),
							'e', Master_Mod.itemManager.itemList.get("silver2"),
							'f', Master_Mod.itemManager.itemList.get("silver3"),
							'g', Master_Mod.itemManager.itemList.get("silver4"),
							'h', Master_Mod.itemManager.itemList.get("silver5"),
							'i', Master_Mod.itemManager.itemList.get("silver6")});
			
			GameRegistry.addRecipe(new ItemStack(Master_Mod.itemManager.ramestPortalFrame), 
					new Object[]{"ebf","aic","gdh", 
							'a', Master_Mod.itemManager.itemList.get("ramestPortal1"),
							'b', Master_Mod.itemManager.itemList.get("ramestPortal2"), 
							'c', Master_Mod.itemManager.itemList.get("ramestPortal3"),
							'd', Master_Mod.itemManager.itemList.get("ramestPortal4"),
							'e', Master_Mod.itemManager.itemList.get("diamond2"),
							'f', Master_Mod.itemManager.itemList.get("diamond3"),
							'g', Master_Mod.itemManager.itemList.get("diamond4"),
							'h', Master_Mod.itemManager.itemList.get("diamond5"),
							'i', Master_Mod.itemManager.itemList.get("diamond6")});
			
			GameRegistry.addRecipe(new ItemStack(Master_Mod.itemManager.emrastPortalFrame), 
					new Object[]{"ebf","aic","gdh", 
							'a', Master_Mod.itemManager.itemList.get("emrastPortal1"),
							'b', Master_Mod.itemManager.itemList.get("emrastPortal2"), 
							'c', Master_Mod.itemManager.itemList.get("emrastPortal3"),
							'd', Master_Mod.itemManager.itemList.get("emrastPortal4"),
							'e', Master_Mod.itemManager.itemList.get("ramest2"),
							'f', Master_Mod.itemManager.itemList.get("ramest3"),
							'g', Master_Mod.itemManager.itemList.get("ramest4"),
							'h', Master_Mod.itemManager.itemList.get("ramest5"),
							'i', Master_Mod.itemManager.itemList.get("ramest6")});
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ironOre2"), Master_Mod.itemManager.itemList.get("iron2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ironOre3"), Master_Mod.itemManager.itemList.get("iron3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ironOre4"), Master_Mod.itemManager.itemList.get("iron4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ironOre5"), Master_Mod.itemManager.itemList.get("iron5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ironOre6"), Master_Mod.itemManager.itemList.get("iron6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("silverOre"), Master_Mod.itemManager.itemList.get("silver"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("silverOre2"), Master_Mod.itemManager.itemList.get("silver2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("silverOre3"), Master_Mod.itemManager.itemList.get("silver3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("silverOre4"), Master_Mod.itemManager.itemList.get("silver4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("silverOre5"), Master_Mod.itemManager.itemList.get("silver5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("silverOre6"), Master_Mod.itemManager.itemList.get("silver6"));

		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("goldOre2"), Master_Mod.itemManager.itemList.get("gold2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("goldOre3"), Master_Mod.itemManager.itemList.get("gold3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("goldOre4"), Master_Mod.itemManager.itemList.get("gold4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("goldOre5"), Master_Mod.itemManager.itemList.get("gold5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("goldOre6"), Master_Mod.itemManager.itemList.get("gold6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("diamondOre2"), Master_Mod.itemManager.itemList.get("diamond2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("diamondOre3"), Master_Mod.itemManager.itemList.get("diamond3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("diamondOre4"), Master_Mod.itemManager.itemList.get("diamond4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("diamondOre5"), Master_Mod.itemManager.itemList.get("diamond5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("diamondOre6"), Master_Mod.itemManager.itemList.get("diamond6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ramestOre"), Master_Mod.itemManager.itemList.get("ramest"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ramestOre2"), Master_Mod.itemManager.itemList.get("ramest2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ramestOre3"), Master_Mod.itemManager.itemList.get("ramest3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ramestOre4"), Master_Mod.itemManager.itemList.get("ramest4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ramestOre5"), Master_Mod.itemManager.itemList.get("ramest5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("ramestOre6"), Master_Mod.itemManager.itemList.get("ramest6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("emrastOre"), Master_Mod.itemManager.itemList.get("emrast"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("emrastOre2"), Master_Mod.itemManager.itemList.get("emrast2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("emrastOre3"), Master_Mod.itemManager.itemList.get("emrast3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("emrastOre4"), Master_Mod.itemManager.itemList.get("emrast4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("emrastOre5"), Master_Mod.itemManager.itemList.get("emrast5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("emrastOre6"), Master_Mod.itemManager.itemList.get("emrast6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("tresamOre"), Master_Mod.itemManager.itemList.get("tresam"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("tresamOre2"), Master_Mod.itemManager.itemList.get("tresam2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("tresamOre3"), Master_Mod.itemManager.itemList.get("tresam3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("tresamOre4"), Master_Mod.itemManager.itemList.get("tresam4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("tresamOre5"), Master_Mod.itemManager.itemList.get("tresam5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("tresamOre6"), Master_Mod.itemManager.itemList.get("tresam6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("sarmetOre"), Master_Mod.itemManager.itemList.get("sarmet"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("sarmetOre2"), Master_Mod.itemManager.itemList.get("sarmet2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("sarmetOre3"), Master_Mod.itemManager.itemList.get("sarmet3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("sarmetOre4"), Master_Mod.itemManager.itemList.get("sarmet4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("sarmetOre5"), Master_Mod.itemManager.itemList.get("sarmet5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("sarmetOre6"), Master_Mod.itemManager.itemList.get("sarmet6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("astremOre"), Master_Mod.itemManager.itemList.get("astrem"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("astremOre2"), Master_Mod.itemManager.itemList.get("astrem2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("astremOre3"), Master_Mod.itemManager.itemList.get("astrem3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("astremOre4"), Master_Mod.itemManager.itemList.get("astrem4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("astremOre5"), Master_Mod.itemManager.itemList.get("astrem5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("astremOre6"), Master_Mod.itemManager.itemList.get("astrem6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("mertasOre"), Master_Mod.itemManager.itemList.get("mertas"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("mertasOre2"), Master_Mod.itemManager.itemList.get("mertas2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("mertasOre3"), Master_Mod.itemManager.itemList.get("mertas3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("mertasOre4"), Master_Mod.itemManager.itemList.get("mertas4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("mertasOre5"), Master_Mod.itemManager.itemList.get("mertas5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("mertasOre6"), Master_Mod.itemManager.itemList.get("mertas6"));
		
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("masterOre"), Master_Mod.itemManager.itemList.get("master"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("masterOre2"), Master_Mod.itemManager.itemList.get("master2"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("masterOre3"), Master_Mod.itemManager.itemList.get("master3"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("masterOre4"), Master_Mod.itemManager.itemList.get("master4"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("masterOre5"), Master_Mod.itemManager.itemList.get("master5"));
		this.addSmeltingRecipe(Master_Mod.itemManager.blockList.get("masterOre6"), Master_Mod.itemManager.itemList.get("master6"));
	}
	
	public void createItem(String itemName) {
		itemList.put(itemName, new Item().setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		itemList.get(itemName).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerItem(itemList.get(itemName), itemName);
	}
	
	public void createAmulet(String itemName) {
		amuletList.put(itemName, (NewAmulet) new NewAmulet().setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		amuletList.get(itemName).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerItem(amuletList.get(itemName), itemName);
	}
	
	public void createIcon(String itemName) {
		iconList.put(itemName, (NewIcon) new NewIcon().setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		GameRegistry.registerItem(iconList.get(itemName), itemName);
	}
	
	public void createRing(String itemName) {
		ringList.put(itemName, (NewRing) new NewRing().setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		ringList.get(itemName).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerItem(ringList.get(itemName), itemName);
	}
	
	public void createBackpack(String itemName) {
		backpackList.put(itemName, (NewBackpack) new NewBackpack().setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		backpackList.get(itemName).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerItem(backpackList.get(itemName), itemName);
	}
	
	public void createBlock(String itemName, Material material) {
		blockList.put(itemName, new NewBlock(material).setBlockName(itemName).setBlockTextureName(("mm:" + itemName)));
		blockList.get(itemName).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerBlock(blockList.get(itemName), itemName);
	}
	
	public void createTool(String itemName, String toolType, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		if(toolType.equals("Pickaxe"))
		{
			toolList.put(itemName, new NewPickaxe(itemName, harvestLevel, maxUses, efficiency, damage, enchantability).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		} else if(toolType.equals("Axe"))
		{
			toolList.put(itemName, new NewAxe(itemName, harvestLevel, maxUses, efficiency, damage, enchantability).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		} else if(toolType.equals("Shovel"))
		{
			toolList.put(itemName, new NewShovel(itemName, harvestLevel, maxUses, efficiency, damage, enchantability).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		} else if(toolType.equals("Hoe"))
		{
			toolList.put(itemName, new NewHoe(itemName, harvestLevel, maxUses, efficiency, damage, enchantability).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		} else if(toolType.equals("Sword"))
		{
			toolList.put(itemName, new NewSword(itemName, harvestLevel, maxUses, efficiency, damage, enchantability).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		}
		
		toolList.get(itemName).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerItem(toolList.get(itemName), itemName);
	}
	
	public void createArmor(String itemMaterialName, String itemName, String armorType, int durability, int[] defense, int enchantability) {
		if(armorType.equals("Helmet"))
		{
			armorList.put(itemName, new NewArmor(itemMaterialName, itemName, durability, defense, enchantability,0,0).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		} else if(armorType.equals("Chestplate"))
		{
			armorList.put(itemName, new NewArmor(itemMaterialName, itemName, durability, defense, enchantability,0,1).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		} else if(armorType.equals("Leggings"))
		{
			armorList.put(itemName, new NewArmor(itemMaterialName, itemName, durability, defense, enchantability,0,2).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		} else if(armorType.equals("Boots"))
		{
			armorList.put(itemName, new NewArmor(itemMaterialName, itemName, durability, defense, enchantability,0,3).setUnlocalizedName(itemName).setTextureName("mm:" + itemName));
		}
		
		armorList.get(itemName).setCreativeTab(Master_Mod.tabMasterMod);
		GameRegistry.registerItem(armorList.get(itemName), itemName);
	}
	
	public void addSmeltingRecipe(Block inputBlock, Item outputItem) {
		GameRegistry.addSmelting(inputBlock, new ItemStack(outputItem), 1F);
	}
	
	public void addSmeltingRecipe(Block inputBlock, Block outputBlock) {
		GameRegistry.addSmelting(inputBlock, new ItemStack(outputBlock), 1F);
	}
	
	public void addSmeltingRecipe(Item inputItem, Item outputItem) {
		GameRegistry.addSmelting(inputItem, new ItemStack(outputItem), 1F);
	}
	
	public void addCraftingRecipe(Item item, String itemPatern, Item craftingMaterial) {
		if(itemPatern.equals("Sword"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{" a "," a "," b ", 'a', craftingMaterial, 'b', Items.stick});
		}
		if(itemPatern.equals("Pickaxe"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"aaa"," b "," b ", 'a', craftingMaterial, 'b', Items.stick});
		}
		if(itemPatern.equals("Axe"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"aa ","ab "," b ", 'a', craftingMaterial, 'b', Items.stick});
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{" aa"," ba"," b ", 'a', craftingMaterial, 'b', Items.stick});
		}
		if(itemPatern.equals("Shovel"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{" a "," b "," b ", 'a', craftingMaterial, 'b', Items.stick});
		}
		if(itemPatern.equals("Hoe"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{" aa"," b "," b ", 'a', craftingMaterial, 'b', Items.stick});
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"aa "," b "," b ", 'a', craftingMaterial, 'b', Items.stick});
		}
		if(itemPatern.equals("Helmet"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"aaa","a a", 'a', craftingMaterial});
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"   ","aaa","a a", 'a', craftingMaterial});
		}
		if(itemPatern.equals("Chestplate"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"a a","aaa","aaa", 'a', craftingMaterial});
		}
		if(itemPatern.equals("Leggings"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"aaa","a a","a a", 'a', craftingMaterial});
		}
		if(itemPatern.equals("Boots"))
		{
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"a a","a a", 'a', craftingMaterial});
			GameRegistry.addRecipe(new ItemStack(item), 
					new Object[]{"   ","a a","a a", 'a', craftingMaterial});
		}
	}
}