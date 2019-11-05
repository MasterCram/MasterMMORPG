package Master_Cram.Master_Mod.util;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class BackpackHelper {
	public static void create(ItemStack stack, EntityPlayer player, Random random)
	{
		NBTTagCompound nbt = NBTHelper.loadStackNBT(stack);
		if (nbt != null && !nbt.getBoolean("AttributeDone") == true)
		{
			nbt.getTag("display");
	        nbt.setTag("display", new NBTTagCompound());
			NBTTagCompound taglore = nbt.getCompoundTag("display");
			NBTTagList lore = new NBTTagList();
			
			nbt.setInteger("BackpackSlot", random.nextInt(32) + 1);
			nbt.setInteger("BackpackStackLimit", random.nextInt(64) + 1);
			
			lore.appendTag(new NBTTagString(Rarity.DEFAULT.color + "Slot: " + nbt.getInteger("BackpackSlot")));
			lore.appendTag(new NBTTagString(Rarity.DEFAULT.color + "Stack: " + nbt.getInteger("BackpackStackLimit")));
			taglore.setTag("Lore", lore);
			nbt.setBoolean("AttributeDone", true);
			NBTHelper.saveStackNBT(stack, nbt);
		}
		
	}
}
