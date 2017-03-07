package in.voidma.classroom.network.core.protocol;

public class Envelope {
    private byte type;
    private byte[] payload;

    public Envelope() {
    }

    public Envelope(byte type, byte[] payload) {
        this.type = type;
        this.payload = payload;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }
}