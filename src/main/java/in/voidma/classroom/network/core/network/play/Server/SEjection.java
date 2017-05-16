package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.Packet;
import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * Created by Miles on 5/16/2017.
 */
public class SEjection implements Packet<INetHandlerPlayClient> {

    public void readPacketData(ByteBuf buf) throws IOException {

    }

    public void writePacketData(ByteBuf buf) throws IOException {

    }

    public void processPacket(INetHandlerPlayClient handler) {

    }
}
