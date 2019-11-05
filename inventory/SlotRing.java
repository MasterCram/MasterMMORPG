package Master_Cram.Master_Mod.inventory;

import Master_Cram.Master_Mod.item.NewIcon;
import Master_Cram.Master_Mod.item.NewRing;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class SlotRing extends Slot {
	

	public SlotRing(IInventory inventory, int slotIndex, int x, int y)
	{
		super(inventory, slotIndex, x, y);
	}

	/**
	 * Check if the stack is a valid item for this slot. Always true beside for the armor slots
	 * (and now also not always true for our custom inventory slots)
	 */
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		// We only want our custom item to be storable in this slot
		return (stack.getItem() instanceof NewRing);
	}
	
	public int getSlotStackLimit()
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBackgroundIconIndex()
	{
		return NewIcon.getIcon(1);
	}
}
