package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public class SPlayerCreate implements Packet<INetHandlerPlayClient> {

    UUID uuid;

    int color;

    String name;

    ArrayList<UUID> uuids;

    public SPlayerCreate(int color, String name, UUID uuid) {
        this.color = color;
        this.name = name;
        this.uuid= uuid;
        uuids = new ArrayList<UUID>();
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        color = buf.readInt();
        int nameLength = (int) buf.readByte();
        this.name = new String(buf.readBytes(nameLength).array(), "UTF-8");

        uuid = new UUID(buf.readLong(), buf.readLong());

        while(buf.readLong() != 01010101010101010101010L) {
            uuids.add(new UUID(buf.readLong(), buf.readLong()));
        }
    }

    public void writePacketData(ByteBuf buf) throws IOException {
        buf.writeInt(color);
        byte[] nameBytes = name.getBytes("UTF-8");
        if (nameBytes.length < 32) {
            buf.writeByte((byte) nameBytes.length);
            buf.writeBytes(nameBytes);
        } else {
            throw new Error("Name to large to send");
        }
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());

        int n = uuids.size();
        buf.writeInt(n);
        for (int i = 0; i < n; i++) {
            buf.writeLong(uuids.get(i).getMostSignificantBits());
            buf.writeLong(uuids.get(i).getLeastSignificantBits());
        }
        buf.writeLong(01010101010101010101010L);
    }

    public void processPacket(INetHandlerPlayClient handler) {

    }
}
