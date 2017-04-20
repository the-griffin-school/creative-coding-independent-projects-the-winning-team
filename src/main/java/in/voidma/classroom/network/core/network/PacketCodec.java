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

package in.voidma.classroom.network.core.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * Encodes Packet -> Envelope and decodes Envelope -> Packet with the PacketType enum
 *
 * @author Miles
 * @author Sam
 */
public class PacketCodec extends MessageToMessageCodec<Envelope, Packet> implements ChannelOutboundHandler, ChannelInboundHandler{

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> out) throws Exception {
        byte id = packet.getID();

        ByteBuf payload = ByteBufAllocator.DEFAULT.buffer();
        packet.encode(payload);

        Envelope envelope = new Envelope();
        envelope.setPayload(payload);
        envelope.setID(id);

        out.add(envelope);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Envelope envelope, List<Object> out) throws Exception {
        Class<? extends Packet> packetClass = PacketType.getPacket(envelope.getID());

        Packet packet = packetClass.newInstance();
        packet.decode(envelope.getPayload());

        out.add(packet);
    }
}