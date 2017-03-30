package in.voidma.classroom.network.core.gameplay;

import in.voidma.classroom.network.core.gameplay.entity.Entity;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by Zane on 3/30/2017.
 */
public class Database {

    private static Database instance;

    private ConcurrentHashMap<UUID, Entity> entities;

    private Database() {
        entities = new ConcurrentHashMap<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public Entity get(UUID uuid) {
        return entities.get(uuid);
    }

    public Collection<Entity> getAll() {
        return entities.values();
    }

    public Collection<? extends Entity> getAll(Class<? extends Entity> type) {
        return getAll()
                .stream()
                .filter(p -> type.isInstance(p))
                .map(p -> type.cast(p))
                .collect(Collectors.toList());
    }

    public void add(UUID uuid, Entity entity) {
        entities.put(uuid, entity);
    }

    public void remove(UUID uuid) {
        entities.remove(uuid);
    }
}
