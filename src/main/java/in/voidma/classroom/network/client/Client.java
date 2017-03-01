package in.voidma.classroom.network.client;

import in.voidma.classroom.network.core.Network;
import processing.core.PApplet;

public class Client extends PApplet {

    @Override
    public void setup() {
        super.setup();
        Network n = new Network(this);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public static void main(String[] args) {
        PApplet.main(Client.class, args);


    }
}
