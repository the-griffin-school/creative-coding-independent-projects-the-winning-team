package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

public class EnvelopeCodec extends ByteToMessageCodec<Envelope> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Envelope envelope, ByteBuf out) throws Exception {
        out.writeByte(envelope.getID());
        out.writeInt(envelope.getPayload().array().length);
        out.writeBytes(envelope.getPayload());
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Envelope envelope = new Envelope();
        envelope.setID(byteBuf.readByte());
        envelope.setPayload(byteBuf.readBytes(byteBuf.readInt()));
        list.add(envelope);
    }
}
