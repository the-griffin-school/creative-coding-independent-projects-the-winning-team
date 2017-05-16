package in.voidma.classroom.network.core.entity;

import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public abstract class Entity {
    UUID uuid;

    public void update() {};

    public void remove() {};

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}
