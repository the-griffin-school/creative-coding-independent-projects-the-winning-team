package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;

/**
 * Created by Zane on 4/4/2017.
 */
public abstract class Screen {

    private Client processing;

    public Screen(Client processing) {
        this.processing = processing;
    }

    public abstract void update ();
    public abstract void draw();
}
