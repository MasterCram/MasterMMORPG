package Master_Cram.Master_Mod.packet;

import Master_Cram.Master_Mod.Master_Mod;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class OpenGuiPacket extends AbstractPacket {

	private byte id;
	
	public OpenGuiPacket() {
		
	}
	
	public OpenGuiPacket(byte id) {
		this.id = id;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeByte(id);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		id = buffer.readByte();
		System.out.println(id);
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		FMLNetworkHandler.openGui(player, Master_Mod.instance, id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}
}
