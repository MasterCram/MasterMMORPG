package Master_Cram.Master_Mod.item;

public enum Attribute {

	DEFAULT("None", 0, 0),
	ATTACK("Attack", 0.50F, 1F),
	EXP("Exp. %", 1F, 5F),
	LIFE("Life", 0.5F, 1F),
	MANA("Mana", 0.5F, 1F),
	DEF("Def.", 0.5F, 1F),
	EFFICIENCY("Eff.", 0.5F, 1F),
	DURABILITY("Dura.", 50F, 100F);
	
	public String name;
	public float bonusMin;
	public float bonusMax;
	
	Attribute(String name, float bonusMin, float bonusMax){
		this.name = name;
		this.bonusMin = bonusMin;
		this.bonusMax = bonusMax;
	}
}
