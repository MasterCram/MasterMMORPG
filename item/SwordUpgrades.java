package Master_Cram.Master_Mod.item;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.UUID;

import com.google.common.collect.Multimap;

import Master_Cram.Master_Mod.util.NBTHelper;

public class SwordUpgrades {
	// The ID to use for the attack damage modifier. This can be used to look up the modifier in an ItemStack's NBT.
	public final static UUID MODIFIER_UUID = UUID.fromString("294093da-54f0-4c1b-9dbb-13b77534a84c");

	// Returns an ItemStack of the ItemSword with +30 attack damage
	public static void updateSwordDamage(ItemStack stack, NBTTagCompound nbt) {
		
		if(nbt != null) {
			NewSword newSword = (NewSword) ItemManager.toolList.get(stack.getItem().getUnlocalizedName().substring(5));
			nbt.setFloat("totalDamage", newSword.baseDamage + 4);
			nbt.setFloat("baseDamage", newSword.baseDamage + 4);
			for(int i = 1; i <= 5; i++) {
				if(nbt.getString("bonusName" + Integer.toString(i)).equals("Attack"))
				{
					nbt.setFloat("totalDamage", nbt.getFloat("totalDamage") + nbt.getFloat("bonus" + Integer.toString(i)));
					nbt.setFloat("addedDamage", nbt.getFloat("bonus" + Integer.toString(i)));
				}
			}
		}
		
		//System.out.println(nbt.getFloat("totalDamage"));
		// Using the ItemStack AttributeModifiers NBT completely replaces the ItemSword modifiers,
		// so we need to manually add the sword's damage to the total
		AttributeModifier attackModifier = new AttributeModifier(MODIFIER_UUID, "Weapon Upgrade", nbt.getFloat("totalDamage"), 0);
		NBTTagCompound modifierNBT = writeAttributeModifierToNBT(SharedMonsterAttributes.attackDamage, attackModifier);

		// Create the NBT structure needed by ItemStack#getAttributeModifiers
		//NBTTagCompound stackTagCompound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		list.appendTag(modifierNBT);
		nbt.setTag("AttributeModifiers", list);

		// Set the stack's NBT to the modifier structure
		stack.setTagCompound(nbt);

	}

	// Adapted from SharedMonsterAttributes. Also adds AttributeName tag required by ItemStack#getAttributeModifiers
	private static NBTTagCompound writeAttributeModifierToNBT(IAttribute attribute, AttributeModifier modifier) {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("AttributeName", attribute.getAttributeUnlocalizedName());
		nbttagcompound.setString("Name", modifier.getName());
		nbttagcompound.setDouble("Amount", modifier.getAmount());
		nbttagcompound.setInteger("Operation", modifier.getOperation());
		nbttagcompound.setLong("UUIDMost", modifier.getID().getMostSignificantBits());
		nbttagcompound.setLong("UUIDLeast", modifier.getID().getLeastSignificantBits());
		return nbttagcompound;
	}
	
}