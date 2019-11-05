package Master_Cram.Master_Mod.world.tier3;

import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import net.minecraft.util.ChunkCoordinates;

public class Tier3PortalPosition extends ChunkCoordinates {
	
    public long seed;
    private final TeleporterTier3 teleporter;

    public Tier3PortalPosition(TeleporterTier3 tier3Teleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.teleporter = tier3Teleporter;
        this.seed = par5;
    }
}