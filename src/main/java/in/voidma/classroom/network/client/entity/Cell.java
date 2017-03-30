package in.voidma.classroom.network.client.entity;

import in.voidma.classroom.network.core.gameplay.Location;
import in.voidma.classroom.network.core.gameplay.Velocity;
import in.voidma.classroom.network.core.gameplay.entity.PCell;
import processing.core.PApplet;

public class Cell extends PCell {

    protected PApplet p;

    public Cell(Location loc, Velocity vel, PApplet p) {
        super(loc, vel);
        this.p = p;
    }

    public void display() {
        p.fill(255);
        p.ellipse(loc.getX(), loc.getY(), mass, mass);
    }

}
