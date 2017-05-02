package in.voidma.classroom.network.core.network.play.Client;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayServer;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/26/2017.
 */
public class CSplit implements Packet<INetHandlerPlayServer>{

    UUID uuid;

    public CSplit(UUID uuid) {
        this.uuid = uuid;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());
    }

    public void processPacket(INetHandlerPlayServer handler) {
        handler.processSplit(this);
    }
}
