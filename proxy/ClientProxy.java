package Master_Cram.Master_Mod.proxy;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.handler.KeyHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
	
public void registerProxies() {
		FMLCommonHandler.instance().bus().register(new KeyHandler());
	}

}
