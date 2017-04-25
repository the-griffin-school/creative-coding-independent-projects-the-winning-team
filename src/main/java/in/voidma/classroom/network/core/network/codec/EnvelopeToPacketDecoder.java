package in.voidma.classroom.network.core.network.codec;

import in.voidma.classroom.network.core.network.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.io.IOException;
import java.util.List;

public class EnvelopeToPacketDecoder extends MessageToMessageDecoder<Envelope> implements ChannelInboundHandler {

    PacketDirection direction;

    public EnvelopeToPacketDecoder(PacketDirection direction) {
        this.direction = direction;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Envelope envelope, List<Object> out) throws Exception {

        ConnectionState connectionState = channelHandlerContext.channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get();
        Packet<?> packet = connectionState.getPacket(direction, envelope.getID());

        if (packet == null) {
            throw new IOException("Bad packet id " + envelope.getID());
        } else {
            packet.readPacketData(envelope.getPayload());
            out.add(packet);
        }

    }
}
