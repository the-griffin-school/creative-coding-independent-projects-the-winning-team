package in.voidma.classroom.network.core.network.handshake;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.handshake.client.Handshake;

public interface INetHandlerHandshakeServer extends INetHandler {

    void processHandshake(Handshake packet);
}
