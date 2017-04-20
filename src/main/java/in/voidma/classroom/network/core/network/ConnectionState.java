package in.voidma.classroom.network.core.network;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.network.handshake.client.Handshake;
import in.voidma.classroom.network.core.network.login.client.CLoginStart;

import javax.annotation.Nullable;
import java.util.Map;

public enum ConnectionState {

    HANDSHAKING(-1) {
        {
            this.registerPacket(PacketDirection.SERVERBOUND, Handshake.class);
        }
    },
    PLAY(0) {
        {

        }
    },
    STATUS(1) {
        {

        }
    },
    LOGIN(2) {
        {
            this.registerPacket(PacketDirection.SERVERBOUND, CLoginStart.class);
        }
    };

    private static final ConnectionState[] STATES_BY_ID = new ConnectionState[4];
    private static final Map<Class<? extends Packet<?>>, ConnectionState> STATES_BY_CLASS = Maps.newHashMap();

    static {
        for (ConnectionState connectionstate : values()) {
            int i = connectionstate.getId();

            if (i < -1 || i > 2) {
                throw new Error("Invalid protocol ID " + Integer.toString(i));
            }

            STATES_BY_ID[i - -1] = connectionstate;

            for (PacketDirection packetdirection : connectionstate.directionMaps.keySet()) {
                for (Class<? extends Packet<?>> packetClass : (connectionstate.directionMaps.get(packetdirection)).values()) {
                    if (STATES_BY_CLASS.containsKey(packetClass) && STATES_BY_CLASS.get(packetClass) != connectionstate) {
                        throw new Error("Packet " + packetClass + " is already assigned to protocol " + STATES_BY_CLASS.get(packetClass) + " - can\'t reassign to " + connectionstate);
                    }

                    try {
                        packetClass.newInstance();
                    } catch (Throwable throwable) {
                        throw new Error("Packet " + packetClass + " fails instantiation checks! " + packetClass);
                    }

                    STATES_BY_CLASS.put(packetClass, connectionstate);
                }
            }
        }
    }

    private final int id;
    private final Map<PacketDirection, BiMap<Integer, Class<? extends Packet<?>>>> directionMaps;

    ConnectionState(int protocolId) {
        this.directionMaps = Maps.newEnumMap(PacketDirection.class);
        this.id = protocolId;
    }

    public static ConnectionState getById(int stateId) {
        return stateId >= -1 && stateId <= 2 ? STATES_BY_ID[stateId - -1] : null;
    }

    public static ConnectionState getFromPacket(Packet<?> packetIn) {
        return STATES_BY_CLASS.get(packetIn.getClass());
    }

    protected ConnectionState registerPacket(PacketDirection direction, Class<? extends Packet<?>> packetClass) {
        BiMap<Integer, Class<? extends Packet<?>>> bimap = this.directionMaps.get(direction);

        if (bimap == null) {
            bimap = HashBiMap.create();
            this.directionMaps.put(direction, bimap);
        }

        if (bimap.containsValue(packetClass)) {
            String s = direction + " packet " + packetClass + " is already known to ID " + bimap.inverse().get(packetClass);
            Client.println(direction + " packet " + packetClass + " is already known to ID " + bimap.inverse().get(packetClass));
            throw new IllegalArgumentException(s);
        } else {
            bimap.put(Integer.valueOf(bimap.size()), packetClass);
            return this;
        }
    }

    public Integer getPacketId(PacketDirection direction, Packet<?> packetIn) {
        return (Integer) ((BiMap) this.directionMaps.get(direction)).inverse().get(packetIn.getClass());
    }

    @Nullable
    public Packet<?> getPacket(PacketDirection direction, int packetId) throws InstantiationException, IllegalAccessException {
        Class<? extends Packet<?>> oclass = (Class) ((BiMap) this.directionMaps.get(direction)).get(Integer.valueOf(packetId));
        return oclass == null ? null : oclass.newInstance();
    }

    public int getId() {
        return this.id;
    }
}
