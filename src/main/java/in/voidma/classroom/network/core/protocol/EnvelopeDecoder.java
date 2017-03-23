package in.voidma.classroom.network.core.protocol;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Created by sam channow on 3/23/2017.
 * @author schan
 * @author miles
 */
public class EnvelopeDecoder extends ReplayingDecoder<EnvelopeDecoder.DecodingState>{

    private Envelope message;
    private int length;

    /**
     * Decodes byte array into envelope object
     */
    public EnvelopeDecoder() {
        super(DecodingState.TYPE);
        this.message = new Envelope();
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        switch (state()) {
            case TYPE:
                message.setID(byteBuf.readByte());
                checkpoint(DecodingState.PAYLOAD_LENGTH);
            case PAYLOAD_LENGTH:
                length = byteBuf.readInt();
                checkpoint(DecodingState.PAYLOAD);
            case PAYLOAD:
                message.setPayload(byteBuf.readBytes(length));
                out.add(message);
                break;
            default:
                throw new Exception("Unknown decoding state " + state());
        }
    }

    public enum DecodingState {
        TYPE,
        PAYLOAD_LENGTH,
        PAYLOAD,
    }
}
