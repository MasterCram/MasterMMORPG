package Master_Cram.Master_Mod.handler;

import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.gui.ClanGui;
import Master_Cram.Master_Mod.gui.GuiCustomPlayerInventory;
import Master_Cram.Master_Mod.inventory.ContainerCustomPlayer;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MasterGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Server Gui");
		if(ID == References.GUI_INVENTORY) {
			return new ContainerCustomPlayer(player, player.inventory, ExtendedPlayer.get(player).inventory, ExtendedPlayer.get(player).backpackInventory, ExtendedPlayer.get(player).craftingItemList);
		} else {
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Client Gui");
		if ( ID == References.GUI_INVENTORY) {
			return new GuiCustomPlayerInventory(player, player.inventory, ExtendedPlayer.get(player).inventory, ExtendedPlayer.get(player).backpackInventory, ExtendedPlayer.get(player).craftingItemList);
		} else if ( ID == References.GUI_CLAN) {
			return null;
			} else {
			return null;
		}
	}

}
