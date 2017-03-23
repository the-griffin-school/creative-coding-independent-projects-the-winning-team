package in.voidma.classroom.network.core.protocol.packet;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.UUID;

public class PlayerUpdateNamePacket extends EntityPacket {

    private String name;

    public PlayerUpdateNamePacket(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    @Override
    public void encode(ByteBuf out) {
        super.encode(out);
        out.writeByte(name.length());
        out.writeCharSequence(name, Charset.defaultCharset());
    }

    @Override
    public void decode(ByteBuf payload) {
        super.decode(payload);
        byte length = payload.readByte();
        this.name = payload.readCharSequence(length, Charset.defaultCharset()).toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
