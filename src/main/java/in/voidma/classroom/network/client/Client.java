package in.voidma.classroom.network.client;

import processing.core.PApplet;

public class Client extends PApplet {

    public static void main(String[] args) {
        PApplet.main(Client.class, args);
    }

    @Override
    public void settings() {
        size(800, 800);
    }

    @Override
    public void setup() {
        background(0);
    }

    @Override
    public void draw() {
        //background(0);
        fill(255);
        noStroke();
        ellipse(mouseX, mouseY, 40, 40);
    }
}
