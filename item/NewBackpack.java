package Master_Cram.Master_Mod.item;

import Master_Cram.Master_Mod.inventory.BackpackInventory;
import Master_Cram.Master_Mod.util.NBTHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.EnumHelper;

public class NewBackpack extends Item {
	
	//public BackpackInventory backpackInventory = new BackpackInventory();
	
	public final static String BACKPACK_PROP_NAME = "BackpackInventory";
	
	public NewBackpack() {
		this.setMaxStackSize(1);
	}
	
	/*public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound properties = new NBTTagCompound();
		this.backpackInventory.writeToNBT(properties);
		nbt.setTag(BACKPACK_PROP_NAME, properties);
		
	}

	public void loadNBTData(NBTTagCompound nbt) {
		NBTTagCompound properties = (NBTTagCompound) nbt.getTag(BACKPACK_PROP_NAME);
		this.backpackInventory.readFromNBT(properties);
	}*/
}
