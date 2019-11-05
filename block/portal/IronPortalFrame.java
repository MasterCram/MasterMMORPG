package Master_Cram.Master_Mod.block.portal;

import Master_Cram.Master_Mod.Master_Mod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IronPortalFrame extends Block {

	public IronPortalFrame(Material material) {
		super(material);
		this.blockHardness = 5.0F;
	}
	
	/*@Override
	 public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
	 {
		if(!world.isRemote && world.getBlock(x, y, z).equals(Master_Mod.itemManager.ironPortalFrame) && entity instanceof EntityPlayer)
    	{
			//System.out.println("Block Placed by player");
    	}
	 }*/
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metaData, float sideX, float sideY, float sideZ)
    {
    	if(!world.isRemote && world.getBlock(x, y, z).equals(Master_Mod.itemManager.ironPortalFrame))
    	{
    		if(world.getBlock(x, y, z).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x - 1, y, z).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x - 2, y + 1, z).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x - 2, y + 2, z).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x - 2, y + 3, z).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x + 1, y + 1, z).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x + 1, y + 2, z).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x + 1, y + 3, z).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x - 1, y + 4, z).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x, y + 4, z).equals(Master_Mod.itemManager.ironPortalFrame))
			{
				for(int i = 0; i < 3; i++)
				{
					world.setBlock(x, y + 1 + i, z, Master_Mod.itemManager.ironPortal);
					world.setBlock(x - 1, y + 1 + i, z, Master_Mod.itemManager.ironPortal);
				}
				System.out.println("Activating portal...");
				return true;
			} else if(world.getBlock(x, y, z).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x, y, z - 1).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x, y + 1, z - 2).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x, y + 2, z - 2).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x, y + 3, z - 2).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x, y + 1, z + 1).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x, y + 2, z + 1).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x, y + 3, z + 1).equals(Master_Mod.itemManager.ironPortalFrame) 
					&& world.getBlock(x, y + 4, z - 1).equals(Master_Mod.itemManager.ironPortalFrame) && world.getBlock(x, y + 4, z).equals(Master_Mod.itemManager.ironPortalFrame))
			{
				for(int i = 0; i < 3; i++)
				{
					world.setBlock(x, y + 1 + i, z, Master_Mod.itemManager.ironPortal);
					world.setBlock(x, y + 1 + i, z - 1, Master_Mod.itemManager.ironPortal);
				}
				System.out.println("Activating portal...");
				return true;
			}
    	}
        return false;
    }

}
