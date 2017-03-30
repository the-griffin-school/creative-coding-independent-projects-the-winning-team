package in.voidma.classroom.network.core.gameplay;

import processing.core.PApplet;

public class Cell extends Entity{

    PApplet p;
    float x, y, w, h;

    public void move(){
        x = p.mouseX;
        y = p.mouseY;

    }
    public Cell (PApplet client, float x, float y, float w, float h) {
        this.p = client;
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
    }
    public void display() {
        p.fill(255);
        p.ellipse(x, y, w, h);
    }

}
