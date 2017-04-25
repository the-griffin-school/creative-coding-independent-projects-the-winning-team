package in.voidma.classroom.network.core.network.codec;

import in.voidma.classroom.network.core.network.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class PacketToEnvelopeEncoder extends MessageToMessageEncoder<Packet<?>> implements ChannelOutboundHandler {

    PacketDirection direction;

    public PacketToEnvelopeEncoder(PacketDirection direction) {
        this.direction = direction;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet<?> packet, List<Object> out) throws Exception {
        ConnectionState connectionState = channelHandlerContext.channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get();
        int id = connectionState.getPacketId(direction, packet);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        packet.writePacketData(byteBuf);

        Envelope envelope = new Envelope();
        envelope.setID(id);
        envelope.setPayload(byteBuf);

        out.add(envelope);
    }
}
