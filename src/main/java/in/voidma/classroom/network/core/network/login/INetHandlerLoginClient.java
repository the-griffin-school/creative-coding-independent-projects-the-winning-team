package in.voidma.classroom.network.core.network.login;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.login.server.SDisconnect;

public interface INetHandlerLoginClient extends INetHandler {

    void processDisconnect(SDisconnect packet);
}
