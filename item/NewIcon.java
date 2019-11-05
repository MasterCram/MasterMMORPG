package Master_Cram.Master_Mod.item;

import Master_Cram.Master_Mod.Master_Mod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class NewIcon extends Item {

	public NewIcon() {
		this.setMaxStackSize(1);
	}
	
	 @SideOnly(Side.CLIENT)
	    public static IIcon getIcon(int type)
	    {
	        switch (type)
	        {
	            case 0:
	                return Master_Mod.itemManager.iconList.get("emptyAmuletIcon").itemIcon;
	            case 1:
	                return Master_Mod.itemManager.iconList.get("emptyRingIcon").itemIcon;
	            case 2:
	            	return Master_Mod.itemManager.iconList.get("emptyBackpackIcon").itemIcon;
	            case 3:
	            	return Master_Mod.itemManager.iconList.get("emptyLockIcon").itemIcon;
	            default:
	                return null;
	        }
	    }
}
