package Master_Cram.Master_Mod.event;

import Master_Cram.Master_Mod.References;
import Master_Cram.Master_Mod.item.NewSword;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import Master_Cram.Master_Mod.util.NBTHelper;
import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.BlockEvent;

public class SkillsEvent {

	
	@SubscribeEvent
	public void onEventBreakBlock(BlockEvent.BreakEvent event) {
		//TODO: Faire en sorte que le joueur ne gagne pas d'xp en créatif
		if(event.block != null)
		{
			ExtendedPlayer.get(event.getPlayer()).skills.mining.addXpFromBlock(event.getPlayer(), event.block);
			ExtendedPlayer.get(event.getPlayer()).skills.woodcutting.addXpFromBlock(event.getPlayer(), event.block);
			ExtendedPlayer.get(event.getPlayer()).skills.digging.addXpFromBlock(event.getPlayer(), event.block);
		}
		
	}
	
	@SubscribeEvent
	public void onEntityDamage(LivingHurtEvent event) {
		if(event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			ExtendedPlayer player = ExtendedPlayer.get((EntityPlayer) event.source.getSourceOfDamage());
			System.out.println(player.player.getDisplayName());
			if(event.entityLiving.getHealth() > event.ammount) {
				player.skills.combat.addExperience(event.ammount);
			}
			else
			{
				player.skills.combat.addExperience(event.entityLiving.getHealth());
			}
		}
	}
}
