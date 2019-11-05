package Master_Cram.Master_Mod.skill;

import java.math.BigDecimal;

import Master_Cram.Master_Mod.player.ExtendedPlayer;

public class TemplateSkill {

	private int id;
	private float nextLevelExperience;
	private float currentExperience;
	private int level = 1;
	private float xpRate;
	private String name;
	
	public TemplateSkill(String name, int id, float xpRate) {
		this.id = id;
		this.nextLevelExperience = this.getNextLevelExperience(this.level);
		this.xpRate = xpRate;
		this.name = name;
	}
	
	public void addExperience(float experience) {
		this.currentExperience += (experience) * this.xpRate;
		checkLevelUp();
		BigDecimal roundXpRate = new BigDecimal((Float) (experience) * this.xpRate).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		System.out.print("+ " + roundXpRate.floatValue() + " " + name + " xp (" + this.getExperience() + "/" + this.nextLevelExperience + " xp)\n");
	}
	
	public float getExperience() {
		BigDecimal bigDecimal = new BigDecimal((Float) this.currentExperience).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return bigDecimal.floatValue();
	}
	
	public int getNextLevelExperience() {
		return this.getNextLevelExperience(this.level);
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public float getXpRate() {
		return this.xpRate;
	}
	
	public void setXpRate(float xpRate) {
		this.xpRate = xpRate;
	}
	
	public void setExperience(float experience) {
		this.currentExperience = experience;
	}
	
	public void setLevel(int level) {
		this.level = level;
		this.nextLevelExperience = getNextLevelExperience(level);
	}
	
	public void checkLevelUp() {
		if(this.currentExperience >= this.nextLevelExperience) {
			levelUp();
		}
	}
	
	public void levelUp() {
		this.level += 1;
		this.nextLevelExperience = getNextLevelExperience(level);
		System.out.print("Level up! You are now level " + this.level + " " + this.name + "!\n");
	}
	
	public int getNextLevelExperience(int level) {
		return (this.level * this.level) * 200;
	}
}
