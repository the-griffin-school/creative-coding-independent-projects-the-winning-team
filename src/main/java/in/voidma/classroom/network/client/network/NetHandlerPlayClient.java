package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import in.voidma.classroom.network.core.util.IUpdatable;

public class NetHandlerPlayClient extends NetHandlerClient implements INetHandlerPlayClient, IUpdatable {

    public NetHandlerPlayClient(Client client, NetworkManager networkManager) {
        super(client, networkManager);
    }

    public void update() {

    }

    public void processDestroyEntity(Packet packet) {

    }

    public void processSpawnEntity(Packet packet) {

    }

    public void processEntityMove(Packet packet) {

    }

    public void processMassUpdate(Packet packet) {

    }

    public void processDeath(Packet packet) {

    }
}
