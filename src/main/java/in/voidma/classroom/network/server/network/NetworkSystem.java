
package in.voidma.classroom.network.server.network;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.PacketDirection;
import in.voidma.classroom.network.core.network.codec.ByteToEnvelopeDecoder;
import in.voidma.classroom.network.core.network.codec.EnvelopeToByteEncoder;
import in.voidma.classroom.network.core.network.codec.EnvelopeToPacketDecoder;
import in.voidma.classroom.network.core.network.codec.PacketToEnvelopeEncoder;
import in.voidma.classroom.network.core.network.login.server.SDisconnect;
import in.voidma.classroom.network.server.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: Fill out javaDoc coment for in.voidma.classroom.network.server.network:NetworkSystem
 *
 * @author NthTensor
 * @version 1.0
 * @since 2017-05-11
 */
public class NetworkSystem {

    private static final NioEventLoopGroup loopGroup;

    static {
        loopGroup = new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
    }

    private final List<ChannelFuture> endpoints = Collections.synchronizedList(Lists.<ChannelFuture>newArrayList());
    private final List<NetworkManager> networkManagers = Collections.synchronizedList(Lists.<NetworkManager>newArrayList());
    private Server server;
    private boolean alive;

    public NetworkSystem(Server server) {

        this.server = server;
        this.alive = true;
    }

    public void addLanEndpoint(int port) {

        synchronized (endpoints) {

            final NetworkManager networkmanager = new NetworkManager(PacketDirection.SERVERBOUND);
            this.networkManagers.add(networkmanager);

            ServerBootstrap boostrap = new ServerBootstrap();
            boostrap.group(loopGroup);
            boostrap.childHandler(new ChannelInitializer<Channel>() {
                protected void initChannel(Channel channel) throws Exception {

                    ChannelConfig config = channel.config();
                    config.setOption(ChannelOption.TCP_NODELAY, true);

                    ChannelPipeline pipeline = channel.pipeline();
                    pipeline.addLast("Timeout", new ReadTimeoutHandler(30));

                    pipeline.addLast("EnvelopeDecoder", new ByteToEnvelopeDecoder());
                    pipeline.addLast("PacketDecoder", new EnvelopeToPacketDecoder(PacketDirection.CLIENTBOUND));

                    pipeline.addLast("EnvelopeEncoder", new EnvelopeToByteEncoder());
                    pipeline.addLast("PacketEncoder", new PacketToEnvelopeEncoder(PacketDirection.SERVERBOUND));

                    pipeline.addLast("PacketHandler", networkmanager);
                }
            });
            boostrap.channel(NioServerSocketChannel.class);
            endpoints.add(boostrap.localAddress(port).bind().syncUninterruptibly());
        }
    }

    public void terminateEndpoints() {

        this.alive = false;

        for (ChannelFuture channelfuture : this.endpoints) {
            try {
                channelfuture.channel().close().sync();
            } catch (InterruptedException error) {
                error.printStackTrace();
            }
        }
    }

    /**
     * Will try to process the packets received by each NetworkManager, gracefully manage processing failures and cleans
     * up dead connections
     */
    public void networkTick() {

        synchronized (this.networkManagers) {
            Iterator<NetworkManager> iterator = this.networkManagers.iterator();

            while (iterator.hasNext()) {
                final NetworkManager networkmanager = iterator.next();

                if (!networkmanager.hasNoChannel()) {
                    if (networkmanager.isChannelOpen()) {

                        try {
                            networkmanager.processReceivedPackets();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            System.err.print("Error in connection. Terminating");
                            networkmanager.sendPacket(
                                    new SDisconnect().setFlagConnectionError(),
                                    new GenericFutureListener<Future<? super Void>>() {
                                        public void operationComplete(Future<? super Void> p_operationComplete_1_) throws Exception {

                                            networkmanager.closeChannel();
                                        }
                                    });
                            networkmanager.disableAutoRead();
                        }
                    } else {
                        iterator.remove();
                        networkmanager.checkDisconnected();
                    }
                }
            }
        }
    }

    public Server getServer() {

        return server;
    }
}
