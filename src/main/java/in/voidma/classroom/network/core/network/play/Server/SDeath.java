package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 5/2/2017.
 */
public class SDeath implements Packet<INetHandlerPlayClient> {

    UUID uuid;
    int size;

    public SDeath(UUID uuid, int size) {
        this.uuid = uuid;
        this.size = size;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());
        size = buf.readInt();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());
        buf.writeInt(size);
    }

    public void processPacket(INetHandlerPlayClient handler) {
        handler.processDeath(this);
    }
}
