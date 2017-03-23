package in.voidma.classroom.network.core.gameplay;

import processing.core.PApplet;

public class Cell {

    PApplet p;
    float x, y, w, h;
    Cell (PApplet client, float x, float y, float w, float h) {
        this.p = client;
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
    }
    void display() {
        p.ellipse(x, y, w, h);
    }

}
