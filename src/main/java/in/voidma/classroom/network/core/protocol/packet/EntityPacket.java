package in.voidma.classroom.network.core.protocol.packet;

import io.netty.buffer.ByteBuf;

import java.util.UUID;

public abstract class EntityPacket extends Packet {

    private UUID uuid;

    EntityPacket() {
    }

    EntityPacket(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void encode(ByteBuf out) {
        out.writeLong(uuid.getMostSignificantBits());
        out.writeLong(uuid.getLeastSignificantBits());
    }

    @Override
    public void decode(ByteBuf payload) {
        this.uuid = new UUID(payload.readLong(), payload.readLong());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
