package in.voidma.classroom.network.core.gameplay;

import processing.core.PApplet;

public class Cell extends Entity{

    PApplet p;
    Location loc;
    Velocity voc;

    public void move(Location loc, Velocity voc) {

    }
    public Cell (PApplet client, Location loc, Velocity vel) {
        this.p = client;
        this.loc = loc;
        this.voc = vel;
    }
    public void display() {
        p.fill(255);
        p.ellipse(loc.x, loc.y, 40, 40);
    }

}
