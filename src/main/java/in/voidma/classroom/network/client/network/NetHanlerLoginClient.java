package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.client.gui.DisconnectScreen;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.login.INetHandlerLoginClient;
import in.voidma.classroom.network.core.network.login.server.SDisconnect;
import in.voidma.classroom.network.core.util.IUpdatable;

public class NetHanlerLoginClient extends NetHandlerClient implements INetHandlerLoginClient, IUpdatable {

    public NetHanlerLoginClient(Client client, NetworkManager networkManager) {
        super(client, networkManager);
    }

    public void update() {

    }

    public void processDisconnect(SDisconnect packet) {
        this.client.setGui(new DisconnectScreen(client));
    }
}
