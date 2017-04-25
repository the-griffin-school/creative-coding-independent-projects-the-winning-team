package in.voidma.classroom.network.core.network.login;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.login.server.SDisconnect;
import in.voidma.classroom.network.core.network.login.server.SLoginSuccess;

public interface INetHandlerLoginClient extends INetHandler {

    void processLoginSuccess(SLoginSuccess packet);

    void processDisconnect(SDisconnect packet);
}
