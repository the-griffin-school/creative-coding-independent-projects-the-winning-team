package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public abstract class SEntity implements Packet<INetHandlerPlayClient> {

    protected UUID uuid;

    public SEntity(UUID uuid) {

        this.uuid = uuid;
    }

    public void readPacketData(ByteBuf buf) throws IOException {

        this.uuid = new UUID(buf.readLong(), buf.readLong());
    }

    public void writePacketData(ByteBuf buf) throws IOException {

        writeUUID(buf, this.uuid);
    }

    protected void writeUUID(ByteBuf buf, UUID id) {

        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());
    }

    public UUID getUuid() {

        return uuid;
    }
}
