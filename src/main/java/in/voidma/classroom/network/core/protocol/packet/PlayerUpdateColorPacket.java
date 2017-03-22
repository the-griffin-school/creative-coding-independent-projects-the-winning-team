package in.voidma.classroom.network.core.protocol.packet;

import io.netty.buffer.ByteBuf;

import java.util.UUID;

public class PlayerUpdateColorPacket extends EntityPacket {

    private byte color;

    public PlayerUpdateColorPacket(UUID uuid, byte color) {
        super(uuid);
        this.color = color;
    }

    @Override
    public void encode(ByteBuf out) {
        super.encode(out);
        out.writeByte(color);
    }

    @Override
    public void decode(ByteBuf payload) {
        super.decode(payload);
        color = payload.readByte();
    }

    public byte getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }
}
