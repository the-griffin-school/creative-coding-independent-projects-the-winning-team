package in.voidma.classroom.network.core.protocol.packet;

import io.netty.buffer.ByteBuf;

import java.util.UUID;

public class CellUpdateMassPacket extends EntityPacket {

    private int mass;

    public CellUpdateMassPacket(UUID uuid, int mass) {
        super(uuid);
        this.mass = mass;
    }

    @Override
    public void encode(ByteBuf out) {
        super.encode(out);
        out.writeInt(mass);
    }

    @Override
    public void decode(ByteBuf payload) {
        super.decode(payload);
        this.mass = payload.readInt();
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
