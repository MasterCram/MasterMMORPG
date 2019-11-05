package Master_Cram.Master_Mod.event;

import Master_Cram.Master_Mod.util.ArmorHelper;
import Master_Cram.Master_Mod.util.BackpackHelper;
import Master_Cram.Master_Mod.util.Rarity;
import Master_Cram.Master_Mod.util.WeaponHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class OnCreateArmorEvent {
	
	@SubscribeEvent
	public void onCreateArmor(PlayerTickEvent event)
	{
		if(event != null && !event.player.getEntityWorld().isRemote)
		{
			for (ItemStack stack : event.player.inventory.mainInventory)
			{
				if(stack != null)
				{
					if(stack.getItem().getUnlocalizedName().substring(5).equals("backpack"))
					{
						BackpackHelper.create(stack, event.player, event.player.getEntityWorld().rand);
					}
					if(stack.getItem().getUnlocalizedName().endsWith("Helmet2"))
					{
						ArmorHelper.create(stack, event.player, Rarity.COMMON, "Helmet");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Helmet3"))
					{
						ArmorHelper.create(stack, event.player, Rarity.UNCOMMON, "Helmet");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Helmet4"))
					{
						ArmorHelper.create(stack, event.player, Rarity.RARE, "Helmet");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Helmet5"))
					{
						ArmorHelper.create(stack, event.player, Rarity.EPIC, "Helmet");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Helmet6"))
					{
						ArmorHelper.create(stack, event.player, Rarity.LEGENDARY, "Helmet");
					}
					
					if(stack.getItem().getUnlocalizedName().endsWith("Chestplate2"))
					{
						ArmorHelper.create(stack, event.player, Rarity.COMMON, "Chestplate");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Chestplate3"))
					{
						ArmorHelper.create(stack, event.player, Rarity.UNCOMMON, "Chestplate");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Chestplate4"))
					{
						ArmorHelper.create(stack, event.player, Rarity.RARE, "Chestplate");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Chestplate5"))
					{
						ArmorHelper.create(stack, event.player, Rarity.EPIC, "Chestplate");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Chestplate6"))
					{
						ArmorHelper.create(stack, event.player, Rarity.LEGENDARY, "Chestplate");
					}
					
					if(stack.getItem().getUnlocalizedName().endsWith("Leggings2"))
					{
						ArmorHelper.create(stack, event.player, Rarity.COMMON, "Leggings");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Leggings3"))
					{
						ArmorHelper.create(stack, event.player, Rarity.UNCOMMON, "Leggings");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Leggings4"))
					{
						ArmorHelper.create(stack, event.player, Rarity.RARE, "Leggings");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Leggings5"))
					{
						ArmorHelper.create(stack, event.player, Rarity.EPIC, "Leggings");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Leggings6"))
					{
						ArmorHelper.create(stack, event.player, Rarity.LEGENDARY, "Leggings");
					}
					
					if(stack.getItem().getUnlocalizedName().endsWith("Boots2"))
					{
						ArmorHelper.create(stack, event.player, Rarity.COMMON, "Boots");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Boots3"))
					{
						ArmorHelper.create(stack, event.player, Rarity.UNCOMMON, "Boots");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Boots4"))
					{
						ArmorHelper.create(stack, event.player, Rarity.RARE, "Boots");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Boots5"))
					{
						ArmorHelper.create(stack, event.player, Rarity.EPIC, "Boots");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Boots6"))
					{
						ArmorHelper.create(stack, event.player, Rarity.LEGENDARY, "Boots");
					}
				}
			}
		}
	}
}
