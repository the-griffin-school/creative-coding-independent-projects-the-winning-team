package in.voidma.classroom.network.server;

import in.voidma.classroom.network.server.network.ServerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    private int port;

    private ChannelFuture channel;

    private Server(int port) {
        this.port = port;
    }

    public static void main (String[] args) {
        Server server = new Server(8118);
        server.run();
    }

    private void run() {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup);
        bootstrap.channel(NioServerSocketChannel.class);

        bootstrap.childHandler(new ServerChannelInitializer());
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

        try {
            channel = bootstrap.bind(port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
