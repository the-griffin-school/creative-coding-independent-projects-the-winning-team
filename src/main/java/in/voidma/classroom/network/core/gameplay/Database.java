package in.voidma.classroom.network.core.gameplay;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Zane on 3/30/2017.
 */
public class Database {
    HashMap<UUID, Entity> objects;

    Database() {
        objects = new HashMap<>();
    }
}
