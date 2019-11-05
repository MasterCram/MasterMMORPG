package Master_Cram.Master_Mod.event;

import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.util.Rarity;
import Master_Cram.Master_Mod.util.WeaponHelper;
import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class EventItemCrafted {

	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		
		
		/*if(event.crafting != null) // && !event.player.getEntityWorld().isRemote)
		{
			System.out.println("PlayerEvent");
			if(event.crafting.getItem().getUnlocalizedName().substring(5).equals("ironSword2") || event.crafting.getItem().getUnlocalizedName().substring(5).equals("silverSword2"))
			{
				WeaponHelper.create(event.crafting, event.player, Rarity.COMMON);
			} else if(event.crafting.getItem().getUnlocalizedName().substring(5).equals("ironSword3") || event.crafting.getItem().getUnlocalizedName().substring(5).equals("silverSword3"))
			{
				WeaponHelper.create(event.crafting, event.player, Rarity.UNCOMMON);
			} else if(event.crafting.getItem().getUnlocalizedName().substring(5).equals("ironSword4") || event.crafting.getItem().getUnlocalizedName().substring(5).equals("silverSword4"))
			{
				WeaponHelper.create(event.crafting, event.player, Rarity.RARE);
			} else if(event.crafting.getItem().getUnlocalizedName().substring(5).equals("ironSword5") || event.crafting.getItem().getUnlocalizedName().substring(5).equals("silverSword5"))
			{
				WeaponHelper.create(event.crafting, event.player, Rarity.EPIC);
			} else if(event.crafting.getItem().getUnlocalizedName().substring(5).equals("ironSword6") || event.crafting.getItem().getUnlocalizedName().substring(5).equals("silverSword6"))
			{
				WeaponHelper.create(event.crafting, event.player, Rarity.LEGENDARY);
			}
					
		}*/
	}
}
