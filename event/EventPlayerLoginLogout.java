package Master_Cram.Master_Mod.event;

import Master_Cram.Master_Mod.Master_Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraft.entity.player.EntityPlayer;

public class EventPlayerLoginLogout {
	
	@SubscribeEvent
	public void OnPlayerLogin(PlayerLoggedInEvent event) {
		if(event.player instanceof EntityPlayer) {
			if(!event.player.worldObj.isRemote) {
				Master_Mod.addPlayerToOnlineList(event.player);
			}
		}
	}
	
	@SubscribeEvent
	public void OnPlayerLogout(PlayerLoggedOutEvent  event) {
		if(event.player instanceof EntityPlayer) {
			if(!event.player.worldObj.isRemote) {
				Master_Mod.removePlayerFromOnlineList(event.player);
			}
		}
	}
}