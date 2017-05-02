package in.voidma.classroom.network.core.network.play;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.Packet;

public interface INetHandlerPlayServer extends INetHandler {
    void processEject(Packet packet);

    void processVelocity(Packet packet);

    void processSplit(Packet packet);

}
