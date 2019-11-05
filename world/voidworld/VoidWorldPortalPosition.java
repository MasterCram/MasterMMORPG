package Master_Cram.Master_Mod.world.voidworld;

import net.minecraft.util.ChunkCoordinates;

public class VoidWorldPortalPosition extends ChunkCoordinates {
	
    public long seed;
    private final TeleporterVoidWorld teleporter;

    public VoidWorldPortalPosition(TeleporterVoidWorld voidWorldTeleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.teleporter = voidWorldTeleporter;
        this.seed = par5;
    }
}