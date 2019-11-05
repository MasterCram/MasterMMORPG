package Master_Cram.Master_Mod.gui;

import org.lwjgl.opengl.GL11;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.clan.Clan;
import Master_Cram.Master_Mod.clan.ClanRank;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.world.voidworld.TeleporterVoidWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class ClanGui extends GuiScreen {
	public GuiButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,z;
	
	private GuiTextField text;
	
	private int interfaceID = -1;
	
	int guiWidth = 256;
	int guiHeight = 256;
	
	private ExtendedPlayer extendedPlayer;
	private Clan clan;
	private boolean haveClan;
	private String playerName;
	private boolean error = false;
	private String errMessage;
	
	
	public ClanGui(String playerName) {
		this.playerName = playerName;
		this.extendedPlayer = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if(Master_Mod.clanManager.isMemberExist(playerName)) {
			this.clan = Master_Mod.clanManager.clanWithMember(playerName);
			this.haveClan = true;
			if(this.interfaceID == -1)
				this.interfaceID = 0;
		} else {
			this.haveClan = false;
		}
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		this.drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation("mm","textures/gui/ClanTab.png"));
	    drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
	    
	    if(this.haveClan) {
	    	this.a.visible = true;
	    	this.b.visible = true;
	    	this.c.visible = true;
	    	this.d.visible = true;
	    	this.e.visible = true;
	    	this.f.visible = true;
	    	
	    	this.g.visible = false;
	    	this.h.visible = false;
	    	this.i.visible = false;
	    } else {
	    	this.a.visible = false;
	    	this.b.visible = false;
	    	this.c.visible = false;
	    	this.d.visible = false;
	    	this.e.visible = false;
	    	this.f.visible = false;
	    	
	    	this.g.visible = true;
	    	this.h.visible = true;
	    	this.i.visible = true;
	    }
	    
	    if(this.interfaceID == 6) {
	    	this.drawString(fontRendererObj,"\247eEnter the clan name:", width / 2, height / 2 - 66, 0);
	    	this.text.setFocused(true);
	    	this.text.drawTextBox();
	    	
	    	this.j.visible = true;
	    } else {
	    	this.j.visible = false;
	    }
	    
	    if(this.interfaceID == 7) {
	    	this.drawString(fontRendererObj,"\247eEnter the clan name:", width / 2, height / 2 - 66, 0);
	    	this.text.setFocused(true);
	    	this.text.drawTextBox();
	    	this.m.visible = true;
	    } else {
	    	this.m.visible = false;
	    }
	    
	    if(this.interfaceID == 0) {
	    	this.drawString(fontRendererObj,"\247fName: \247e" + this.clan.getName(), width / 2 - 10, height / 2 - 66, 0);
	    	this.drawString(fontRendererObj,"\247fLevel: \247e" + this.clan.getClanLevel(), width / 2 - 10, height / 2 - 56, 0);
	    	this.drawString(fontRendererObj,"\247fExp: \247e" + this.clan.getClanExp() + " / " + this.clan.getClanNextLevelExp(), width / 2 - 10, height / 2 - 46, 0);
	    	this.drawString(fontRendererObj,"\247fMember: \247e" + this.clan.getMemberCount() + " / " + this.clan.getMaxPlayer(), width / 2 - 10, height / 2 - 36, 0);
	    	this.drawString(fontRendererObj,"\247fRank: \247e" + this.extendedPlayer.clanRank.name, width / 2 - 10, height / 2 - 26, 0);
	    }
	    
	    if(this.interfaceID == 1) {
	    	for(int i = 0; i < this.clan.getMemberCount(); i++) {
	    		this.drawString(fontRendererObj,"\247f" + this.clan.memberList.get(i).clanRank.name + ": \247e" + this.clan.memberList.get(i).player.getDisplayName(), width / 2 - 10, height / 2 - 66 + (i * 10), 0);
	    	}
	    }
	    
	    if(this.interfaceID == 8) {
	    	for(int i = 0; i < Master_Mod.clanManager.clanList.size(); i++) {
	    		this.drawString(fontRendererObj,"\247f" + (i + 1) + ": \247e" + Master_Mod.clanManager.clanList.get(i).getName() + " (" + Master_Mod.clanManager.clanList.get(i).getMemberCount() + "/" + Master_Mod.clanManager.clanList.get(i).getMaxPlayer() + ")", width / 2 - 15, height / 2 - 66 + (i * 10), 0);
	    	}
	    }
	    
	    if(this.interfaceID == 4) {
	    	for(int i = 0; i < Master_Mod.clanManager.clanList.size(); i++) {
	    		this.drawString(fontRendererObj,"\247f" + (i + 1) + ": \247e" + Master_Mod.clanManager.clanList.get(i).getName() + " (" + Master_Mod.clanManager.clanList.get(i).getMemberCount() + "/" + Master_Mod.clanManager.clanList.get(i).getMaxPlayer() + ")", width / 2 - 15, height / 2 - 66 + (i * 10), 0);
	    	}
	    }
	    
	    if(this.interfaceID == 2) {
	    	this.k.visible = true;
	    } else {
	    	this.k.visible = false;
	    }
	    
	    if(this.interfaceID == 5) {
	    	this.l.visible = true;
	    	this.drawString(fontRendererObj,"\247cAre you sure you want", width / 2 - 6, height / 2 - 66, 0);
	    	this.drawString(fontRendererObj,((this.extendedPlayer.clanRank == ClanRank.owner) ? "\247cto disband your clan?" : "\247cto leave your clan?"), width / 2 - 6, height / 2 - 56, 0);
	    } else {
	    	this.l.visible = false;
	    }
	    
	    
	    
	    if(this.error)
    		this.drawString(fontRendererObj,"\247c" + this.errMessage, width / 2 - (this.errMessage.length()*5/2), height / 2 - 95, 0);
	    
	    	
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
			
		this.buttonList.add(this.a = new GuiButton(0, this.width / 2 - 105, this.height / 2 - 70, 60, 20, "Info"));
		this.buttonList.add(this.b = new GuiButton(1, this.width / 2 - 105, this.height / 2 - 37, 60, 20, "Member"));
		this.buttonList.add(this.c = new GuiButton(2, this.width / 2 - 105, this.height / 2 - 4, 60, 20, "Teleports"));
		this.buttonList.add(this.d = new GuiButton(3, this.width / 2 - 105, this.height / 2 + 29, 60, 20, "Shop"));
		this.d.enabled = false;
		this.buttonList.add(this.e = new GuiButton(4, this.width / 2 - 105, this.height / 2 + 62, 60, 20, "List"));
		this.buttonList.add(this.f = new GuiButton(5, this.width / 2 - 105, this.height / 2 + 95, 60, 20, ((this.extendedPlayer.clanRank == ClanRank.owner) ? "Config" : "Leave")));
		    
		    
		    
		this.buttonList.add(this.g = new GuiButton(6, this.width / 2 - 105, this.height / 2 - 70, 60, 20, "Create"));
		this.buttonList.add(this.h = new GuiButton(7, this.width / 2 - 105, this.height / 2 - 37, 60, 20, "Join"));
		this.buttonList.add(this.i = new GuiButton(8, this.width / 2 - 105, this.height / 2 - 4, 60, 20, "List"));
			
		
			
		this.buttonList.add(this.j = new GuiButton(9, this.width / 2 + 20, this.height / 2 - 15, 60, 20, "Create"));
		this.j.visible = false;
		
		this.buttonList.add(this.k = new GuiButton(10, this.width / 2 + 20, this.height / 2 + 10, 60, 20, "Clan TP"));
		this.k.visible = false;
		
		this.buttonList.add(this.l = new GuiButton(11, this.width / 2 + 20, this.height / 2 - 15, 60, 20, ((this.extendedPlayer.clanRank == ClanRank.owner) ? "\247cDisband" : "\247cYes, leave")));
		this.l.visible = false;
		
		this.buttonList.add(this.m = new GuiButton(12, this.width / 2 + 20, this.height / 2 - 15, 60, 20, "Join"));
		this.m.visible = false;
		
		this.text = new GuiTextField(this.fontRendererObj, this.width / 2 + 1, this.height / 2 - 46, 100, 20);
        text.setMaxStringLength(15);
        text.setText("");
		
        
	    this.buttonList.add(this.z = new GuiButton(99, this.width / 2 + 100, this.height / 2 - 126, 20, 20, "X"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		
		if (button == this.b) {
	    	this.interfaceID = 1;
	    }
		
		if (button == this.c) {
	    	this.interfaceID = 2;
	    }
		
		if (button == this.f) {
	    	this.interfaceID = 5;
	    }
		
		if (button == this.i) {
	    	this.interfaceID = 8;
	    }
		
		if (button == this.e) {
	    	this.interfaceID = 4;
	    }
		
		if (button == this.k) {
	       /* this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    	EntityPlayerMP thePlayer = (EntityPlayerMP) this.extendedPlayer.player.getEntityWorld().getPlayerEntityByName(Minecraft.getMinecraft().thePlayer.getDisplayName());
	        thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, References.VOID_WORLD , new TeleporterVoidWorld(thePlayer.mcServer.worldServerForDimension(References.VOID_WORLD)));*/
	        this.extendedPlayer.player.addChatMessage(new ChatComponentText("Coming soon!"));
	    }
		
		if (button == this.l) {
			this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
			Master_Mod.clanManager.removePlayerWithName(this.playerName);
        	this.extendedPlayer.player.addChatMessage(new ChatComponentText("You left your clan"));
		}
		
		
	    if (button == this.g) {
	    	this.interfaceID = 6;

	    }
	    
	    if (button == this.h) {
	    	this.interfaceID = 7;

	    }
	    
	    if (button == this.j) {
	    	String newClanName = this.text.getText();
	    	if(!Master_Mod.clanManager.isClanExist(newClanName)) {
	    		Master_Mod.clanManager.createClan(this.extendedPlayer.player, newClanName);
	    		this.interfaceID = 0;
	    		this.error = false;
	    		this.j.visible = false;
	    		this.mc.displayGuiScreen(null);
		        if (this.mc.currentScreen == null)
		            this.mc.setIngameFocus();
		        this.extendedPlayer.player.addChatMessage(new ChatComponentText("You created the clan " + newClanName));
	    	} else {
	    		this.error = true;
	    		this.errMessage = "This clan name is already in use";
	    	}
	    }
	    
	    if (button == this.m) {
	    	String clanToJoin = this.text.getText();
	    	if(Master_Mod.clanManager.isClanExist(clanToJoin)) {
	    		Master_Mod.clanManager.clanWithName(clanToJoin).addMember(this.extendedPlayer, ClanRank.member);
	    		this.interfaceID = 0;
	    		this.error = false;
	    		this.h.visible = false;
	    	} else {
	    		this.error = true;
	    		this.errMessage = "This clan doesn't exist";
	    	}
	    }
	    
	    if (button == this.a) {
	    	this.interfaceID = 0;
	    }
	    
	    
	    
	    
	    if (button == this.z){
	        this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
	    }
	}
	
	@Override
	protected void keyTyped(char par1, int par2) {
		super.keyTyped(par1, par2);
		if(this.interfaceID == 6 || this.interfaceID == 7) {
			this.text.textboxKeyTyped(par1, par2);
		}
	}
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        if(this.interfaceID == 6 || this.interfaceID == 7) {
        	this.text.updateCursorCounter();
        }
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x, y, btn);
        if(this.interfaceID == 6 || this.interfaceID == 7) {
        	this.text.mouseClicked(x, y, btn);
        }
    }
	
	@Override
	public boolean doesGuiPauseGame() {
	    return false;
	}
}

