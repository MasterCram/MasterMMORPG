package Master_Cram.Master_Mod.gui;

import org.lwjgl.opengl.GL11;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.clan.Clan;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SkillsGui extends GuiScreen {
	public GuiButton a,b,z;
	
	int guiWidth = 256;
	int guiHeight = 256;
	
	private ExtendedPlayer extendedPlayer;
	private String playerName;
	//private Clan clan;
	
	public SkillsGui(String playerName) {
		this.playerName = playerName;
		this.extendedPlayer = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer);
		
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		/*if(Master_Mod.instance.getPlayerWithName(this.playerName) instanceof EntityPlayer)
		{
			System.out.println(ExtendedPlayer.get(Master_Mod.instance.getPlayerWithName(this.playerName)).skills.combat.getExperience());
		}*/
	
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		this.drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation("mm","textures/gui/skillTab.png"));
	    drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
	    
	  //Combat--------
	    //if(Master_Mod.instance.getPlayerWithName(this.playerName) instanceof EntityPlayer) {
	    	if(ExtendedPlayer.get(Master_Mod.getPlayerWithName(this.playerName)).skills.combat.getLevel() < 10) {
	    		this.drawString(fontRendererObj,"\247f0" + ExtendedPlayer.get(Master_Mod.getPlayerWithName(this.playerName)).skills.combat.getLevel(), width / 2 - 98, height / 2 - 86, 0);
	    		this.drawString(fontRendererObj,"\247f/0" + ExtendedPlayer.get(Master_Mod.getPlayerWithName(this.playerName)).skills.combat.getLevel(), width / 2 - 85, height / 2 - 86, 0);
	    	} else {
	    		this.drawString(fontRendererObj,"\247f" + ExtendedPlayer.get(Master_Mod.getPlayerWithName(this.playerName)).skills.combat.getLevel(), width / 2 - 98, height / 2 - 86, 0);
	    		this.drawString(fontRendererObj,"\247f/" + ExtendedPlayer.get(Master_Mod.getPlayerWithName(this.playerName)).skills.combat.getLevel(), width / 2 - 85, height / 2 - 86, 0);
	    	}
	    //}
	    //--------------
	    
	    
	    //Mining--------
	    //if(this.extendedPlayer != null) {
	    	//if(this.extendedPlayer.skills.mining.getLevel() < 10) {
	    	//	this.drawString(fontRendererObj,"\247e0" + this.extendedPlayer.skills.combat.getLevel(), width / 2 - 83, height / 2 - 81, 0);
	    	//} else
	    //		this.drawString(fontRendererObj,"\247e" + this.extendedPlayer.skills.combat.getExperience(), width / 2 - 83, height / 2 - 81, 0);
	    //}
	    //this.drawString(fontRendererObj,"\247e/01", width / 2 - 70, height / 2 - 81, 0);
	    //--------------
	    
	    
	    
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		//this.buttonList.add(this.a = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24, "This is button a"));
		this.buttonList.add(this.z = new GuiButton(99, this.width / 2 + 100, this.height / 2 - 126, 20, 20, "X"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
	    
	    if (button == this.z){
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    }
	}
	
	@Override
	public boolean doesGuiPauseGame() {
	    return false;
	}
}
