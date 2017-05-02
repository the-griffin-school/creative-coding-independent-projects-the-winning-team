package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/26/2017.
 */

//TODO: miles add stuff in here
public class SMassUpdate implements Packet<INetHandlerPlayClient> {

    UUID uuid;
    int massChange;

    public SMassUpdate(UUID uuid, int massChange) {
        this.uuid = uuid;
        this.massChange = massChange;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());
        massChange = buf.readInt();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        buf.writeInt(massChange);
    }

    public void processPacket(INetHandlerPlayClient handler) {
        handler.processMassUpdate(this);
    }
}
