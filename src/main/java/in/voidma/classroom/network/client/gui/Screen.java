package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.gameplay.Database;

/**
 * Created by Zane on 4/4/2017.
 */
public abstract class Screen {

    protected Client processing;
    protected Database database;

    public Screen(Client processing) {
        this.processing = processing;
        database = Database.getInstance();
    }

    public abstract void update ();
    public abstract void draw();
}
