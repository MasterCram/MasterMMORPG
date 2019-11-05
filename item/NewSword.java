package Master_Cram.Master_Mod.item;

import Master_Cram.Master_Mod.util.NBTHelper;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;

public class NewSword extends ItemSword {
	
	public float baseDamage;
	public float addedDamage;
	public float totalDamage;
	
	public String name;
	public int harvestLevel;
	public int maxUses;
	public float efficiency;
	public float enchantability;

	public NewSword(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
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
		nbt.setFloat("totalDamage", nbt.getFloat("baseDamage"));
		nbt.setFloat("addedDamage", 0);
		if(nbt != null) {
			for(int i = 1; i <= 5; i++) {
				if(nbt.getString("bonusName" + Integer.toString(i)).equals("Attack"))
				{
					addedDamage = nbt.getFloat("bonus" + Integer.toString(i));
					totalDamage = nbt.getFloat("baseDamage") + nbt.getFloat("addedDamage");
					nbt.setFloat("totalDamage", totalDamage);
					nbt.setFloat("addedDamage", addedDamage);
				}
			}
		}
		
		return nbt.getFloat("totalDamage");
	}

}
