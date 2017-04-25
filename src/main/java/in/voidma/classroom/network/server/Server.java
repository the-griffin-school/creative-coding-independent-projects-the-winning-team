package in.voidma.classroom.network.server;

import io.netty.channel.ChannelFuture;

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

    }
}
