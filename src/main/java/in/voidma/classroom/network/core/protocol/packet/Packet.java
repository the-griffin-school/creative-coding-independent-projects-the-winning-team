package in.voidma.classroom.network.core.protocol.packet;

import in.voidma.classroom.network.core.exception.PacketNotFoundException;
import in.voidma.classroom.network.core.protocol.PacketType;
import io.netty.buffer.ByteBuf;

public abstract class Packet {
    public Packet() {
    }

    public abstract void encode(ByteBuf out);

    public abstract void decode(ByteBuf payload);

    public PacketType getType() throws Exception {
        for (PacketType type : PacketType.values()) {
            if (type.getPacket().equals(this.getClass())) {
                return type;
            }
        }
        throw new PacketNotFoundException(this.getClass());
    }

    public byte getID() throws Exception {
        return getType().getID();
    }
}
