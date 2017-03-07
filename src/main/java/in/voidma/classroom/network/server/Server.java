package in.voidma.classroom.network.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;

public class Server {

    //test

    private int port;

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ChannelFuture channel;

    public Server(int port) {
        this.port = port;
    }

    public static void main (String[] args) {

    }

    void run() {
    }
}
