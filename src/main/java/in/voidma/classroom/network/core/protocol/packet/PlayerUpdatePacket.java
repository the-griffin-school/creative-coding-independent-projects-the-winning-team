package in.voidma.classroom.network.core.protocol.packet;

import in.voidma.classroom.network.core.protocol.Packet;

public class PlayerUpdatePacket implements Packet {

    @Override
    public byte[] encode() {
        return new byte[0];
    }

    @Override
    public Packet decode(byte[] payload) {
        return null;
    }
}
