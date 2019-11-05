package Master_Cram.Master_Mod.handler;

import org.lwjgl.input.Keyboard;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.gui.ClanGui;
import Master_Cram.Master_Mod.gui.SkillsGui;
import Master_Cram.Master_Mod.packet.OpenGuiPacket;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.settings.KeyBinding;

public class KeyHandler {
	
	public static final int INVENTORY_KEY = 0;
	public static final int CLAN_KEY = 1;
	public static final int STATS_KEY = 2;
	
	private static final String[] keyDesc = {"key.master_mod.inventory.desc", "key.master_mod.clan.desc", "key.master_mod.skills.desc"};
	private static final int[] keyValues = {Keyboard.KEY_E, Keyboard.KEY_J, Keyboard.KEY_K};
	private final KeyBinding[] keys;
	
	public KeyHandler() {
		keys = new KeyBinding[keyValues.length];
		for(int i = 0; i < keyValues.length; i++) {
			keys[i] = new KeyBinding(keyDesc[i], keyValues[i], "key.master_mod.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			int key = Keyboard.getEventKey();
			boolean isDown = Keyboard.getEventKeyState();
			// inventory key
			if(isDown && key == keyValues[INVENTORY_KEY] && !FMLClientHandler.instance().getClientPlayerEntity().capabilities.isCreativeMode) {
				// send packet to open gui
				Master_Mod.packetPipeline.sendToServer(new OpenGuiPacket(References.GUI_INVENTORY));
			}
			
			// clan Key
			if(isDown && key == keyValues[CLAN_KEY] && !FMLClientHandler.instance().getClientPlayerEntity().capabilities.isCreativeMode) {
				// send packet to open gui
				//Master_Mod.packetPipeline.sendToServer(new OpenGuiPacket(References.TEST_GUI));
				Minecraft.getMinecraft().displayGuiScreen(new ClanGui(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).player.getDisplayName()));
				
			}
			
			if(isDown && key == keyValues[STATS_KEY] && !FMLClientHandler.instance().getClientPlayerEntity().capabilities.isCreativeMode) {
				// send packet to open gui
				//Master_Mod.packetPipeline.sendToServer(new OpenGuiPacket(References.TEST_GUI));
				//System.out.println(Minecraft.getMinecraft().thePlayer.getDisplayName());
				Minecraft.getMinecraft().displayGuiScreen(new SkillsGui(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).player.getDisplayName()));
				
				
			}
						
		}
	}

}
