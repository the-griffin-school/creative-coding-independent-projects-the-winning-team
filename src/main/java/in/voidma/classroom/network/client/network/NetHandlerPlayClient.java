package in.voidma.classroom.network.client.network;

import fisica.FBlob;
import fisica.FWorld;
import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.client.gui.PlayScreen;
import in.voidma.classroom.network.client.gui.Screen;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import in.voidma.classroom.network.core.util.IUpdatable;

public class NetHandlerPlayClient extends NetHandlerClient implements INetHandlerPlayClient, IUpdatable {

    FWorld world;

    public NetHandlerPlayClient(Client client, NetworkManager networkManager, FWorld worldF) {
        super(client, networkManager);
        world = worldF;
    }
    //TODO: Miles we think we can use the name of the Fbody object to use as a UUID. It can be converted from string to UUid and reverse so as long as we initialized with the correct name/uuid we could still keep our current packet functionality.
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

    public void processPlayerCreate(Packet packet) {

    }
}
