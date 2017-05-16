package in.voidma.classroom.network.core.entity;

import in.voidma.classroom.network.core.util.Color;
import processing.core.PApplet;

import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public abstract class Blob extends Entity implements Drawable {

    private int mass = 0;
    private float x, y;

    public Blob(UUID id, int mass, float x, float y) {

        super(id);
        this.mass = mass;
        this.x = x;
        this.y = y;
    }

    public void draw(PApplet processing) {

        processing.fill(getColor().prosessingColor());
        processing.ellipse(x, y, (1/2) * mass, (1/2) * mass);
    }

    abstract Color getColor();

    public void addMass(int m) {

        mass += m;
    }

    public int getMass() {

        return this.mass;
    }

    public void move(float x, float y) {

        this.x += x;
        this.y += y;
    }

    public float getX() {

        return x;
    }

    public float getY() {

        return y;
    }
}
