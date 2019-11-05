package Master_Cram.Master_Mod.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class NewArmor extends ItemArmor {

	public String itemMaterialName;
	
	public NewArmor(String itemMaterialName, String itemName, int durability, int[] defense, int enchantability, int renderIndex, int armorType) {
		super(EnumHelper.addArmorMaterial(itemName + "Material", durability, defense, enchantability), renderIndex, armorType);
		this.itemMaterialName = itemMaterialName;
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(this.armorType == 2) {
			return "mm:textures/models/armor/" + itemMaterialName + "_layer_2.png";
		}
		return "mm:textures/models/armor/" + itemMaterialName + "_layer_1.png";
	}
}
