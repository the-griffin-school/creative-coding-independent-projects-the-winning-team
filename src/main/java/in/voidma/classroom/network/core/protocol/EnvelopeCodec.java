package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

public class EnvelopeCodec extends ByteToMessageCodec<Envelope> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Envelope envelope, ByteBuf out) throws Exception {
        out.writeByte(envelope.getType());
        out.writeInt(envelope.getPayload().length);
        out.writeBytes(envelope.getPayload());
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte type = byteBuf.readByte();
        int length = byteBuf.readInt();
        byte[] payload = new byte[length];
        byteBuf.readBytes(payload);

        Envelope envelope = new Envelope();
        envelope.setType(type);
        envelope.setPayload(payload);
    }
}
