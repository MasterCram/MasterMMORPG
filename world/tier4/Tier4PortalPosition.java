package Master_Cram.Master_Mod.world.tier4;

import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import net.minecraft.util.ChunkCoordinates;

public class Tier4PortalPosition extends ChunkCoordinates {
	
    public long seed;
    private final TeleporterTier4 teleporter;

    public Tier4PortalPosition(TeleporterTier4 tier4Teleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.teleporter = tier4Teleporter;
        this.seed = par5;
    }
}