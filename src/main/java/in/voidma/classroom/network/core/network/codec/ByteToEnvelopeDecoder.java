//  o8o                                         .        88                           .                              .        o8o
//  `"'                                       .o8       .8'                         .o8                            .o8        `"'
// oooo  ooo. .oo.   oo.ooooo.  oooo  oooo  .o888oo    .8'   .ooooo.  oooo  oooo  .o888oo oo.ooooo.  oooo  oooo  .o888oo     oooo   .ooooo.
// `888  `888P"Y88b   888' `88b `888  `888    888     .8'   d88' `88b `888  `888    888    888' `88b `888  `888    888       `888  d88' `88b
//  888   888   888   888   888  888   888    888    .8'    888   888  888   888    888    888   888  888   888    888        888  888   888
//  888   888   888   888   888  888   888    888 . .8'     888   888  888   888    888 .  888   888  888   888    888 . .o.  888  888   888
// o888o o888o o888o  888bod8P'  `V88V"V8P'   "888" 88      `Y8bod8P'  `V88V"V8P'   "888"  888bod8P'  `V88V"V8P'   "888" Y8P o888o `Y8bod8P'
//                    888                                                                  888
//                   o888o                                                                o888o
//
// Miles Silberling-Cook
// Zane Alversomething
// Samantha Channow
//

package in.voidma.classroom.network.core.network.codec;

import in.voidma.classroom.network.core.network.Envelope;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Decodes bytebufs from the IO stream into envelope instances that can be handled upstream
 *
 * @author Miles
 * @author Sam
 */
public class ByteToEnvelopeDecoder extends ReplayingDecoder<ByteToEnvelopeDecoder.DecodingState> implements ChannelInboundHandler {

    private Envelope message;
    private int length;

    /**
     * Decodes byte array into envelope object
     */
    //constructor
    public ByteToEnvelopeDecoder() {
        super(DecodingState.TYPE);
        this.message = new Envelope();
    }

    @Override
    //uses the sgtate of the object based on PacketType enum to decode data
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        switch (state()) {
            case TYPE:
                //gets ID so we can defien the type of packet
                message.setID(byteBuf.readInt());
                checkpoint(DecodingState.PAYLOAD_LENGTH);
            case PAYLOAD_LENGTH:
                //get the lengthn of the array so we know what we are decoding
                length = byteBuf.readInt();
                checkpoint(DecodingState.PAYLOAD);
            case PAYLOAD:
                //actual data
                message.setPayload(byteBuf.readBytes(length));
                out.add(message);
                break;
            default:
                //error
                throw new Exception("Unknown decoding state " + state());
        }
    }

    public enum DecodingState {
        TYPE,
        PAYLOAD_LENGTH,
        PAYLOAD,
    }
}
