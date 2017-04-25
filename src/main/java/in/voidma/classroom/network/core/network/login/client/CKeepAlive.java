package in.voidma.classroom.network.core.network.login.client;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.login.INetHandlerLoginServer;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by schan on 4/25/2017.
 */
public class CKeepAlive implements Packet<INetHandlerLoginServer> {
    public void readPacketData(ByteBuf buf) throws IOException {

    }

    public void writePacketData(ByteBuf buf) throws IOException {

    }

    public void processPacket(INetHandlerLoginServer handler) {

    }
}
