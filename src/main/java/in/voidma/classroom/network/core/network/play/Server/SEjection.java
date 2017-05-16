package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public class SEjection extends SBlob {

    UUID parentID;

    public SEjection(UUID uuid, UUID parentID, int mass, float x, float y) {

        super(uuid, mass, x, y);
        this.parentID = parentID;
    }

    @Override
    public void readPacketData(ByteBuf buf) throws IOException {

        super.readPacketData(buf);
        this.parentID = new UUID(buf.readLong(), buf.readLong());
    }

    @Override
    public void writePacketData(ByteBuf buf) throws IOException {

        super.writePacketData(buf);
        writeUUID(buf, parentID);
    }

    public void processPacket(INetHandlerPlayClient handler) {

        handler.processEjection(this);
    }
}
