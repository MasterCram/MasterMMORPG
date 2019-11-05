package Master_Cram.Master_Mod.commands;

import java.util.ArrayList;
import java.util.List;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.data.MasterWorldData;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import Master_Cram.Master_Mod.world.voidworld.TeleporterVoidWorld;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CommandsClan implements ICommand {
	private final List aliases = new ArrayList();
	
	public CommandsClan() {
			aliases.add("Clan");
			aliases.add("clan");
			aliases.add("c");
			aliases.add("C");
	}
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "clan";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "clan";
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
            return;
        } 
        else
        { 
            System.out.println("Processing on Server side"); 
            
            if(argString.length == 0) 
            { 
                sender.addChatMessage(new ChatComponentText("Invalid argument, please use: clan <create/join/leave/tp/list/reset>")); 
                return; 
            } else if(argString.length == 1 && argString[0].equalsIgnoreCase("create")) 
            { 
                sender.addChatMessage(new ChatComponentText("Invalid argument, please use: clan create <name>")); 
                return; 
            } else if(argString.length == 2 && argString[0].equalsIgnoreCase("create") && (argString[1].length() < 4 || argString[1].length() > 20)) 
            { 
                sender.addChatMessage(new ChatComponentText("Your clan name must be between 4 and 20 caracter long.")); 
                return; 
            } else if(argString.length == 1 && argString[0].equalsIgnoreCase("join")) 
            { 
                sender.addChatMessage(new ChatComponentText("Invalid argument, please use: clan join <name>")); 
                return;
            } else if(argString.length == 2 && Master_Mod.clanManager.isClanExist(argString[1]))
            {
            	sender.addChatMessage(new ChatComponentText("The clan name " + argString[1] + " is already in use"));
            	return;
            } else if(argString.length == 2 && (argString[0].equalsIgnoreCase("join") || argString[0].equalsIgnoreCase("create")) && Master_Mod.clanManager.isMemberExist(sender.getCommandSenderName()))
            {
            	sender.addChatMessage(new ChatComponentText("Please leave your clan before to do that."));
            	return;
            } else if(argString.length == 1 && (argString[0].equalsIgnoreCase("tp") || argString[0].equalsIgnoreCase("leave")) && !Master_Mod.clanManager.isMemberExist(sender.getCommandSenderName()))
            {
            	sender.addChatMessage(new ChatComponentText("You need a clan to use that command."));
            	return;
            }
    
            
            // Clan create
            if (argString.length == 2 && argString[0].equalsIgnoreCase("create") && !argString[1].isEmpty())
            {
            	//MasterWorldData.get(world).resetClans();
            	Master_Mod.clanManager.createClan((EntityPlayer) sender, argString[1]);
            	sender.addChatMessage(new ChatComponentText("You created the clan " + argString[1]));
		        
            }
            
            // Clan tp TODO
            if(argString.length == 1 && argString[0].equalsIgnoreCase("tp")) {
            	EntityPlayerMP thePlayer = (EntityPlayerMP) sender.getEntityWorld().getPlayerEntityByName(sender.getCommandSenderName());
		        //if(sender.getEntityWorld().getPlayerEntityByName(sender.getCommandSenderName()).dimension != Integer.parseInt(argString[0]))
		        thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, References.VOID_WORLD , new TeleporterVoidWorld(thePlayer.mcServer.worldServerForDimension(References.VOID_WORLD)));
            	sender.addChatMessage(new ChatComponentText("You teleported to your clan"));
            }
            
            // Clan join TODO
            
            if(argString.length == 2 && argString[0].equalsIgnoreCase("join")) {
            	//sender.addChatMessage(new ChatComponentText("You joined the clan " + argString[1]));
            }
            
            // Clan leave TODO
            
            if(argString.length == 1 && argString[0].equalsIgnoreCase("leave")) {
            	Master_Mod.clanManager.removePlayerWithName(ExtendedPlayer.get((EntityPlayer) sender).player.getDisplayName());
            	sender.addChatMessage(new ChatComponentText("You left your clan"));
            	// TODO Tp to spawn
            }
            
            // Clan reset
            
            if(argString.length == 1 && argString[0].equalsIgnoreCase("reset")) {
            	Master_Mod.clanManager.resetClans(sender);
            	sender.addChatMessage(new ChatComponentText("All the clan have been reset"));
            }
            
            // Clan list
            
            if(argString.length == 1 && argString[0].equalsIgnoreCase("list")) {
            	//sender.addChatMessage(new ChatComponentText(Master_Mod.clanManager.clanList()));
            }
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
