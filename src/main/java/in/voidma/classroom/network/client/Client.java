package in.voidma.classroom.network.client;

import in.voidma.classroom.network.client.entity.Cell;
import processing.core.PApplet;

public class Client extends PApplet {

    Cell cell;
    PApplet p = new PApplet();

    public static void main(String[] args) {
        PApplet.main(Client.class, args);
    }

    @Override
    public void settings() {
        size(800, 800);
    }

    @Override
    public void setup() {
        p.background(0);
        cell = new Cell(p, mouseX, mouseY, 40, 40);

    }

    @Override
    public void draw() {
        //background(0);
        p.fill(255);
        p.ellipse(height/2, width/2,50,50);
        p.noStroke();
        cell.display();
        cell.move();
    }
}
