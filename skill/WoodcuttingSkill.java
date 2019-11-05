package Master_Cram.Master_Mod.skill;

import Master_Cram.Master_Mod.player.ExtendedPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class WoodcuttingSkill extends TemplateSkill {

	public WoodcuttingSkill(String name, int id, float xpRate) {
		super(name, id, xpRate);
	}

	public Object[][] blockXp = new Object[][] {
		{"log", 15}
	};

	public void addXpFromBlock(EntityPlayer player, Block block){
		if(!player.capabilities.isCreativeMode)
		{
			if(player.getCurrentEquippedItem() != null)
			{
				if(player.getCurrentEquippedItem().getItem() instanceof ItemAxe)
				{
					for(int i=0; i<blockXp.length; i++) {
						if(block.getUnlocalizedName().substring(5).equals(blockXp[i][0])) {
							ExtendedPlayer.get(player).skills.woodcutting.addExperience((Integer) blockXp[i][1]);
						}
					}
				}
			}
		}
	}
}
