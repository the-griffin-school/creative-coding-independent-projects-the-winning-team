package in.voidma.classroom.network.core.entity;

import processing.core.PApplet;

/**
 * Created by schan on 5/16/2017.
 */
public class Blob extends Entity {
    int mass = 0;
    long x, y;

    public Blob(int mass, long x, long y) {
        this.mass = mass;
        this.x = x;
        this.y = y;
    }

    public void draw(PApplet processing) {
        processing.ellipse(x, y, (1/2) * mass, (1/2) * mass);
    }
}
