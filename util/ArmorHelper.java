package Master_Cram.Master_Mod.util;

import java.math.BigDecimal;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;


public class ArmorHelper {
	public static void create(ItemStack stack, EntityPlayer player, Rarity rarity, String itemType)
	{
		NBTTagCompound nbt = NBTHelper.loadStackNBT(stack);
		
		if (nbt != null && nbt.getBoolean("AttributeDone") == false)
		{
			
			//TODO set item level		
			
			nbt.getTag("display");
	        nbt.setTag("display", new NBTTagCompound());
			NBTTagCompound taglore = nbt.getCompoundTag("display");
			NBTTagList lore = new NBTTagList();
			
			if(itemType.equals("Helmet"))
			{
				nbt.setInteger("nbAttribute", rarity.bonusHelmet.nbAttribute);
				rarity.bonusHelmet.addNewAttribute(player, stack, nbt);
			} else if(itemType.equals("Chestplate"))
			{
				nbt.setInteger("nbAttribute", rarity.bonusChestplate.nbAttribute);
				rarity.bonusChestplate.addNewAttribute(player, stack, nbt);
			} else if(itemType.equals("Leggings"))
			{
				nbt.setInteger("nbAttribute", rarity.bonusLeggings.nbAttribute);
				rarity.bonusLeggings.addNewAttribute(player, stack, nbt);
			} else if(itemType.equals("Boots"))
			{
				nbt.setInteger("nbAttribute", rarity.bonusBoots.nbAttribute);
				rarity.bonusBoots.addNewAttribute(player, stack, nbt);
			}
			
			
			if(nbt.getInteger("nbAttribute") >=1)
			{
				for(int i = 1 ; i <= 5 ; i++)
				{
					if(!nbt.getString("bonusName" + Integer.toString(i)).equals("None"))
					{
						BigDecimal roundRand2 = new BigDecimal((Float) nbt.getFloat(("bonus" + Integer.toString(i)))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
						lore.appendTag(new NBTTagString(rarity.color + nbt.getString("bonusName" + Integer.toString(i))
							+ " +" + (roundRand2.floatValue())));
					}
				}
				taglore.setTag("Lore", lore);
			}
			nbt.setBoolean("AttributeDone", true);
			NBTHelper.saveStackNBT(stack, nbt);
		}
	}
}
