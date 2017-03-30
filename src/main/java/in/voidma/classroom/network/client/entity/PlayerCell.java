package in.voidma.classroom.network.client.entity;

import in.voidma.classroom.network.core.gameplay.Location;
import in.voidma.classroom.network.core.gameplay.Velocity;
import processing.core.PApplet;

/**
 * Created by Zane on 3/30/2017.
 */
public class PlayerCell extends Cell {

    public PlayerCell(Location loc, Velocity vel, PApplet p) {
        super(loc, vel, p);
    }

    public void move() {
        float Xdif = p.mouseX-loc.getX()-25;
        float Ydif = p.mouseY-loc.getX()-25;
        float angle = (float)(Math.atan2(Ydif, Xdif) * 180 / Math.PI);
        float dX = (float)Math.cos(angle * Math.PI/180) * 8;
        float dY = (float)Math.sin(angle * Math.PI/180) * 8;
        setVelocity(new Velocity(dX, dY));
    }
}
