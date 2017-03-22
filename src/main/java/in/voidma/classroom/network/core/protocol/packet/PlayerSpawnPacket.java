package in.voidma.classroom.network.core.protocol.packet;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.UUID;

public class PlayerSpawnPacket extends EntityPacket {

    byte color;
    private String name;

    public PlayerSpawnPacket(UUID uuid, byte color, String name) {
        super(uuid);
        this.color = color;
        this.name = name;
    }

    @Override
    public void encode(ByteBuf out) {
        super.encode(out);
        out.writeByte(color);
        out.writeByte(name.length());
        out.writeCharSequence(name, Charset.defaultCharset());
    }

    @Override
    public void decode(ByteBuf payload) {
        super.decode(payload);
        this.color = payload.readByte();
        byte length = payload.readByte();
        this.name = payload.readCharSequence(length, Charset.defaultCharset()).toString();
    }

    public byte getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
