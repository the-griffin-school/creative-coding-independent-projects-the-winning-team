package in.voidma.classroom.network.server.network;

import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.server.Server;

public class NetHandlerServer {

    protected final Server server;
    protected final NetworkManager networkManager;

    public NetHandlerServer(Server server, NetworkManager networkManager) {
        this.server = server;
        this.networkManager = networkManager;
    }
}
