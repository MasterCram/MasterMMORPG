package Master_Cram.Master_Mod.clan;

import java.util.ArrayList;
import java.util.List;

import Master_Cram.Master_Mod.player.ExtendedPlayer;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class Clan {
	
	private int id;
	private int level;
	private int maxPlayer;
	
	private String name;
	
	public String ownerName;
	
	public ArrayList<ExtendedPlayer> memberList;
	
	private float currentExp;
	private float NextLevelExp;
	
	public Clan(ExtendedPlayer player ,String name, int id) {
		memberList = new ArrayList<ExtendedPlayer>();
		this.id = id;
		this.name = name;
		this.addMember(player, ClanRank.owner);
		this.ownerName = player.player.getDisplayName();
		this.level = 1;
		this.NextLevelExp = 100;
		this.maxPlayer = 10;
	}
	
	public void addMember(ExtendedPlayer player, ClanRank rank) {
		this.memberList.add(player);
		player.setClanRank(rank);
	}
	
	public void removeMember(String playerName) {
		if(this.containMember(playerName)) {
			//if(getMemberWithID(playerID).getClanRankID() >=1 && getMemberWithID(playerID).getClanRankID() <=4) {
				ExtendedPlayer.get(getMemberWithName(playerName).player).setClanID(0);
				this.memberList.remove(getMemberWithName(playerName));
			//}
		}
	}
	
	public boolean containMember(String playerName) {
		for (ExtendedPlayer member : memberList) {
			if(member.player.getDisplayName().equals(playerName)) {
				//System.out.println("Joueur trouvé");
				return true;
			}
		}
		return false;
	}
	
	public ExtendedPlayer getMemberWithName(String playerName) {
		for (ExtendedPlayer member : memberList) {
			if(member.player.getDisplayName().equals(playerName))
				return member;
		}
		return null;
	}
	
	public int getMemberCount() {
		return this.memberList.size();
	}
	
	public int getMaxPlayer() {
		return this.maxPlayer;
	}
	
	/*public void promoteMember(ICommandSender playerSender, ExtendedPlayer playerPromoted) {
		if(playerPromoted.getClanRankID() >= 3)
		{
			playerSender.addChatMessage(new ChatComponentText("You can't promote this player any higher."));
			return;
		} else if(playerPromoted.getClanRankID() >= 1 && playerPromoted.getClanRankID()<=2) {
			playerPromoted.promote();
			playerSender.addChatMessage(new ChatComponentText("Succesfully promoted."));
		}
	}
	
	public void demoteMember(ICommandSender playerSender, ExtendedPlayer playerDemoted) {
		if(playerDemoted.getClanRankID() == 4)
		{
			playerSender.addChatMessage(new ChatComponentText("You can't demote this player."));
			return;
		} else if(playerDemoted.getClanRankID() >= 2 && playerDemoted.getClanRankID()<=3) {
			playerDemoted.demote();
			playerSender.addChatMessage(new ChatComponentText("Succesfully demoted."));
		}
	}*/
	
	public String getName() {
		return this.name;
	}

	public int getClanID() {
		return this.id;
	}
	
	public int getClanLevel() {
		return this.level;
	}
	
	public float getClanExp() {
		return this.currentExp;
	}
	
	public float getClanNextLevelExp() {
		return this.NextLevelExp;
	}
	
}
