package in.voidma.classroom.network.server.network;

import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.status.INetHandlerStatusServer;
import in.voidma.classroom.network.server.Server;

public class NetHandlerStatusServer extends NetHandlerServer implements INetHandlerStatusServer {

    public NetHandlerStatusServer(Server server, NetworkManager networkManager) {
        super(server, networkManager);
    }
}
