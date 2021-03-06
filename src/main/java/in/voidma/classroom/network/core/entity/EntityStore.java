package in.voidma.classroom.network.core.entity;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import processing.core.PApplet;

import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public class EntityStore {

    private static EntityStore Instance;

    static {
        Instance = new EntityStore();
    }

    private BiMap<UUID, Entity> entityMap;

    private EntityStore() {

        entityMap = HashBiMap.create();
    }

    public static EntityStore instance() {

        return Instance;
    }

    public void register(UUID id, Entity entity) {

        entityMap.put(id, entity);
    }

    public void deregister(Entity entity) {

        entityMap.inverse().remove(entity);
    }

    public void deregister(UUID id) {

        entityMap.remove(id);
    }

    public Entity get(UUID id) {

        return entityMap.get(id);
    }

    public UUID get(Entity entity) {

        return entityMap.inverse().get(entity);
    }

    public <T extends Entity> T get(UUID id, Class<T> type) {

        Entity entity = entityMap.get(id);
        return type.cast(entity);
    }

    public Player getPlayer(UUID id) {

        return get(id, Player.class);
    }

    public Blob getBlob(UUID id) {

        return get(id, Blob.class);
    }

    public void drawAll(PApplet p) {

        entityMap
                .values()
                .stream()
                .filter(e -> e instanceof Drawable)
                .map(e -> (Drawable) e)
                .forEach(d -> d.draw(p));
    }
}
