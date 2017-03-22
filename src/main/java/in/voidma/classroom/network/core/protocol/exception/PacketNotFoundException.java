package in.voidma.classroom.network.core.protocol.exception;

import in.voidma.classroom.network.core.protocol.Packet;

public class PacketNotFoundException extends Exception {

    private Packet p;

    public PacketNotFoundException(Packet p) {
        super(p.getClass().getSimpleName() + " is not a valid packet");
        this.p = p;
    }

    public Packet getPacket() {
        return p;
    }
}
