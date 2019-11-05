package Master_Cram.Master_Mod.event;

import Master_Cram.Master_Mod.data.MasterWorldData;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

public class EventWorldSave {

		@SubscribeEvent
		public void onWorldSave(WorldEvent.Save event)
		{
			System.out.println("Saving test");
			MasterWorldData.get(event.world).markDirty();
		}
	}
