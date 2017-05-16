package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public class SPlayer extends SEntity {

    private String name;
    private int color;

    public SPlayer(UUID uuid, String name, int color) {

        super(uuid);
        this.name = name;
        this.color = color;
    }

    @Override
    public void readPacketData(ByteBuf buf) throws IOException {

        super.readPacketData(buf);
        this.color = buf.readInt();
        int stringLength = buf.readInt();
        this.name = buf.readBytes(stringLength).toString();
    }

    @Override
    public void writePacketData(ByteBuf buf) throws IOException {

        super.writePacketData(buf);
        buf.writeInt(color);
        buf.writeInt(name.length());
        buf.writeBytes(name.getBytes());
    }

    public void processPacket(INetHandlerPlayClient handler) {

        handler.processPlayer(this);
    }

    public String getName() {

        return name;
    }

    public int getColor() {

        return color;
    }
}
