package in.voidma.classroom.network.core.network.login.server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.login.INetHandlerLoginClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/25/2017.
 */
public class SLoginSuccess implements Packet<INetHandlerLoginClient> {

    private UUID id;

    //sent to Client when server approves the login


    public SLoginSuccess(UUID id) {

        this.id = id;
    }

    public void readPacketData(ByteBuf buf) throws IOException {

        this.id = new UUID(buf.readLong(), buf.readLong());
    }

    public void writePacketData(ByteBuf buf) throws IOException {

        buf.writeLong(id.getMostSignificantBits());
        buf.writeLong(id.getLeastSignificantBits());
    }

    public void processPacket(INetHandlerLoginClient handler) {
        handler.processLoginSuccess(this);
    }

    public UUID getId() {

        return id;
    }
}
