package Master_Cram.Master_Mod.player;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.clan.Clan;
import Master_Cram.Master_Mod.clan.ClanRank;
import Master_Cram.Master_Mod.gui.GuiCustomPlayerInventory;
import Master_Cram.Master_Mod.inventory.BackpackInventory;
import Master_Cram.Master_Mod.inventory.ContainerCustomPlayer;
import Master_Cram.Master_Mod.inventory.CustomInventoryCrafting;
import Master_Cram.Master_Mod.inventory.InventoryCustomPlayer;
import Master_Cram.Master_Mod.item.NewBackpack;
import Master_Cram.Master_Mod.skill.Skills;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {
	
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	public final EntityPlayer player;
	
	private int currentMana, maxMana, clanID, rankID;
	
	public final InventoryCustomPlayer inventory;
	
	public BackpackInventory backpackInventory;
	
	public ItemStack[] craftingItemList;
	
	public ClanRank clanRank;
	
	public Skills skills = new Skills();
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.backpackInventory = new BackpackInventory(player);
		this.inventory = new InventoryCustomPlayer(player);
		this.craftingItemList = new ItemStack[9];
		this.currentMana = this.maxMana = 20;
		this.clanRank = ClanRank.none;
	}
	
	public static final void register(EntityPlayer player)
	{
		ExtendedPlayer newPlayer = new ExtendedPlayer(player);
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, newPlayer);
	}

	public static final ExtendedPlayer get(EntityPlayer player)
	{
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("CurrentMana", this.currentMana);
		properties.setInteger("MaxMana", this.maxMana);
		properties.setInteger("clanID", this.clanID);
		this.inventory.writeToNBT(properties);
		this.backpackInventory.writeToNBT(properties);
		this.skills.saveToNBT(properties);
		this.writeItemStackListToNBT(properties, craftingItemList);
		compound.setTag(EXT_PROP_NAME, properties);
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.currentMana = properties.getInteger("CurrentMana");
		this.maxMana = properties.getInteger("MaxMana");
		this.clanID = properties.getInteger("clanID");
		this.inventory.readFromNBT(properties);
		this.skills.loadFromNBT(player, properties);
		this.backpackInventory.readFromNBT(properties);
		this.readItemStackListFromNBT(properties);
		
	}

	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public boolean consumeMana(int amount) {
		boolean sufficient = amount <= this.currentMana;
		this.currentMana -= (amount < this.currentMana ? amount : this.currentMana);
		return sufficient;
	}
	
	public void replenishMana()
	{
		this.currentMana = this.maxMana;
	}
	
	public int getClanID()
	{
		return this.clanID;
	}
	
	public void setClanID(int clanID)
	{
		this.clanID = clanID;
	}
	
	
	
	public void writeItemStackListToNBT(NBTTagCompound compound, ItemStack[] itemStackList)
	{
		NBTTagList items = new NBTTagList();

		for (int i = 0; i < itemStackList.length; ++i)
		{
			if (itemStackList[i] != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("CraftingSlot", (byte) i);
				itemStackList[i].writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		// We're storing our items in a custom tag list using our 'tagName' from above
		// to prevent potential conflicts
		compound.setTag("InventoryCraftingTag", items);
	}

	public void readItemStackListFromNBT(NBTTagCompound compound) {
		// now you must include the NBTBase type ID when getting the list; NBTTagCompound's ID is 10
		NBTTagList items = compound.getTagList("InventoryCraftingTag", compound.getId());
		for (int i = 0; i < items.tagCount(); ++i) {
			// tagAt(int) has changed to getCompoundTagAt(int)
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("CraftingSlot");
			if (slot >= 0 && slot < this.craftingItemList.length) {
				this.craftingItemList[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
	}

	public void setClanRank(ClanRank rank) {
		this.clanRank = rank;
		
	}

	public int getClanRankID() {
		return rankID;
	}

	
	
	/*public void haveBackpack(NBTTagCompound compound) {
		// now you must include the NBTBase type ID when getting the list; NBTTagCompound's ID is 10
		NBTTagList items = compound.getTagList("CustomInvTag", compound.getId());
			NBTTagCompound item = items.getCompoundTagAt(3);
			byte slot = item.getByte("Slot");
			if (ItemStack.loadItemStackFromNBT(item).getItem() instanceof NewBackpack) {
				this.playerHaveBackpack = true;
			} else {
				this.playerHaveBackpack = false;
			}
	}*/

}
