package in.voidma.classroom.network.core.protocol;

import in.voidma.classroom.network.core.protocol.packet.*;

public enum PacketType {
    PLAYER_SPAWN(PlayerSpawnPacket.class),
    FOOD_SPAWN(FoodSpawnPacket.class),
    CELL_SPAWN(CellSpawnPacket.class),
    ENTITY_DESPAWN(EntityDespawnPacket.class),
    PLAYER_UPDATE_COLOR(PlayerUpdateColorPacket.class),
    PLAYER_UPDATE_NAME(PlayerUpdateNamePacket.class),
    CELL_UPDATE_MASS(CellUpdateMassPacket.class);

    private Class<? extends Packet> packet;

    PacketType(Class<? extends Packet> packet) {
        this.packet = packet;
    }

    public static PacketType getType(byte value) {
        return PacketType.values()[value];
    }

    public static Class<? extends Packet> getPacket(byte value) {
        return getType(value).getPacket();
    }

    public Class<? extends Packet> getPacket() {
        return packet;
    }

    public byte getID() {
        return (byte) this.ordinal();
    }
}
