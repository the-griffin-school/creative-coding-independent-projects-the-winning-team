package in.voidma.classroom.network.core.network;

import com.google.common.collect.Queues;
import com.sun.istack.internal.Nullable;
import in.voidma.classroom.network.core.util.IUpdatable;
import io.netty.channel.*;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.apache.commons.lang3.ArrayUtils;

import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NetworkManager extends SimpleChannelInboundHandler<Packet<INetHandler>> {

    public static final AttributeKey<ConnectionState> PROTOCOL_ATTRIBUTE_KEY = AttributeKey.valueOf("protocol");

    private final PacketDirection direction;
    private final Queue<InboundHandlerTuplePacketListener> outboundPacketsQueue = Queues.newConcurrentLinkedQueue();
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * The active channel
     */
    private Channel channel;
    /**
     * The address of the remote party
     */
    private SocketAddress socketAddress;
    /**
     * The INetHandler instance responsible for processing received packets
     */
    private INetHandler packetListener;
    private boolean isEncrypted;
    private boolean disconnected;

    public NetworkManager(PacketDirection packetDirection) {
        this.direction = packetDirection;
    }

    public void setConnectionState(ConnectionState newState) {
        this.channel.attr(PROTOCOL_ATTRIBUTE_KEY).set(newState);
        this.channel.config().setAutoRead(true);
    }

    protected void channelRead0(ChannelHandlerContext context, Packet<INetHandler> packet) throws Exception {
        if (this.channel.isOpen()) {
            packet.processPacket(this.packetListener);
        }
    }

    /**
     * Will commit the packet to the channel. If the current thread 'owns' the channel it will write and flush the
     * packet, otherwise it will add a task for the channel eventloop thread to do that.
     */
    private void dispatchPacket(final Packet<?> inPacket, @Nullable final GenericFutureListener<? extends Future<? super Void>>[] futureListeners) {
        final ConnectionState packetConnectionState = ConnectionState.getFromPacket(inPacket);
        final ConnectionState channelConnectionState = this.channel.attr(PROTOCOL_ATTRIBUTE_KEY).get();

        if (packetConnectionState != channelConnectionState) {
            this.channel.config().setAutoRead(false);
        }

        if (this.channel.eventLoop().inEventLoop()) {
            if (packetConnectionState != channelConnectionState) ;
            {
                this.setConnectionState(packetConnectionState);
            }

            ChannelFuture channelfuture = this.channel.writeAndFlush(inPacket);

            if (futureListeners != null) {
                channelfuture.addListeners(futureListeners);
            }

            channelfuture.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        } else {
            this.channel.eventLoop().execute(new Runnable() {
                public void run() {
                    if (packetConnectionState != channelConnectionState) {
                        NetworkManager.this.setConnectionState(packetConnectionState);
                    }

                    ChannelFuture channelfuture = NetworkManager.this.channel.writeAndFlush(inPacket);

                    if (futureListeners != null) {
                        channelfuture.addListeners(futureListeners);
                    }

                    channelfuture.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
                }
            });
        }
    }

    private void flushOutboundQueue() {
        if (this.channel != null && this.channel.isOpen()) {
            this.readWriteLock.readLock().lock();

            try {
                while (!this.outboundPacketsQueue.isEmpty()) {
                    InboundHandlerTuplePacketListener tuplePacketListener = this.outboundPacketsQueue.poll();
                    this.dispatchPacket(tuplePacketListener.packet, tuplePacketListener.futureListeners);
                }
            } finally {
                this.readWriteLock.readLock().unlock();
            }
        }
    }

    /**
     * Checks timeouts and processes all packets received
     */
    public void processReceivedPackets() {
        this.flushOutboundQueue();

        if (this.packetListener instanceof IUpdatable) {
            ((IUpdatable) this.packetListener).update();
        }

        this.channel.flush();
    }

    /**
     * Returns the socket address of the remote side. Server-only.
     */
    public SocketAddress getRemoteAddress() {
        return this.socketAddress;
    }

    /**
     * Closes the channel, the parameter can be used for an exit message (not certain how it gets sent)
     */
    public void closeChannel() {
        if (this.channel.isOpen()) {
            this.channel.close().awaitUninterruptibly();
        }
    }

    public void sendPacket(Packet<?> packetIn) {
        if (this.isChannelOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(packetIn, null);
        } else {
            this.readWriteLock.writeLock().lock();

            try {
                this.outboundPacketsQueue.add(new NetworkManager.InboundHandlerTuplePacketListener(packetIn, (GenericFutureListener[]) null));
            } finally {
                this.readWriteLock.writeLock().unlock();
            }
        }
    }

    public void sendPacket(Packet<?> packetIn, GenericFutureListener<? extends Future<? super Void>> listener, GenericFutureListener<? extends Future<? super Void>>... listeners) {
        if (this.isChannelOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(packetIn, ArrayUtils.add(listeners, 0, listener));
        } else {
            this.readWriteLock.writeLock().lock();

            try {
                this.outboundPacketsQueue.add(new NetworkManager.InboundHandlerTuplePacketListener(packetIn, (GenericFutureListener[]) ArrayUtils.add(listeners, 0, listener)));
            } finally {
                this.readWriteLock.writeLock().unlock();
            }
        }
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isChannelOpen() {
        return this.channel != null && this.channel.isOpen();
    }

    public boolean hasNoChannel() {
        return this.channel == null;
    }

    public INetHandler getNetHandler() {
        return this.packetListener;
    }

    /**
     * Sets the NetHandler for this NetworkManager, no checks are made if this handler is suitable for the particular
     * connection state (protocol)
     */
    public void setNetHandler(INetHandler handler) {
        this.packetListener = handler;
    }

    public void disableAutoRead() {
        this.channel.config().setAutoRead(false);
    }

    public void checkDisconnected() {
        this.disconnected = this.channel != null && !this.channel.isOpen();
    }

    static class InboundHandlerTuplePacketListener {
        private final Packet<?> packet;
        private final GenericFutureListener<? extends Future<? super Void>>[] futureListeners;

        public InboundHandlerTuplePacketListener(Packet<?> inPacket, GenericFutureListener<? extends Future<? super Void>>... inFutureListeners) {
            this.packet = inPacket;
            this.futureListeners = inFutureListeners;
        }
    }
}
