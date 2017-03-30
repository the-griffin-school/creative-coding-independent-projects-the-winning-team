package in.voidma.classroom.network.core.gameplay.entity;

import in.voidma.classroom.network.core.gameplay.Database;

import java.util.UUID;

/**
 * Created by Zane on 3/30/2017.
 */
public class Entity {

    private UUID uuid;

    public Entity(UUID uuid) {
        this.uuid = uuid;
        Database.getInstance().add(this.uuid, this);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
