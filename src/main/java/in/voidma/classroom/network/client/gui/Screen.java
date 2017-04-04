package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;

/**
 * Created by Zane on 4/4/2017.
 */
public abstract class Screen {

    Client client;

    public Screen(Client client) {
        this.client = client;
    }

    public abstract void update ();
    public abstract void draw();
}
