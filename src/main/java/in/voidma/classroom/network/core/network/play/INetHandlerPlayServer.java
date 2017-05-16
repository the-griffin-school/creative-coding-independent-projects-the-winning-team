package in.voidma.classroom.network.core.network.play;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.play.Client.CEject;
import in.voidma.classroom.network.core.network.play.Client.CSplit;
import in.voidma.classroom.network.core.network.play.Client.CVelocity;

public interface INetHandlerPlayServer extends INetHandler {

    void processEject(CEject packet);

    void processVelocity(CVelocity packet);

    void processSplit(CSplit packet);

}
