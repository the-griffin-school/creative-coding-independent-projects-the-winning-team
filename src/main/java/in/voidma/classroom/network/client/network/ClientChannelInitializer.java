//
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

package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.core.network.EnvelopeDecoder;
import in.voidma.classroom.network.core.network.EnvelopeEncoder;
import in.voidma.classroom.network.core.network.PacketCodec;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Netty channel pipeline initializer.
 *
 * @author Miles
 * @author Sam
 */
public class ClientChannelInitializer extends ChannelInitializer {
    private final EventExecutorGroup group = new DefaultEventExecutorGroup(1500);

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(group, "EnvelopeEncoder", new EnvelopeEncoder());
        pipeline.addLast(group, "EnvelopeDecoder", new EnvelopeDecoder());
        pipeline.addLast(group, "packetCodec", new PacketCodec());
        pipeline.addLast(group, "ClientHandler", new ClientHandler());
    }
}
