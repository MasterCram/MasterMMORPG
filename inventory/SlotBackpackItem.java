package Master_Cram.Master_Mod.inventory;

import Master_Cram.Master_Mod.item.NewAmulet;
import Master_Cram.Master_Mod.item.NewBackpack;
import Master_Cram.Master_Mod.item.NewIcon;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.util.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

public class SlotBackpackItem extends Slot {
	
	public EntityPlayer player;
	
	public int slotIndex;

	public SlotBackpackItem(IInventory inventory, ItemStack backpackStack, EntityPlayer player, int slotIndex, int x, int y)
	{
		super(inventory, slotIndex, x, y);
		
		this.player = player;
		this.slotIndex = slotIndex;
	}

	/**
	 * Check if the stack is a valid item for this slot. Always true beside for the armor slots
	 * (and now also not always true for our custom inventory slots)
	 */
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		
		// We only want our custom item to be storable in this slot
		if(ExtendedPlayer.get(player).inventory.getStackInSlot(3) != null)
		{
			NBTTagCompound nbt = NBTHelper.loadStackNBT(ExtendedPlayer.get(player).inventory.getStackInSlot(3));
			if (nbt != null)
			{
				if(this.slotIndex < nbt.getInteger("BackpackSlot"))
				{
					if(ExtendedPlayer.get(player).inventory.getStackInSlot(3).getItem() instanceof NewBackpack && !(stack.getItem() instanceof NewBackpack))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public int getSlotStackLimit()
	{
		NBTTagCompound nbt = NBTHelper.loadStackNBT(ExtendedPlayer.get(player).inventory.getStackInSlot(3));
		if (nbt != null)
		{
			return nbt.getInteger("BackpackStackLimit");
		}
		
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBackgroundIconIndex()
	{
		if(ExtendedPlayer.get(player).inventory.getStackInSlot(3) != null)
		{
			NBTTagCompound nbt = NBTHelper.loadStackNBT(ExtendedPlayer.get(player).inventory.getStackInSlot(3));
			if (nbt != null)
			{
				if(this.slotIndex >= nbt.getInteger("BackpackSlot"))
					return NewIcon.getIcon(3);
				else
					return null;
			}
		}

		return NewIcon.getIcon(3);
	}
}
