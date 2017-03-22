package in.voidma.classroom.network.core.protocol.packet;

import io.netty.buffer.ByteBuf;

import java.util.UUID;

public class CellSpawnPacket extends EntityPacket {

    private UUID parent;
    private float x, y, z;
    private int mass;

    public CellSpawnPacket(UUID old, UUID parent, float x, float y, float z, int mass) {
        super(old);
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    @Override
    public void encode(ByteBuf out) {
        super.encode(out);
        out.writeLong(parent.getLeastSignificantBits());
        out.writeLong(parent.getMostSignificantBits());
        out.writeFloat(x);
        out.writeFloat(y);
        out.writeFloat(z);
        out.writeInt(mass);
    }

    @Override
    public void decode(ByteBuf payload) {
        super.decode(payload);
        this.parent = new UUID(payload.readLong(), payload.readLong());
        this.x = payload.readFloat();
        this.y = payload.readFloat();
        this.z = payload.readFloat();
        this.mass = payload.readInt();
    }

    public UUID getParent() {
        return parent;
    }

    public void setParent(UUID parent) {
        this.parent = parent;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
