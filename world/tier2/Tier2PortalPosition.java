package Master_Cram.Master_Mod.world.tier2;

import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import net.minecraft.util.ChunkCoordinates;

public class Tier2PortalPosition extends ChunkCoordinates {
	
    public long seed;
    private final TeleporterTier2 teleporter;

    public Tier2PortalPosition(TeleporterTier2 tier2Teleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.teleporter = tier2Teleporter;
        this.seed = par5;
    }
}