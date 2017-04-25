package in.voidma.classroom.network.server.network;

import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.login.INetHandlerLoginServer;
import in.voidma.classroom.network.core.network.login.client.CLoginStart;
import in.voidma.classroom.network.server.Server;

public class NetHandlerLoginServer extends NetHandlerServer implements INetHandlerLoginServer {

    public NetHandlerLoginServer(Server server, NetworkManager networkManager) {
        super(server, networkManager);
    }

    public void processLoginStart(CLoginStart packet) {

    }
}
