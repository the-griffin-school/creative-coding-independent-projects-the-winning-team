package in.voidma.classroom.network.core.protocol;

public interface Packet {
    byte[] encode();

    Packet decode(byte[] payload);
}
