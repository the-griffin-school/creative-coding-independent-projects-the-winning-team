package in.voidma.classroom.network.core.entity;

import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public abstract class Entity {

    protected static EntityStore entityStore;

    static {
        entityStore = EntityStore.instance();
    }

    public Entity(UUID uuid) {

        entityStore.register(uuid, this);
    }

    public void update() {

    }

    public void remove() {

        entityStore.deregister(this);
    }

    public UUID getUUID() {

        return entityStore.get(this);
    }
}
