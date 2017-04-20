package in.voidma.classroom.network.server.network;

import in.voidma.classroom.network.core.network.ConnectionState;
import in.voidma.classroom.network.core.network.NetworkManager;
import in.voidma.classroom.network.core.network.handshake.INetHandlerHandshakeServer;
import in.voidma.classroom.network.core.network.handshake.client.Handshake;
import in.voidma.classroom.network.server.Server;

public class NetHandlerHandshakeServer extends NetHandlerServer implements INetHandlerHandshakeServer {

    public NetHandlerHandshakeServer(Server server, NetworkManager networkManager) {
        super(server, networkManager);
    }

    public void processHandshake(Handshake packetIn) {
        switch (packetIn.getRequestedState()) {
            case LOGIN:
                this.networkManager.setConnectionState(ConnectionState.LOGIN);

                if (packetIn.getProtocolVersion() != 16) {
                    //TODO: send disconnect packet
                    this.networkManager.closeChannel();
                } else {
                    this.networkManager.setNetHandler(new NetHandlerLoginServer(this.server, this.networkManager));
                }

            case STATUS:
                this.networkManager.setConnectionState(ConnectionState.STATUS);
                this.networkManager.setNetHandler(new NetHandlerStatusServer(this.server, this.networkManager));
                break;
        }
    }
}
