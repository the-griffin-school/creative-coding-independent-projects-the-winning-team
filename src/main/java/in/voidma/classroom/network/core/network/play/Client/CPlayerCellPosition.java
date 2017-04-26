package in.voidma.classroom.network.core.network.play.Client;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayServer;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by schan on 4/26/2017.
 */
public class CPlayerCellPosition implements Packet<INetHandlerPlayServer>{
    public void readPacketData(ByteBuf buf) throws IOException {

    }

    public void writePacketData(ByteBuf buf) throws IOException {

    }

    public void processPacket(INetHandlerPlayServer handler) {

    }
}
