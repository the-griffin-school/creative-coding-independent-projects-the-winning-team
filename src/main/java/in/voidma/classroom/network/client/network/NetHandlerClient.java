package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.network.NetworkManager;

public class NetHandlerClient {

    protected final Client client;
    protected final NetworkManager networkManager;

    public NetHandlerClient(Client client, NetworkManager networkManager) {
        this.client = client;
        this.networkManager = networkManager;
    }
}
