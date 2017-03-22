package in.voidma.classroom.network.core.protocol;

import in.voidma.classroom.network.core.protocol.packet.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

public class PacketCodec extends MessageToMessageCodec<Envelope, Packet> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> out) throws Exception {
        byte id = packet.getID();

        ByteBuf payload = ByteBufAllocator.DEFAULT.buffer();
        packet.encode(payload);

        Envelope envelope = new Envelope();
        envelope.setPayload(payload);
        envelope.setID(id);

        out.add(envelope);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Envelope envelope, List<Object> out) throws Exception {
        Class<? extends Packet> packetClass = PacketType.getPacket(envelope.getID());

        Packet packet = packetClass.newInstance();
        packet.decode(envelope.getPayload());

        out.add(packet);
    }
}