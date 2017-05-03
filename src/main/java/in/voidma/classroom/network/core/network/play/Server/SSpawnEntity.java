package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/26/2017.
 */
public class SSpawnEntity implements Packet<INetHandlerPlayClient> {

    UUID uuid;

    int x, y, mass;

    public SSpawnEntity(UUID uuid, int x, int y, int mass) {
        this.uuid = uuid;
        this.x = x;
        this.y = y;
        this.mass = mass;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());

        x = buf.readInt();
        y = buf.readInt();
        mass = buf.readInt();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(mass);
    }

    public void processPacket(INetHandlerPlayClient handler) {
        handler.processSpawnEntity(this);
    }
}
