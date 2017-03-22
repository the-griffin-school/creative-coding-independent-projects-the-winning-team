package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;

class Envelope {
    private byte id;
    private ByteBuf payload;

    Envelope() {
    }

    byte getID() {
        return id;
    }

    void setID(byte type) {
        this.id = type;
    }

    ByteBuf getPayload() {
        return payload;
    }

    void setPayload(ByteBuf payload) {
        this.payload = payload;
    }
}