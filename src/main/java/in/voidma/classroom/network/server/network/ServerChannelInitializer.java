package in.voidma.classroom.network.server.network;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

public class ServerChannelInitializer extends ChannelInitializer {

    private final EventExecutorGroup group = new DefaultEventExecutorGroup(1500);

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(group, "serverHandler", new ServerHandler());
    }
}
