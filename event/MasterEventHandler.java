package Master_Cram.Master_Mod.event;

import java.util.Random;

import org.lwjgl.input.Mouse;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.block.IronOre;
import Master_Cram.Master_Mod.gui.GuiCustomPlayerInventory;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.MouseInputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class MasterEventHandler {
	
	@SubscribeEvent
	public void onEvent(BlockEvent.HarvestDropsEvent event) {
		
		//System.out.println("BlockEvent test");
		if(event.block.getUnlocalizedName().substring(5).equals("oreIron")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ironOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ironOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ironOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ironOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ironOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("silverOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("silverOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("silverOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("silverOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("silverOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("silverOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("oreGold")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("goldOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("goldOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("goldOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("goldOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("goldOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("oreDiamond")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("diamondOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("diamondOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("diamondOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("diamondOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("diamondOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("ramestOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ramestOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ramestOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ramestOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ramestOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("ramestOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("emrastOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("emrastOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("emrastOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("emrastOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("emrastOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("emrastOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("tresamOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("tresamOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("tresamOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("tresamOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("tresamOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("tresamOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("sarmetOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("sarmetOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("sarmetOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("sarmetOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("sarmetOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("sarmetOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("astremOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("astremOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("astremOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("astremOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("astremOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("astremOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("mertasOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("mertasOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("mertasOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("mertasOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("mertasOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("mertasOre2")));
			}
		} else if(event.block.getUnlocalizedName().substring(5).equals("masterOre")){
			event.drops.clear();
			int _random = Master_Mod.random.nextInt(5000);
			if(_random==0) {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("masterOre6")));
			} else if(_random > 0 && _random <=50){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("masterOre5")));
			} else if(_random > 50 && _random <=300){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("masterOre4")));
			} else if(_random > 300 && _random <=1500){
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("masterOre3")));
			} else {
				event.drops.add(new ItemStack(Master_Mod.itemManager.blockList.get("masterOre2")));
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
			ExtendedPlayer.register((EntityPlayer) event.entity);
		}
	}
}
