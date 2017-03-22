package in.voidma.classroom.network.core.protocol;

import in.voidma.classroom.network.core.protocol.exception.PacketNotFoundException;
import in.voidma.classroom.network.core.protocol.packet.PlayerUpdatePacket;

public enum PacketType {
    PLAYER_UPDATE_PACKET(PlayerUpdatePacket.class);

    private Class<? extends Packet> packet;

    PacketType(Class<? extends Packet> packet) {
        this.packet = packet;
    }

    public static PacketType getType(byte value) {
        return PacketType.values()[value];
    }

    public static PacketType getType(Packet packet) throws PacketNotFoundException {
        for (PacketType type : PacketType.values()) {
            if (type.getPacket().equals(packet.getClass())) {
                return type;
            }
        }
        throw new PacketNotFoundException(packet);
    }

    public Class<? extends Packet> getPacket() {
        return packet;
    }

    public byte getID() {
        return (byte) this.ordinal();
    }
}
