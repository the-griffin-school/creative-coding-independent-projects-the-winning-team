package in.voidma.classroom.network.client;

import in.voidma.classroom.network.core.Network;
import processing.core.PApplet;

public class Client extends PApplet {

    @Override
    public void setup() {
        super.setup();
    }

    @Override
    public void settings() {
        size(700, 700);
    }


    @Override
    public void draw() {
        super.draw();

        ellipse(50, 50, 50, 50);
    }

    public static void main(String[] args) {
        PApplet.main(Client.class, args);


    }
}
