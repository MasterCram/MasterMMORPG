package Master_Cram.Master_Mod.commands;

import java.util.ArrayList;
import java.util.List;

import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CommandChangeWorld implements ICommand {
	private final List aliases = new ArrayList();
	
	public CommandChangeWorld() {
			aliases.add("ChangeWorld");
			aliases.add("CW");
	}
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "ChangeWorld";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "ChangeWorld <WorldID>";
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] argString) {
		World world = sender.getEntityWorld(); 
	    
        if (world.isRemote) 
        { 
            System.out.println("Not processing on Client side"); 
        } 
        else 
        { 
            System.out.println("Processing on Server side"); 
            if(argString.length == 0) 
            { 
                sender.addChatMessage(new ChatComponentText("Invalid argument")); 
                return; 
            } 
    
            sender.addChatMessage(new ChatComponentText("ChangeWorld: [" + argString[0]  
                  + "]")); 
     
            
          EntityPlayerMP thePlayer = (EntityPlayerMP) sender.getEntityWorld().getPlayerEntityByName(sender.getCommandSenderName());
    		if(sender.getEntityWorld().getPlayerEntityByName(sender.getCommandSenderName()).dimension != Integer.parseInt(argString[0]))
    			thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Integer.parseInt(argString[0]) , new TeleporterArcana(thePlayer.mcServer.worldServerForDimension(References.ARCANA_DIM)));
    		
        } 
		
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
