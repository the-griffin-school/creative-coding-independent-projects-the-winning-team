package in.voidma.classroom.network.core.protocol.packet;

import io.netty.buffer.ByteBuf;

import java.util.UUID;

public class CellUpdateLocationPacket extends EntityPacket {

    float x, y, z;
    float j, k, l;

    public CellUpdateLocationPacket(UUID uuid, float x, float y, float z, float j, float k, float l) {
        super(uuid);
        this.x = x;
        this.y = y;
        this.z = z;
        this.j = j;
        this.k = k;
        this.l = l;
    }

    @Override
    public void encode(ByteBuf out) {
        super.encode(out);
        out.writeFloat(x);
        out.writeFloat(y);
        out.writeFloat(z);
        out.writeFloat(j);
        out.writeFloat(k);
        out.writeFloat(l);
    }

    @Override
    public void decode(ByteBuf payload) {
        super.decode(payload);
        this.x = payload.readFloat();
        this.y = payload.readFloat();
        this.z = payload.readFloat();
        this.j = payload.readFloat();
        this.k = payload.readFloat();
        this.l = payload.readFloat();
    }


}
