package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * Created by schan on 3/7/2017.
 */
public class EnvelopeEncoder extends MessageToMessageEncoder<Envelope> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Envelope message, List out) throws Exception {
        // verify that no fields are set to null

        //type(1b) + payload length(4b) + payload(nb)
        int size = Integer.BYTES + Byte.BYTES + message.getPayload().length;

        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(size);
        buffer.writeByte(message.getType());
        buffer.writeInt(message.getPayload().length);
        buffer.writeBytes(message.getPayload());

        out.add(buffer);
    }
}
