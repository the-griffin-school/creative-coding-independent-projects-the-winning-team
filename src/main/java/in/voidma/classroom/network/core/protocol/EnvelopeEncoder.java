package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.MessageToMessageEncoder;

import in.voidma.classroom.network.core.protocol.Envelope;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.Channel;
/**
 * Created by schan on 3/7/2017.
 */
public abstract class EnvelopeEncoder extends MessageToMessageEncoder {
    // ...
    public static ByteBuf encodeMessage(Envelope message)
            throws IllegalArgumentException {
        // verify that no fields are set to null

        // version(1b) + type(1b) + payload length(4b) + payload(nb)
        int size = 2 + message.getPayload().length;

        ByteBuf buffer = ;
        buffer.writeByte(message.getType());
        buffer.writeInt(message.getPayload().length);
        buffer.writeBytes(message.getPayload());

        return buffer;
    }

    @Override
    protected abstract void encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object msg) throws Exception {
        if (msg instanceof Envelope) {
            return encodeMessage((Envelope)msg);
        } else {
            return msg;
        }
    }
}
