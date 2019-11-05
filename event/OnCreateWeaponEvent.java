package Master_Cram.Master_Mod.event;

import Master_Cram.Master_Mod.item.NewBackpack;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.util.Rarity;
import Master_Cram.Master_Mod.util.WeaponHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class OnCreateWeaponEvent {
	
	@SubscribeEvent
	public void onCreateWeapon(PlayerTickEvent event)
	{
		if(event != null && !event.player.getEntityWorld().isRemote)
		{
			if(ExtendedPlayer.get(event.player).inventory.getStackInSlot(3) != null)
			{
				ExtendedPlayer.get(event.player).backpackInventory.writeToNBT(ExtendedPlayer.get(event.player).inventory.getStackInSlot(3));
				//System.out.print("Saved nbt Data of " + ExtendedPlayer.get(event.player).inventory.getStackInSlot(3).getDisplayName() + " for " + event.player.getDisplayName() + "\n"); // TODO better method to save backpack..
				
			}
			for (ItemStack stack : event.player.inventory.mainInventory)
			{
				if(stack != null)
				{
					
					if(stack.getItem().getUnlocalizedName().endsWith("Sword2"))
					{
						WeaponHelper.create(stack, event.player, Rarity.COMMON, "Sword");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Sword3"))
					{
						WeaponHelper.create(stack, event.player, Rarity.UNCOMMON, "Sword");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Sword4"))
					{
						WeaponHelper.create(stack, event.player, Rarity.RARE, "Sword");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Sword5"))
					{
						WeaponHelper.create(stack, event.player, Rarity.EPIC, "Sword");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Sword6"))
					{
						WeaponHelper.create(stack, event.player, Rarity.LEGENDARY, "Sword");
					}
					
					if(stack.getItem().getUnlocalizedName().endsWith("Pickaxe2"))
					{
						WeaponHelper.create(stack, event.player, Rarity.COMMON, "Pickaxe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Pickaxe3"))
					{
						WeaponHelper.create(stack, event.player, Rarity.UNCOMMON, "Pickaxe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Pickaxe4"))
					{
						WeaponHelper.create(stack, event.player, Rarity.RARE, "Pickaxe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Pickaxe5"))
					{
						WeaponHelper.create(stack, event.player, Rarity.EPIC, "Pickaxe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Pickaxe6"))
					{
						WeaponHelper.create(stack, event.player, Rarity.LEGENDARY, "Pickaxe");
					}
					
					if(stack.getItem().getUnlocalizedName().endsWith("Axe2"))
					{
						WeaponHelper.create(stack, event.player, Rarity.COMMON, "Axe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Axe3"))
					{
						WeaponHelper.create(stack, event.player, Rarity.UNCOMMON, "Axe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Axe4"))
					{
						WeaponHelper.create(stack, event.player, Rarity.RARE, "Axe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Axe5"))
					{
						WeaponHelper.create(stack, event.player, Rarity.EPIC, "Axe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Axe6"))
					{
						WeaponHelper.create(stack, event.player, Rarity.LEGENDARY, "Axe");
					}
					
					if(stack.getItem().getUnlocalizedName().endsWith("Shovel2"))
					{
						WeaponHelper.create(stack, event.player, Rarity.COMMON, "Shovel");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Shovel3"))
					{
						WeaponHelper.create(stack, event.player, Rarity.UNCOMMON, "Shovel");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Shovel4"))
					{
						WeaponHelper.create(stack, event.player, Rarity.RARE, "Shovel");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Shovel5"))
					{
						WeaponHelper.create(stack, event.player, Rarity.EPIC, "Shovel");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Shovel6"))
					{
						WeaponHelper.create(stack, event.player, Rarity.LEGENDARY, "Shovel");
					}
					
					if(stack.getItem().getUnlocalizedName().endsWith("Hoe2"))
					{
						WeaponHelper.create(stack, event.player, Rarity.COMMON, "Hoe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Hoe3"))
					{
						WeaponHelper.create(stack, event.player, Rarity.UNCOMMON, "Hoe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Hoe4"))
					{
						WeaponHelper.create(stack, event.player, Rarity.RARE, "Hoe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Hoe5"))
					{
						WeaponHelper.create(stack, event.player, Rarity.EPIC, "Hoe");
					} else if(stack.getItem().getUnlocalizedName().endsWith("Hoe6"))
					{
						WeaponHelper.create(stack, event.player, Rarity.LEGENDARY, "Hoe");
					}
					
				}
			}
		}
	}
}
