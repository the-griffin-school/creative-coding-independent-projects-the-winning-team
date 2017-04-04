//
//  o8o                                         .        88                           .                              .        o8o
//  `"'                                       .o8       .8'                         .o8                            .o8        `"'
// oooo  ooo. .oo.   oo.ooooo.  oooo  oooo  .o888oo    .8'   .ooooo.  oooo  oooo  .o888oo oo.ooooo.  oooo  oooo  .o888oo     oooo   .ooooo.
// `888  `888P"Y88b   888' `88b `888  `888    888     .8'   d88' `88b `888  `888    888    888' `88b `888  `888    888       `888  d88' `88b
//  888   888   888   888   888  888   888    888    .8'    888   888  888   888    888    888   888  888   888    888        888  888   888
//  888   888   888   888   888  888   888    888 . .8'     888   888  888   888    888 .  888   888  888   888    888 . .o.  888  888   888
// o888o o888o o888o  888bod8P'  `V88V"V8P'   "888" 88      `Y8bod8P'  `V88V"V8P'   "888"  888bod8P'  `V88V"V8P'   "888" Y8P o888o `Y8bod8P'
//                    888                                                                  888
//                   o888o                                                                o888o
//
// Miles Silberling-Cook
// Zane Alversomething
// Samantha Channow
//

package in.voidma.classroom.network.core.gameplay;

import in.voidma.classroom.network.core.gameplay.entity.Entity;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * A singleton keystore async database for storing entities by UUID
 *
 * @author Miles
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
