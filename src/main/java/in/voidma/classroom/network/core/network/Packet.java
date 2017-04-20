package in.voidma.classroom.network.core.network;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

public interface Packet<T extends INetHandler> {

    void readPacketData(ByteBuf buf) throws IOException;

    void writePacketData(ByteBuf buf) throws IOException;

    void processPacket(T handler);
}
