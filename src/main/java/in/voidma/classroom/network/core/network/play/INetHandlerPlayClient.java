package in.voidma.classroom.network.core.network.play;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.Packet;

public interface INetHandlerPlayClient extends INetHandler {

    void processMassUpdate(Packet packet);

    void processEntityMove(Packet packet);

    void processDestroyEntity(Packet packet);

    void processSpawnEntity(Packet packet);

    void processDeath(Packet packet);
}
