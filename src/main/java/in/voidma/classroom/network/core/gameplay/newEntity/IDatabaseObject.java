package in.voidma.classroom.network.core.gameplay.newEntity;

import in.voidma.classroom.network.core.gameplay.Database;

public interface IDatabaseObject {

    Database database = Database.getInstance();

    void add();

    void delete();
}
