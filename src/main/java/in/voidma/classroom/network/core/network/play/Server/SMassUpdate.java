package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by schan on 4/26/2017.
 */

//TODO: miles add stuff in here
public class SMassUpdate implements Packet<INetHandlerPlayClient> {
    public void readPacketData(ByteBuf buf) throws IOException {

    }

    public void writePacketData(ByteBuf buf) throws IOException {

    }

    public void processPacket(INetHandlerPlayClient handler) {

    }
}
