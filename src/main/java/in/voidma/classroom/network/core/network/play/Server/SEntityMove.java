package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/26/2017.
 */
//TODO: Milea dd stuff in here
public class SEntityMove implements Packet<INetHandlerPlayClient> {

    UUID uuid;
    int xChange, yChange;

    public SEntityMove(UUID uuid, int xChnage, int yChange) {
        this.uuid = uuid;
        this.xChange = xChnage;
        this.yChange = yChange;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());
        xChange = buf.readInt();
        yChange = buf.readInt();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        buf.writeInt(xChange);
        buf.writeInt(yChange);
    }

    public void processPacket(INetHandlerPlayClient handler) {
        handler.processEntityMove(this);
    }
}
