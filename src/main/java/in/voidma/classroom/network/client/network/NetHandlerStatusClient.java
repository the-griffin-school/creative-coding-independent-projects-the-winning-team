package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.status.INetHandlerStatusClient;
import in.voidma.classroom.network.core.util.IUpdatable;

public class NetHandlerStatusClient extends NetHandlerClient implements INetHandlerStatusClient, IUpdatable {

    public NetHandlerStatusClient(Client client, NetworkManager networkManager) {
        super(client, networkManager);
    }

    public void update() {

    }
}
