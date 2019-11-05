package Master_Cram.Master_Mod.clan;

public enum ClanRank {
	
	none("none", 0), member("Member", 1), mod("Mod", 2), admin("Admin", 3), owner ("Owner", 4);
	
	public String name;
	public int id;
	
	ClanRank(String name, int id){
		this.name = name;
		this.id = id;
	}
}
