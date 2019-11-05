package Master_Cram.Master_Mod.world.tier1;

import Master_Cram.Master_Mod.world.arcana.TeleporterArcana;
import net.minecraft.util.ChunkCoordinates;

public class Tier1PortalPosition extends ChunkCoordinates {
	
    public long seed;
    private final TeleporterTier1 teleporter;

    public Tier1PortalPosition(TeleporterTier1 tier1Teleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.teleporter = tier1Teleporter;
        this.seed = par5;
    }
}