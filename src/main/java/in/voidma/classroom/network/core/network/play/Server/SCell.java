package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public class SCell implements Packet<INetHandlerPlayClient> {

    UUID uuid;
    UUID parent;
    int size;
    long x;
    long y;

    public SCell(UUID uuid, UUID parent, int size, long x, long y) {

        this.uuid = uuid;
        this.parent = parent;
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public void readPacketData(ByteBuf buf) throws IOException {

        this.uuid = new UUID(buf.readLong(), buf.readLong());
        this.parent = new UUID(buf.readLong(), buf.readLong());
        this.size = buf.readInt();
        this.x = buf.readLong();
        this.y = buf.readLong();
    }

    public void writePacketData(ByteBuf buf) throws IOException {

        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        buf.writeLong(parent.getMostSignificantBits());
        buf.writeLong(parent.getLeastSignificantBits());

        buf.writeInt(size);

        buf.writeLong(x);
        buf.writeLong(y);
    }

    public void processPacket(INetHandlerPlayClient handler) {

        handler.processCell(this);
    }

    public UUID getUuid() {

        return uuid;
    }

    public UUID getParent() {

        return parent;
    }

    public int getSize() {

        return size;
    }

    public long getX() {

        return x;
    }

    public long getY() {

        return y;
    }
}
