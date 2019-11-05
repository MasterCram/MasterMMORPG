package Master_Cram.Master_Mod.clan;

import java.util.ArrayList;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.data.MasterWorldData;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class ClanManager {
	public ArrayList<Clan> clanList;
	
	public ClanManager() {
		this.clanList = new ArrayList<Clan>();
	}
	
	public void createClan(EntityPlayer player, String clanName) {
		MasterWorldData.get(player.getEntityWorld()).setClanCount(MasterWorldData.get(player.getEntityWorld()).getClanCount() + 1);
		if(!this.isClanExist(clanName)) {
			this.clanList.add(new Clan(ExtendedPlayer.get((EntityPlayer) player), clanName, MasterWorldData.get(player.getEntityWorld()).getClanCount() + 1));
		}
	}
	
	public boolean isClanExist(String clanName) {
		for(Clan clan : clanList) {
			if(clan.getName().equalsIgnoreCase(clanName))
				return true;
		}
		return false;
	}
	
	public boolean isClanExist(int clanID) {
		for(Clan clan : clanList) {
			if(clan.getClanID() == clanID)
				return true;
		}
		return false;
	}
	
	public boolean isMemberExist(String playerName) {
		for(Clan clan : clanList) {
			if(clan.containMember(playerName))
				return true;
		}
		return false;
	}
	
	public ExtendedPlayer clanMember(String playerName) {
		if(this.isMemberExist(playerName)) {
			for(Clan clan : clanList) {
				if(clan.containMember(playerName))
					return clan.getMemberWithName(playerName);
			}
		}
		return null;
	}
	
	public Clan clanWithMember(String playerName) {
		if(this.isMemberExist(playerName)) {
			for(Clan clan : clanList) {
				if(clan.containMember(playerName))
					return clan;
			}
		}
		return null;
	}
	
	public Clan clanWithName(String clanName) {
		for(Clan clan : clanList) {
			if(clan.getName().equalsIgnoreCase(clanName))
				return clan;
		}
		return null;
	}
	
	public void resetClans(ICommandSender playerSender) {
		this.clanList = new ArrayList<Clan>();
		MasterWorldData.get(playerSender.getEntityWorld()).setClanCount(0);
	}
	
	public void deleteClan(ICommandSender playerSender) {
		ExtendedPlayer player = ExtendedPlayer.get((EntityPlayer) playerSender);
		for(Clan clan : clanList) {
			if(clan.getClanID() == player.getClanID() && clan.getMemberWithName(player.player.getDisplayName()).getClanRankID() == 4) {
				clanList.remove(clan);
			}
		}
	}
	
	public void removePlayerWithName(String name) {
		for(Clan clan : clanList) {
			if(clan.containMember(name) && !name.equalsIgnoreCase(clan.ownerName)) {
				clan.removeMember(name);
			} else if(clan.containMember(name) && name.equalsIgnoreCase(clan.ownerName)) {
				clan.removeMember(name);
				if(clanList.size() == 1)
				{
					clanList = new ArrayList<Clan>();
					return;
				}
				else
					clanList.remove(clan);
			}
			
		}
	}
	

}
