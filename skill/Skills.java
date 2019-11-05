package Master_Cram.Master_Mod.skill;

import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Skills {
	
	public static final String SKILL_TAG_NAME = "SkillTag";
	
	public CombatSkill combat = new CombatSkill("Combat", References.COMBAT_SKILL_ID, 1.0F);
	public MiningSkill mining = new MiningSkill("Mining", References.MINING_SKILL_ID, 1.0F);
	public SmithingSkill smithing = new SmithingSkill("Smithing", References.SMITHING_SKILL_ID, 1.0F);
	public WoodcuttingSkill woodcutting = new WoodcuttingSkill("Woodcutting", References.WOODCUTTING_SKILL_ID, 1.0F);
	public DiggingSkill digging = new DiggingSkill("Digging", References.DIGGING_SKILL_ID, 1.0F);
	public FarmingSkill farming = new FarmingSkill("Farming", References.FARMING_SKILL_ID, 1.0F);
	public CookingSkill cooking = new CookingSkill("Cooking", References.COOKING_SKILL_ID, 1.0F);
	public SlayerSkill slayer = new SlayerSkill("Slayer", References.SLAYER_SKILL_ID, 1.0F);
	public CraftingSkill crafting = new CraftingSkill("Crafting", References.CRAFTING_SKILL_ID, 1.0F);
	
	public int skillCount = 9;
	
	public void saveToNBT(NBTTagCompound nbt) {
		if(nbt != null)
		{
			NBTTagList items = new NBTTagList();
			
			//mining
			for(int i=0; i< skillCount; i++)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Skill", (byte) i);
				//item.setInteger("Experience", this.getExperience(i));
				item.setFloat("Experience", this.getSkill(i).getExperience());
				item.setInteger("Level", this.getSkill(i).getLevel());
				items.appendTag(item);
			}
			nbt.setTag(SKILL_TAG_NAME, items);
		}
	}
	
	public void loadFromNBT(EntityPlayer player,NBTTagCompound nbt) {
		if(nbt != null)
		{
			NBTTagList items = nbt.getTagList(SKILL_TAG_NAME, nbt.getId());
			//mining
			for(int i=0; i<skillCount; i++)
			{
				NBTTagCompound item = items.getCompoundTagAt(i);
				this.getSkill(i).setExperience(item.getFloat("Experience"));
				this.getSkill(i).setLevel(item.getInteger("Level"));
			}
		}
	}
	
	public TemplateSkill getSkill(int id) {
		if (id == References.COOKING_SKILL_ID)
			return this.cooking;
		else if (id == References.CRAFTING_SKILL_ID)
			return this.crafting;
		else if (id == References.DIGGING_SKILL_ID)
			return this.digging;
		else if (id == References.FARMING_SKILL_ID)
			return this.farming;
		else if (id == References.MINING_SKILL_ID)
			return this.mining;
		else if (id == References.SLAYER_SKILL_ID)
			return this.slayer;
		else if (id == References.WOODCUTTING_SKILL_ID)
			return this.woodcutting;
		else if (id == References.SMITHING_SKILL_ID)
			return this.smithing;
		else if (id == References.COMBAT_SKILL_ID)
			return this.combat;
		else
			return null;
	}
}
