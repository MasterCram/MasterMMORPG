package Master_Cram.Master_Mod.packet;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

import Master_Cram.Master_Mod.References;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
public class PacketPipeline extends MessageToMessageCodec<FMLProxyPacket, AbstractPacket> {

	private EnumMap<Side, FMLEmbeddedChannel> channels;
	private LinkedList<Class<? extends AbstractPacket>> packets = new LinkedList<Class<? extends AbstractPacket>>();
	private boolean isPostInitialized = false;
	
	public boolean registerPacket(Class<? extends AbstractPacket> clazz) {
		if(this.packets.size() > 256) {
			System.err.println("Maximum amount of packets reached!");
			return false;
		}
		
		if(this.packets.contains(clazz)) {
			System.err.println("This packet has already been registered!");
			return false;
		}
		
		if(this.isPostInitialized) {
			System.err.println("Packet registered too late!");
			return false;
		}
		
		this.packets.add(clazz);
		return true;
	}
	
	public void initialize() {
		this.channels = NetworkRegistry.INSTANCE.newChannel(References.PACKET_CHANNEL, this);
		
		registerPacket();
	}
	
	public void postInitialize() {
		if(isPostInitialized)
			return;
		
		isPostInitialized = true;
		Collections.sort(this.packets, new Comparator<Class<? extends AbstractPacket>>() {
			@Override
			public int compare(Class<? extends AbstractPacket> o1, Class<? extends AbstractPacket> o2) {
				int com = String.CASE_INSENSITIVE_ORDER.compare(o1.getCanonicalName(), o2.getCanonicalName());
				if(com == 0)
					com = o1.getCanonicalName().compareTo(o2.getCanonicalName());
				return com;
			}
		});
	}
	
	public void registerPacket() {
		// Register your packets
		registerPacket(OpenGuiPacket.class);
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, List<Object> out) throws Exception {
		ByteBuf buffer = Unpooled.buffer();
		
		Class<? extends AbstractPacket> clazz = msg.getClass();
		if(!this.packets.contains(clazz)) {
			throw new NullPointerException("This packet has never been registered: " + clazz.getCanonicalName());
		}
		
		byte discriminator = (byte) this.packets.indexOf(clazz);
		buffer.writeByte(discriminator);
		msg.encodeInto(ctx, buffer);
		
		FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
		out.add(proxyPacket);
		
		
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
		ByteBuf payload = msg.payload();
		byte discriminator = payload.readByte();
		
		Class<? extends AbstractPacket> clazz = this.packets.get(discriminator);
		if(clazz == null) {
			throw new NullPointerException("This packet has never been registered: " + clazz.getCanonicalName());
		}
		
		AbstractPacket abstractPacket = clazz.newInstance();
		abstractPacket.decodeInto(ctx, payload.slice());
		
		EntityPlayer player;
		switch(FMLCommonHandler.instance().getEffectiveSide()) {
		case SERVER:
			INetHandler iNetHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
			player = ((NetHandlerPlayServer) iNetHandler).playerEntity;
			abstractPacket.handleServerSide(player);
			break;
		case CLIENT:
			player = null; //(EntityPlayer) FMLClientHandler.instance().getClientPlayerEntity();
			abstractPacket.handleClientSide(player);
			break;
			default:
		}
		
		out.add(abstractPacket);
		
	}
	
	public void sendToServer(AbstractPacket message) {
		this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		this.channels.get(Side.CLIENT).writeAndFlush(message);
	}

}
