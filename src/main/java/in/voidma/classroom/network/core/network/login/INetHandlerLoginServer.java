package in.voidma.classroom.network.core.network.login;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.login.client.CLoginStart;

public interface INetHandlerLoginServer extends INetHandler {

    void processLoginStart(CLoginStart packet);
}
