package in.voidma.classroom.network.client.network;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.entity.*;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import in.voidma.classroom.network.core.network.play.Server.*;
import in.voidma.classroom.network.core.util.IUpdatable;

public class NetHandlerPlayClient extends NetHandlerClient implements INetHandlerPlayClient, IUpdatable {

    public NetHandlerPlayClient(Client client, NetworkManager networkManager) {
        super(client, networkManager);
    }
    //TODO: Miles we think we can use the name of the Fbody object to use as a UUID. It can be converted from string to UUid and reverse so as long as we initialized with the correct name/uuid we could still keep our current packet functionality.
    public void update() {

    }

    public void processDeregister(SDeregister packet) {
        EntityStore.instance().deregister(packet.getUuid());
    }

    public void processCell(SCell packet) {
        new Cell(
                packet.getUuid(),
                packet.getParent(),
                packet.getMass(),
                packet.getX(),
                packet.getY()
        );
    }

    public void processMove(SMove packet) {

        Blob blob = EntityStore.instance().getBlob(packet.getUuid());
        blob.move(packet.getxChange(), packet.getyChange());
    }

    public void processMassUpdate(SMassUpdate packet) {

        Blob blob = EntityStore.instance().getBlob(packet.getUuid());
        blob.addMass(packet.getMassChange());
    }

    public void processDeath(SDeath packet) {

    }

    public void processEjection(SEjection packet) {

        new Ejection(
                packet.getUuid(),
                packet.getMass(),
                packet.getX(),
                packet.getY()
        );
    }

    public void processFood(SFood packet) {

        new Food(
                packet.getUuid(),
                packet.getMass(),
                packet.getX(),
                packet.getY()
        );
    }

    public void processPlayer(SPlayer packet) {

        new Player(
                packet.getUuid(),
                packet.getColor(),
                packet.getName()
        );
    }
}
