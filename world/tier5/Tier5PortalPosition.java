package Master_Cram.Master_Mod.world.tier5;

import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import net.minecraft.util.ChunkCoordinates;

public class Tier5PortalPosition extends ChunkCoordinates {
	
    public long seed;
    private final TeleporterTier5 teleporter;

    public Tier5PortalPosition(TeleporterTier5 tier5Teleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.teleporter = tier5Teleporter;
        this.seed = par5;
    }
}