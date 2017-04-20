package in.voidma.classroom.network.client.gui;

import fisica.FWorld;
import fisica.Fisica;
import in.voidma.classroom.network.client.Client;
import processing.event.KeyEvent;

/**
 * Created by Zane on 4/4/2017.
 */
public abstract class Screen {

    protected Client processing;
    protected FWorld world;

    public Screen(Client processing, FWorld world) {
        this.processing = processing;
        this.world = world;
    }

    public Screen(Client processing) {
        this.processing = processing;
        Fisica.init(processing);
        this.world = new FWorld();
    }

    public abstract void update(int seconds);
    public abstract void draw();

    public void keyPressed() {
    }

    public void keyPressed(KeyEvent event) {
    }
}
