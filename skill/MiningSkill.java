package Master_Cram.Master_Mod.skill;

import Master_Cram.Master_Mod.player.ExtendedPlayer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ChatComponentText;

public class MiningSkill extends TemplateSkill {
	
	public MiningSkill(String name, int id, float xpRate) {
		super(name, id, xpRate);
	}

	public Object[][] blockXp = new Object[][] {
		{"stone", 1},
		{"oreCoal", 5},
		{"oreIron", 15},
		{"oreRedstone", 20},
		{"silverOre", 25},
		{"oreGold", 50},
		{"oreDiamond", 100},
		{"ramestOre", 225},
		{"emrastOre", 400},
		{"tresamOre", 625},
		{"sarmetOre", 850},
		{"astremOre", 1000},
		{"mertasOre", 1375},
		{"masterOre", 1850}
	};

	public void addXpFromBlock(EntityPlayer player, Block block){
		if(!player.capabilities.isCreativeMode)
		{
			if(player.getCurrentEquippedItem() != null)
			{
				if(player.getCurrentEquippedItem().getItem() instanceof ItemPickaxe)
				{
					for(int i=0; i<blockXp.length; i++) {
						if(block.getUnlocalizedName().substring(5).equals(blockXp[i][0])) {
							ExtendedPlayer.get(player).skills.mining.addExperience((Integer) blockXp[i][1]);
							ExtendedPlayer.get(player).player.addChatMessage(new ChatComponentText("You got " + (Integer) blockXp[i][1] + " mining xp!"));
						}
					}
				}
			}
		}
	}
}
