package in.voidma.classroom.network.core.network.play.Server;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public abstract class SBlob extends SEntity {

    protected int mass;
    protected float x;
    protected float y;

    public SBlob(UUID uuid, int mass, float x, float y) {

        super(uuid);
        this.mass = mass;
        this.x = x;
        this.y = y;
    }

    @Override
    public void readPacketData(ByteBuf buf) throws IOException {

        super.readPacketData(buf);

        this.mass = buf.readInt();
        this.x = buf.readFloat();
        this.y = buf.readFloat();
    }

    @Override
    public void writePacketData(ByteBuf buf) throws IOException {

        super.writePacketData(buf);

        buf.writeInt(mass);
        buf.writeFloat(x);
        buf.writeFloat(y);
    }

    public int getMass() {

        return mass;
    }

    public float getX() {

        return x;
    }

    public float getY() {

        return y;
    }
}
