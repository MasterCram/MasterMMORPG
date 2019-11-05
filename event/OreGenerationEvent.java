package Master_Cram.Master_Mod.event;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;

public class OreGenerationEvent {

	
	@SubscribeEvent
	public void oreGenerationEvent(OreGenEvent.GenerateMinable event) {
		switch(event.type) {
		case DIAMOND:
	    case LAPIS:
	    case IRON:
		    event.setResult(Result.DENY);
		    break;
	    default:
		}
	}
}
