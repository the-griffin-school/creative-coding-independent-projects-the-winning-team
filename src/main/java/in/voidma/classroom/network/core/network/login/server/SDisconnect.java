package in.voidma.classroom.network.core.network.login.server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.login.INetHandlerLoginClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class SDisconnect implements Packet<INetHandlerLoginClient> {

    //This packet disconnects the cline tfrom server, usually
    //after a server timeout.

    boolean connectionError;
    boolean internalError;

    boolean terminatedByRequest;
    boolean terminatedByRemote;

    public SDisconnect() {
        connectionError = false;
        internalError = false;
        terminatedByRequest = false;
        terminatedByRemote = false;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        connectionError = buf.readBoolean();
        internalError = buf.readBoolean();
        terminatedByRequest = buf.readBoolean();
        terminatedByRemote = buf.readBoolean();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeBoolean(connectionError);
        buf.writeBoolean(internalError);
        buf.writeBoolean(terminatedByRequest);
        buf.writeBoolean(terminatedByRemote);
    }

    public void processPacket(INetHandlerLoginClient handler) {
        handler.processDisconnect(this);
    }

    public boolean wasConnectionError() {
        return connectionError;
    }

    public SDisconnect setFlagConnectionError() {
        this.connectionError = true;
        return this;
    }

    public boolean wasInternalError() {
        return internalError;
    }

    public SDisconnect setFlagInternalError() {
        this.internalError = true;
        return this;
    }

    public boolean wasTerminatedByRequest() {
        return terminatedByRequest;
    }

    public SDisconnect setFlagTerminatedByRequest() {
        this.terminatedByRequest = true;
        return this;
    }

    public boolean wasTerminatedByRemote() {
        return terminatedByRemote;
    }

    public SDisconnect setFlagTerminatedByRemote() {
        this.terminatedByRemote = true;
        return this;
    }
}
