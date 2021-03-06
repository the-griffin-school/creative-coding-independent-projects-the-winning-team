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
public class SMove implements Packet<INetHandlerPlayClient> {

    private UUID uuid;
    private float xChange, yChange;

    public SMove(UUID uuid, int xChnage, int yChange) {
        this.uuid = uuid;
        this.xChange = xChnage;
        this.yChange = yChange;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        uuid = new UUID(buf.readLong(), buf.readLong());
        xChange = buf.readFloat();
        yChange = buf.readFloat();
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        buf.writeFloat(xChange);
        buf.writeFloat(yChange);
    }

    public void processPacket(INetHandlerPlayClient handler) {

        handler.processMove(this);
    }

    public UUID getUuid() {

        return uuid;
    }

    public float getxChange() {

        return xChange;
    }

    public float getyChange() {

        return yChange;
    }
}
