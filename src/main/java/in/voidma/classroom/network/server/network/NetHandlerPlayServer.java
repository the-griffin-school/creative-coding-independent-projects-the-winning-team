package in.voidma.classroom.network.server.network;

import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.play.Client.CEject;
import in.voidma.classroom.network.core.network.play.Client.CSplit;
import in.voidma.classroom.network.core.network.play.Client.CVelocity;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayServer;
import in.voidma.classroom.network.core.util.IUpdatable;
import in.voidma.classroom.network.server.Server;

/**
 * Created by schan on 4/26/2017.
 */
public class NetHandlerPlayServer extends NetHandlerServer implements INetHandlerPlayServer, IUpdatable {

    public NetHandlerPlayServer(Server server, NetworkManager networkManager) {
        super(server, networkManager);
    }

    public void update() {

    }

    public void processEject(CEject packet) {

    }

    public void processSplit(CSplit packet) {

    }

    public void processVelocity(CVelocity packet) {

    }
}
