package Master_Cram.Master_Mod.skill;

import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.util.NBTHelper;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DiggingSkill extends TemplateSkill {

	public DiggingSkill(String name, int id, float xpRate) {
		super(name, id, xpRate);
	}



	public Object[][] blockXp = new Object[][] {
		{"dirt", 5},
		{"sand", 5},
		{"grass", 5},
		{"snow", 5},
		{"gravel", 5}
	};
	
	

	public void addXpFromBlock(EntityPlayer player, Block block){
		if(!player.capabilities.isCreativeMode)
		{
			if(player.getCurrentEquippedItem() != null)
			{
				if(player.getCurrentEquippedItem().getItem() instanceof ItemSpade)
				{
					for(int i=0; i<blockXp.length; i++) {
						if(block.getUnlocalizedName().substring(5).equals(blockXp[i][0])) {
							ExtendedPlayer.get(player).skills.digging.addExperience((Integer) blockXp[i][1]);
						}
					}
				}
			}
		}
	}
}
