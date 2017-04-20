package in.voidma.classroom.network.core.network.handshake.client;

import in.voidma.classroom.network.core.network.ConnectionState;
import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.handshake.INetHandlerHandshakeServer;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class Handshake implements Packet<INetHandlerHandshakeServer> {

    private int protocolVersion;
    private ConnectionState requestedState;

    public Handshake(int protocolVersion, ConnectionState requestedState) {
        this.protocolVersion = protocolVersion;
        this.requestedState = requestedState;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        this.protocolVersion = buf.readInt();
        this.requestedState = ConnectionState.getById(buf.readInt());
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeInt(protocolVersion);
        buf.writeInt(requestedState.getId());
    }

    public void processPacket(INetHandlerHandshakeServer handler) {
        handler.processHandshake(this);
    }

    public ConnectionState getRequestedState() {
        return this.requestedState;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }
}
