package Master_Cram.Master_Mod.util;

import java.util.Random;

import Master_Cram.Master_Mod.item.bonus.BonusAxe;
import Master_Cram.Master_Mod.item.bonus.BonusBoots;
import Master_Cram.Master_Mod.item.bonus.BonusChestplate;
import Master_Cram.Master_Mod.item.bonus.BonusHelmet;
import Master_Cram.Master_Mod.item.bonus.BonusHoe;
import Master_Cram.Master_Mod.item.bonus.BonusLeggings;
import Master_Cram.Master_Mod.item.bonus.BonusPickaxe;
import Master_Cram.Master_Mod.item.bonus.BonusShovel;
import Master_Cram.Master_Mod.item.bonus.BonusSword;
import net.minecraft.nbt.NBTTagCompound;

public enum Rarity {	
	
	DEFAULT("§f", 1 , 0, BonusSword.DEFAULT, BonusPickaxe.DEFAULT, BonusAxe.DEFAULT, BonusShovel.DEFAULT, BonusHoe.DEFAULT, BonusHelmet.DEFAULT, BonusChestplate.DEFAULT, BonusLeggings.DEFAULT, BonusBoots.DEFAULT),
	COMMON("§f", 0.744 , 0, BonusSword.COMMON, BonusPickaxe.COMMON, BonusAxe.COMMON, BonusShovel.COMMON, BonusHoe.COMMON, BonusHelmet.COMMON, BonusChestplate.COMMON, BonusLeggings.COMMON, BonusBoots.COMMON),
	UNCOMMON("§9", 0.2 , 1, BonusSword.UNCOMMON, BonusPickaxe.UNCOMMON, BonusAxe.UNCOMMON, BonusShovel.UNCOMMON, BonusHoe.UNCOMMON, BonusHelmet.UNCOMMON, BonusChestplate.UNCOMMON, BonusLeggings.UNCOMMON, BonusBoots.UNCOMMON),
	RARE("§e", 0.05 , 2, BonusSword.RARE, BonusPickaxe.RARE, BonusAxe.RARE, BonusShovel.RARE, BonusHoe.RARE, BonusHelmet.RARE, BonusChestplate.RARE, BonusLeggings.RARE, BonusBoots.RARE),
	EPIC("§d", 0.005 , 3, BonusSword.EPIC, BonusPickaxe.EPIC, BonusAxe.EPIC, BonusShovel.EPIC, BonusHoe.EPIC, BonusHelmet.EPIC, BonusChestplate.EPIC, BonusLeggings.EPIC, BonusBoots.EPIC),
	LEGENDARY("§6", 0.001 , 4, BonusSword.LEGENDARY, BonusPickaxe.LEGENDARY, BonusAxe.LEGENDARY, BonusShovel.LEGENDARY, BonusHoe.LEGENDARY, BonusHelmet.LEGENDARY, BonusChestplate.LEGENDARY, BonusLeggings.LEGENDARY, BonusBoots.LEGENDARY);
	
	public String color;
	public double chance;
	public double bonusMultiplicator;
	public BonusSword bonusSword;
	public BonusPickaxe bonusPickaxe;
	public BonusAxe bonusAxe;
	public BonusShovel bonusShovel;
	public BonusHoe bonusHoe;
	public BonusHelmet bonusHelmet;
	public BonusChestplate bonusChestplate;
	public BonusLeggings bonusLeggings;
	public BonusBoots bonusBoots;

	
	Rarity(String color, double chance, double bonusMultiplicator, BonusSword bonusSword, BonusPickaxe bonusPickaxe, BonusAxe bonusAxe, BonusShovel bonusShovel, BonusHoe bonusHoe, BonusHelmet bonusHelmet, BonusChestplate bonusChestplate, BonusLeggings bonusLeggings, BonusBoots bonusBoots){
		this.color = color;
		this.chance = chance;
		this.bonusMultiplicator = bonusMultiplicator;
		this.bonusSword = bonusSword;
		this.bonusPickaxe = bonusPickaxe;
		this.bonusAxe = bonusAxe;
		this.bonusShovel = bonusShovel;
		this.bonusHoe = bonusHoe;
		this.bonusHelmet = bonusHelmet;
		this.bonusChestplate = bonusChestplate;
		this.bonusLeggings = bonusLeggings;
		this.bonusBoots = bonusBoots;
	}
	
	public static Rarity getRarity(NBTTagCompound nbt)
	{
		return nbt != null && nbt.hasKey("RARITY") ? Rarity.values()[nbt.getInteger("RARITY")] : DEFAULT;
	}
	
	public static void setRarity(NBTTagCompound nbt, Rarity rarity)
	{
		if (nbt != null)
		{
			nbt.setInteger("RARITY", rarity.ordinal());
		}
	}
	
}
