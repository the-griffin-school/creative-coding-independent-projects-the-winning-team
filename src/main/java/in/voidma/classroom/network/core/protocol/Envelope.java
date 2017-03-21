package in.voidma.classroom.network.core.protocol;

class Envelope {
    private byte type;
    private byte[] payload;

    Envelope() {
    }

    byte getType() {
        return type;
    }

    void setType(byte type) {
        this.type = type;
    }

    byte[] getPayload() {
        return payload;
    }

    void setPayload(byte[] payload) {
        this.payload = payload;
    }
}