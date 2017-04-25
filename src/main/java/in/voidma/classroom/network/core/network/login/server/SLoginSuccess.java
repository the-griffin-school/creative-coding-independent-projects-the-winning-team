package in.voidma.classroom.network.core.network.login.server;

import in.voidma.classroom.network.core.network.login.INetHandlerLoginClient;
import in.voidma.classroom.network.core.network.Packet;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by schan on 4/25/2017.
 */
public class SLoginSuccess implements Packet<INetHandlerLoginClient> {
    public void readPacketData(ByteBuf buf) throws IOException {

    }

    public void writePacketData(ByteBuf buf) throws IOException {

    }

    public void processPacket(INetHandlerLoginClient handler) {

    }
}
