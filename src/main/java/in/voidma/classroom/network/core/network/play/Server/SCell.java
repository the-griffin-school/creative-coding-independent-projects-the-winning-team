package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public class SCell extends SBlob {

    UUID parent;

    public SCell(UUID uuid, int mass, float x, float y, UUID parent) {

        super(uuid, mass, x, y);
        this.parent = parent;
    }

    @Override
    public void readPacketData(ByteBuf buf) throws IOException {

        super.readPacketData(buf);
        this.uuid = new UUID(buf.readLong(), buf.readLong());
    }

    @Override
    public void writePacketData(ByteBuf buf) throws IOException {

        super.writePacketData(buf);
        writeUUID(buf, parent);
    }

    public void processPacket(INetHandlerPlayClient handler) {
        handler.processCell(this);
    }

    public UUID getParent() {

        return parent;
    }
}
