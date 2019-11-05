package Master_Cram.Master_Mod.item.bonus;

import java.math.BigDecimal;
import java.util.ArrayList;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.item.Attribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public enum BonusLeggings {
	
	DEFAULT(new Attribute[] {}, 0, 1),
	COMMON(new Attribute[] {}, 0, 1),
	UNCOMMON(new Attribute[] {Attribute.EXP, Attribute.DURABILITY, Attribute.LIFE, Attribute.DEF, Attribute.MANA}, 2, 1),
	RARE(new Attribute[] {Attribute.EXP, Attribute.DURABILITY, Attribute.LIFE, Attribute.DEF, Attribute.MANA}, 3, 2),
	EPIC(new Attribute[] {Attribute.EXP, Attribute.DURABILITY, Attribute.LIFE, Attribute.DEF, Attribute.MANA}, 4, 3),
	LEGENDARY(new Attribute[] {Attribute.EXP, Attribute.DURABILITY, Attribute.LIFE, Attribute.DEF, Attribute.MANA}, 5, 4);
	
	public Attribute[] attributeList;
	public int nbAttribute;
	public float bonusMultiplicator;

	
	BonusLeggings(Attribute[] attributeList, int nbAttribute, float bonusMultiplicator){
		this.attributeList = attributeList;
		this.nbAttribute = nbAttribute;
		this.bonusMultiplicator = bonusMultiplicator;
	}
	
	public void addNewAttribute(EntityPlayer player, ItemStack stack, NBTTagCompound nbt) {
		//On crée 5 attributs par défaut
		for(int i = 1; i <= 5; i ++) {
			nbt.setString("bonusName" + Integer.toString(i), "None");
			nbt.setFloat("bonus" + Integer.toString(i), 0);
		}
		
		//On initialise les attributs
		if (nbt != null && nbt.getInteger("nbAttribute") >= 1)
		{
			ArrayList<Attribute> attList = new ArrayList<Attribute>();
			for(int i=0;i<this.attributeList.length;i++) {
				attList.add(this.attributeList[i]);
			}
			for(int i=1; i <= nbt.getInteger("nbAttribute"); i++) {
				int rand = Master_Mod.random.nextInt(attList.size());
				nbt.setString("bonusName" + Integer.toString(i), attList.get(rand).name);
				
				float rand2 = (Master_Mod.random.nextInt(100) + 1) * ((attList.get(rand).bonusMax * this.bonusMultiplicator) - (attList.get(rand).bonusMin * this.bonusMultiplicator)) / 100;
				BigDecimal roundRand2 = new BigDecimal(((attList.get(rand).bonusMin * this.bonusMultiplicator) + rand2)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
				nbt.setFloat("bonus" + Integer.toString(i), roundRand2.floatValue());
				if(attList.size() > 1)
					attList.remove(rand);
			}
		}
		
		//On classe les attributs
		
		for(int i = 1; i <= 5; i ++) {
			for(int j = 1; j<= 5; j++) {
				if(i != j  && !nbt.getString("bonusName" + Integer.toString(i)).equals("None") && !nbt.getString("bonusName" + Integer.toString(j)).equals("None")) {
					if(nbt.getString("bonusName" + Integer.toString(i)).equals(nbt.getString("bonusName" + Integer.toString(j)))) {
						nbt.setFloat("bonus" + Integer.toString(i), nbt.getFloat("bonus" + Integer.toString(i)) + nbt.getFloat("bonus" + Integer.toString(j)));
						nbt.setString("bonusName" + Integer.toString(j), "None");
						nbt.setFloat("bonus" + Integer.toString(j), 0);
					}
				}
			}
		}
		
	}

}
