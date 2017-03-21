package in.voidma.classroom.network.core.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

public class PacketCodec extends MessageToMessageCodec<Envelope, Packet> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> out) throws Exception {
        byte type = PacketType.getType(packet).getID();
        byte[] payload = packet.encode();
        Envelope envelope = new Envelope();
        envelope.setPayload(payload);
        envelope.setType(type);
        out.add(envelope);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Envelope envelope, List<Object> out) throws Exception {
        PacketType packetType = PacketType.getType(envelope.getType());
        Class<? extends Packet> packetClass = packetType.getPacket();
        Packet packet = packetClass.newInstance();
        packet.decode(envelope.getPayload());
        out.add(packet);
    }
}