package Master_Cram.Master_Mod.inventory;

import Master_Cram.Master_Mod.item.NewAmulet;
import Master_Cram.Master_Mod.item.NewArmor;
import Master_Cram.Master_Mod.item.NewBackpack;
import Master_Cram.Master_Mod.item.NewRing;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.util.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerCustomPlayer extends Container
{
	/** Avoid magic numbers! This will greatly reduce the chance of you making errors in 'transferStackInSlot' method */
	private static final int CRAFTING_OUTPUT = 0, CRAFTING_1_START = CRAFTING_OUTPUT + 1, CRAFTING_1_END = CRAFTING_1_START + 3,
			ARMOR_START = CRAFTING_1_END + 1, ARMOR_END = ARMOR_START+3,
			INV_START = ARMOR_END+1, INV_END = INV_START+26, HOTBAR_START = INV_END+1,
			HOTBAR_END = HOTBAR_START+8, CUSTOM_START = HOTBAR_END + 1,
			CUSTOM_END = CUSTOM_START + 3,
			CRAFTING_2_START = CUSTOM_END + 1, CRAFTING_2_END = CRAFTING_2_START + 4;
	
	public CustomInventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private final EntityPlayer thePlayer;
	

	public ContainerCustomPlayer(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryCustomPlayer inventoryCustom, BackpackInventory backpackInventory, ItemStack[] itemList)
	{
		this.thePlayer = player;
		this.craftMatrix = new CustomInventoryCrafting(this, 3, 3, itemList);
		this.craftResult = new InventoryCraftResult();
		worldObj = player.getEntityWorld();
		int i;
		this.addSlotToContainer(new SlotCrafting(player, craftMatrix, craftResult, 0, 129 + 105, 8 + 27));
		this.addSlotToContainer(new Slot(craftMatrix, 0, 112 + 65, 28 - 11));
		this.addSlotToContainer(new Slot(craftMatrix, 1, 129 + 66, 28 - 11));
		this.addSlotToContainer(new Slot(craftMatrix, 2, 146 + 67, 28 - 11));
		this.addSlotToContainer(new Slot(craftMatrix, 3, 112 + 65, 45 - 10));
		
		// Add ARMOR slots; note you need to make a public version of SlotArmor
		// just copy and paste the vanilla code into a new class and change what you need
		for (i = 0; i < 4; ++i)
		{
			this.addSlotToContainer(new SlotArmor(player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 8 + 77, 8 + i * 18, 

					i));
		}

		// Add vanilla PLAYER INVENTORY - just copied/pasted from vanilla classes
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + 77 + j * 18, 84 + i * 18));
			}
		}

		// Add ACTION BAR - just copied/pasted from vanilla classes
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + 77 + i * 18, 142));
		}
		
		// Add CUSTOM slots - we'll just add two for now, both of the same type.
		// Make a new Slot class for each different item type you want to add	
		this.addSlotToContainer(new SlotAmulet(inventoryCustom, 0, 80 + 74, 8));
		this.addSlotToContainer(new SlotRing(inventoryCustom, 1, 80 + 74, 26));
		this.addSlotToContainer(new SlotRing(inventoryCustom, 2, 80 + 74, 44));
		this.addSlotToContainer(new SlotBackpack(inventoryCustom, player, 3, 80 + 74, 62));
		
		this.addSlotToContainer(new Slot(craftMatrix, 4, 129 + 66, 45 - 10));
		this.addSlotToContainer(new Slot(craftMatrix, 5, 146 + 67, 45 - 10));
		this.addSlotToContainer(new Slot(craftMatrix, 6, 112 + 65, 62 - 9));
		this.addSlotToContainer(new Slot(craftMatrix, 7, 129 + 66, 62 - 9));
		this.addSlotToContainer(new Slot(craftMatrix, 8, 146 + 67, 62 - 9));
		
		this.onCraftMatrixChanged(this.craftMatrix);
		
		for (i = 0; i < 8; ++i)
		{
			for (int j = 0; j < 4; ++j)
			{
				this.addSlotToContainer(new SlotBackpackItem(backpackInventory, inventoryCustom.getStackInSlot(3), player, j + i * 4, 8 + j*18,12 + i*18));
			}
		}

	}
	
	public void onCraftMatrixChanged(IInventory iinventory)
    {
        craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }

	/**
	 * This should always return true, since custom inventory can be accessed from anywhere
	 */
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 * Basically the same as every other container I make, since I define the same constant indices for all of them 
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// Either armor slot or custom item slot was clicked
			if ((par2 >= ARMOR_START && par2 <= ARMOR_END) || (par2 >= CUSTOM_START && par2 <= CUSTOM_END) || (par2== CRAFTING_OUTPUT)
					|| (par2 >= CRAFTING_1_START && par2 <= CRAFTING_1_END) || (par2 >= CRAFTING_2_START && par2 <= CRAFTING_2_END))
			{
				// try to place in player inventory / action bar
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true))
				{
					return null;
				}
				if(itemstack1.getItem() instanceof NewBackpack)
				{
					ExtendedPlayer.get(player).backpackInventory.clearInventory();
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			// Item is in inventory / hotbar, try to place either in custom or armor slots
			else
			{
				
				// if item is our custom amulet
				if (itemstack1.getItem() instanceof NewAmulet)
				{
					if (!this.mergeItemStack(itemstack1, CUSTOM_START, CUSTOM_START + 1, false))
					{
						return null;
					}
				}
				// if item is our custom amulet
				else if (itemstack1.getItem() instanceof NewRing)
				{
					if (!this.mergeItemStack(itemstack1, CUSTOM_START + 1, CUSTOM_START + 3, false))
					{
						return null;
					}
				} 
				// if item is our custom backpack
				else if (itemstack1.getItem() instanceof NewBackpack)
					{
						if (!this.mergeItemStack(itemstack1, CUSTOM_START+3, CUSTOM_START + 4, false))
						{
							return null;
						}
						if(itemstack1.hasTagCompound())
						{
							ExtendedPlayer.get(player).backpackInventory.clearInventory();
							ExtendedPlayer.get(player).backpackInventory.readFromNBT(itemstack1.getTagCompound());
						}
						else
						{
							ExtendedPlayer.get(player).backpackInventory.clearInventory();
						}
					}
				// if item is armor
				else if (itemstack1.getItem() instanceof ItemArmor)
				{
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
					{
						return null;
					}
				}
				// item in player's inventory, but not in action bar
				else if (par2 >= INV_START && par2 < HOTBAR_START)
				{
					// place in action bar
					if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_END + 1, false))
					{
						return null;
					}
				}
				// item in action bar - place in player inventory
				else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
				{
					if (!this.mergeItemStack(itemstack1, INV_START, INV_END + 1, false))
					{
						return null;
					}
				}
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}
}