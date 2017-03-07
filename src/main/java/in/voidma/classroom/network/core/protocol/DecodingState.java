package in.voidma.classroom.network.core.protocol;

public enum DecodingState {
    VERSION,
    TYPE,
    PAYLOAD_LENGTH,
    PAYLOAD,
}
