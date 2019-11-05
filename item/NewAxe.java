package Master_Cram.Master_Mod.item;

import Master_Cram.Master_Mod.util.NBTHelper;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.EnumHelper;

public class NewAxe extends ItemPickaxe {
	
	public float baseDamage;
	public float addedDamage;
	public float totalDamage;
	
	public String name;
	public int harvestLevel;
	public int maxUses;
	public float efficiency;
	public float enchantability;

	public NewAxe(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		super(EnumHelper.addToolMaterial(name + "ToolMaterial", harvestLevel, maxUses, efficiency, damage, enchantability));
		this.baseDamage = damage;
		this.name = name;
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.enchantability = enchantability;
	}
	
	public float getActualDamage(ItemStack stack) {
		NBTTagCompound nbt = NBTHelper.loadStackNBT(stack);
		nbt.setFloat("totalDamage", baseDamage);
		nbt.setFloat("addedDamage", 0);
		if(nbt != null) {
			for(int i = 1; i <= 5; i++) {
				if(nbt.getString("bonusName" + Integer.toString(i)).equals("Attack"))
				{
					addedDamage = nbt.getFloat("bonus" + Integer.toString(i));
					totalDamage = baseDamage + addedDamage;
					nbt.setFloat("totalDamage", nbt.getFloat("bonus" + Integer.toString(i)) + baseDamage);
					nbt.setFloat("addedDamage", addedDamage);
				}
			}
		}
		
		return nbt.getFloat("totalDamage");
	}
}