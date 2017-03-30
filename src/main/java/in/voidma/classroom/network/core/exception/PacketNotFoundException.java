package in.voidma.classroom.network.core.exception;

import in.voidma.classroom.network.core.protocol.packet.Packet;

public class PacketNotFoundException extends Exception {

    private Class<? extends Packet> p;

    public PacketNotFoundException(Class<? extends Packet> p) {
        super(p.getSimpleName() + " is not a valid packet class");
        this.p = p;
    }

    public Class<? extends Packet> getPacket() {
        return p;
    }
}
