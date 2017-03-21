package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Created by schan on 3/7/2017.
 */
public class EnvelopeDecoder extends ReplayingDecoder<DecodingState> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {

    }

    private void reset() {
        checkpoint(DecodingState.VERSION);
        this.message = new Envelope();
    }
}
