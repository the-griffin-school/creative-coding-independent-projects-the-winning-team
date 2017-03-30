package in.voidma.classroom.network.client;

import in.voidma.classroom.network.core.gameplay.PCell;
import processing.core.PApplet;

public class Cell extends PCell {

    protected PApplet p;

    public Cell(PApplet client, float x, float y, float w, float h) {
        super(x, y, w, h);
        this.p = client;
    }

    public void display() {
        p.fill(255);
        p.ellipse(x, y, w, h);
    }

    public void move() {
        x = p.mouseX;
        y = p.mouseY;

    }

}
