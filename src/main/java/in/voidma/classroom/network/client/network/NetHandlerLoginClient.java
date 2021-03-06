package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.client.gui.DisconnectScreen;
import in.voidma.classroom.network.client.gui.PlayScreen;
import in.voidma.classroom.network.core.entity.ClientPlayer;
import in.voidma.classroom.network.core.entity.EntityStore;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.login.INetHandlerLoginClient;
import in.voidma.classroom.network.core.network.login.server.SDisconnect;
import in.voidma.classroom.network.core.network.login.server.SLoginSuccess;
import in.voidma.classroom.network.core.util.IUpdatable;

public class NetHandlerLoginClient extends NetHandlerClient implements INetHandlerLoginClient, IUpdatable {

    public NetHandlerLoginClient(Client client, NetworkManager networkManager) {
        super(client, networkManager);
    }

    public void update() {

    }

    public void processLoginSuccess(SLoginSuccess packet) {

        client.setGui(new PlayScreen(client, (ClientPlayer) EntityStore.instance().getPlayer(packet.getId())));
    }

    public void processDisconnect(SDisconnect packet) {
        this.client.setGui(new DisconnectScreen(client));
    }
}
