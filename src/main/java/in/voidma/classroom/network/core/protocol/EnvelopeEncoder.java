package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by schan on 3/23/2017.
 */
public class EnvelopeEncoder extends MessageToByteEncoder<Envelope> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Envelope envelope, ByteBuf out) throws Exception {
        out.writeByte(envelope.getID());
        out.writeInt(envelope.getPayload().array().length);
        out.writeBytes(envelope.getPayload());
    }
}
