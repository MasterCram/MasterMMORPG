package Master_Cram.Master_Mod.item;

import Master_Cram.Master_Mod.Master_Mod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NewRing extends Item {
	public NewRing() {
		this.setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World par3World, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		System.out.println("using ring");
    	if(!par3World.isRemote && par3World.getBlock(x, y, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")))
    	{
			if(par3World.getBlock(x, y, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x - 1, y, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x - 2, y + 1, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x - 2, y + 2, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x - 2, y + 3, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x + 1, y + 1, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x + 1, y + 2, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x + 1, y + 3, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x - 1, y + 4, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")) && par3World.getBlock(x, y + 4, z).equals(Master_Mod.itemManager.blockList.get("ironPortalFrame")))
			{
				for(int i = 0; i < 3; i++)
				{
					par3World.setBlock(x, y + 1 + i, z, Master_Mod.itemManager.ironPortal);
					par3World.setBlock(x - 1, y + 1 + i, z, Master_Mod.itemManager.ironPortal);
				}
				if(!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}
				return true;
			}
    	}
    	
    	return false;
    }
}
