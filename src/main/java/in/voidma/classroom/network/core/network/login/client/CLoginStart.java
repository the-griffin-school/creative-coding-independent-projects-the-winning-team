package in.voidma.classroom.network.core.network.login.client;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.login.INetHandlerLoginServer;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class CLoginStart implements Packet<INetHandlerLoginServer> {

    private int color;
    private String name;

    public CLoginStart(int color, String name) {
        this.color = color;
        this.name = name;
    }

    public void readPacketData(ByteBuf buf) throws IOException {
        this.color = buf.readInt();
        int nameLength = (int) buf.readByte();
        this.name = new String(buf.readBytes(nameLength).array(), "UTF-8");
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
    }

    public void processPacket(INetHandlerLoginServer handler) {
        handler.processLoginStart(this);
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
