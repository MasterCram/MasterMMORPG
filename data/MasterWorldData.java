package Master_Cram.Master_Mod.data;

import Master_Cram.Master_Mod.Master_Mod;
import Master_Cram.Master_Mod.clan.Clan;
import Master_Cram.Master_Mod.player.ExtendedPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;
import scala.Int;

public class MasterWorldData extends WorldSavedData {

	private static final String IDENTIFIER = "MasterData";
	
	private int clanCount;
	
	public MasterWorldData() {
		super(IDENTIFIER);
	}
	
	public MasterWorldData(String identifier) {
		super(identifier);
	}
	
	public void setClanCount(int clanCount) {
		this.clanCount = clanCount;
		this.markDirty();
	}
	
	public int getClanCount() {
		return this.clanCount;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		clanCount = nbt.getInteger("clanCount");
		// TODO: Lire tout les informations..
		/*for(int i=0;i<clanCount;i++) {
			if(nbt.getString("clanNameList" + Integer.toString(i)) != null)
			{
				Master_Mod.clanManager.clanList.add(e) = nbt.getString("clanNameList" + Integer.toString(i));
				//System.out.println("Loaded clan name " + clanNameList[i]);
			}
		}*/
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("clanCount", clanCount);
		// TODO: Enregistrer tout les informations à l'intérieur du clan (Nom, ID, liste de membres, ect...)
		/*if(Master_Mod.clanManager.clanList != null)
		{
			for(Clan clan : Master_Mod.clanManager.clanList) {
				nbt.setString("clanNameList" + clan.getClanID(), Integer.toString(clan.getClanID()));
			}
				
				//System.out.println("Sucessfully saved Clan #" + i + nbt.getString("clanNameList" + Integer.toString(i)));
		}*/
	}

	
	public static MasterWorldData get(World world) {
		/*MapStorage storage = world.mapStorage;
		MasterWorldData data = (MasterWorldData) storage.loadData(MasterWorldData.class, IDENTIFIER);*/
		MasterWorldData data = (MasterWorldData) world.loadItemData(MasterWorldData.class, IDENTIFIER);
		if (data == null) {
			data = new MasterWorldData();
			world.setItemData(IDENTIFIER, data);
		}
		return data;
	}

}