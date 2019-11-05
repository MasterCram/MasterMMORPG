package Master_Cram.Master_Mod.block;

import java.util.Random;

import Master_Cram.Master_Mod.item.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class NewBlock extends Block {

	public NewBlock(Material material) {
		super(material);
		this.setHardness(8F);
	}

	/*@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		if(!this.getUnlocalizedName().equals("tile.astremOre")) {
			return Item.getItemFromBlock(this);
		}
		int _random = random.nextInt(5000);
		if(_random==0) {
			return Item.getItemFromBlock(Master_mod.get);
		} else if(_random > 0 && _random <=50){
			return Item.getItemFromBlock(this);
		} else if(_random > 50 && _random <=300){
			return Item.getItemFromBlock(this);
		} else if(_random > 300 && _random <=1500){
			return Item.getItemFromBlock(this);
		} else {
			return Item.getItemFromBlock(this);
		}
	}*/
}
