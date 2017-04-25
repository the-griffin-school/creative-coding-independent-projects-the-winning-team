package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import in.voidma.classroom.network.core.util.IUpdatable;

public class NetHandlerPlayClient extends NetHandlerClient implements INetHandlerPlayClient, IUpdatable {

    public NetHandlerPlayClient(Client client, NetworkManager networkManager) {
        super(client, networkManager);
    }

    public void update() {

    }
}
