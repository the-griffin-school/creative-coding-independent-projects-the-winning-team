package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by schan on 4/26/2017.
 */

//TODO: miles add stuff in here
public class SMassUpdate extends SEntity {

    int massChange;

    public SMassUpdate(UUID uuid, int massChange) {

        super(uuid);
        this.massChange = massChange;
    }

    @Override
    public void readPacketData(ByteBuf buf) throws IOException {

        super.readPacketData(buf);
        this.massChange = buf.readInt();
    }

    @Override
    public void writePacketData(ByteBuf buf) throws IOException {

        super.writePacketData(buf);
        buf.writeInt(massChange);
    }

    public void processPacket(INetHandlerPlayClient handler) {
        handler.processMassUpdate(this);
    }

    public int getMassChange() {

        return massChange;
    }
}
