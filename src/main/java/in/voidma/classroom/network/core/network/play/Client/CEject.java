package in.voidma.classroom.network.core.network.play.Client;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayServer;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/26/2017.
 */
public class CEject implements Packet<INetHandlerPlayServer>{

    UUID uuid;
    int x, y, massChange;

    public CEject(UUID uuid, int x, int y, int massChange) {
        this.uuid = uuid;
        this.x = x;
        this.y = y;
        this.massChange = massChange;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());

        x = buf.readInt();
        y = buf.readInt();
        massChange = buf.readInt();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(massChange);
    }

    public void processPacket(INetHandlerPlayServer handler) {
        handler.processEject(this);
    }
}
