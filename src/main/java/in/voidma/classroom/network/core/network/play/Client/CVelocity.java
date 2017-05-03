package in.voidma.classroom.network.core.network.play.Client;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayServer;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/26/2017.
 */
public class CVelocity implements Packet<INetHandlerPlayServer>{

    int x, y;
    UUID uuid;

    public CVelocity(UUID uuid, int x, int y) {
        this.x = x;
        this.y = y;
        this.uuid = uuid;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());
        x = buf.readInt();
        y = buf.readInt();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        buf.writeInt(x);
        buf.writeInt(y);
    }

    public void processPacket(INetHandlerPlayServer handler) {
        handler.processVelocity(this);
    }
}
