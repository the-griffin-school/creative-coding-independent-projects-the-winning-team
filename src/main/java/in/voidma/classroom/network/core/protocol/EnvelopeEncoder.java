package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * Created by schan on 3/7/2017.
 */
public class EnvelopeEncoder extends MessageToByteEncoder<Envelope> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Envelope message, ByteBuf out) throws Exception {
        // verify that no fields are set to null

        //type(1b) + payload length(4b) + payload(nb)
        out.writeByte(message.getType());
        out.writeInt(message.getPayload().length);
        out.writeBytes(message.getPayload());
    }
}
