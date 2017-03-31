//  o8o                                         .        88                           .                              .        o8o
//  `"'                                       .o8       .8'                         .o8                            .o8        `"'
// oooo  ooo. .oo.   oo.ooooo.  oooo  oooo  .o888oo    .8'   .ooooo.  oooo  oooo  .o888oo oo.ooooo.  oooo  oooo  .o888oo     oooo   .ooooo.
// `888  `888P"Y88b   888' `88b `888  `888    888     .8'   d88' `88b `888  `888    888    888' `88b `888  `888    888       `888  d88' `88b
//  888   888   888   888   888  888   888    888    .8'    888   888  888   888    888    888   888  888   888    888        888  888   888
//  888   888   888   888   888  888   888    888 . .8'     888   888  888   888    888 .  888   888  888   888    888 . .o.  888  888   888
// o888o o888o o888o  888bod8P'  `V88V"V8P'   "888" 88      `Y8bod8P'  `V88V"V8P'   "888"  888bod8P'  `V88V"V8P'   "888" Y8P o888o `Y8bod8P'
//                    888                                                                  888
//                   o888o                                                                o888o
//
// Miles Silberling-Cook
// Zane Alversomething
// Samantha Channow
//

package in.voidma.classroom.network.core.protocol;

import in.voidma.classroom.network.core.protocol.packet.*;

/**
 * The crazy voodoo magic that holdes packet serialisation together
 * Caution: Self explanatory yet fragile
 *
 * @author Miles
 */
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
