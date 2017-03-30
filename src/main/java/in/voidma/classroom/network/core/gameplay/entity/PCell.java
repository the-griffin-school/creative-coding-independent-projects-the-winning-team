package in.voidma.classroom.network.core.gameplay.entity;

import in.voidma.classroom.network.core.gameplay.Location;
import in.voidma.classroom.network.core.gameplay.Velocity;
import in.voidma.classroom.network.core.gameplay.entity.Entity;

public class PCell extends Entity {

    protected Location loc;
    protected Velocity vel;
    protected int mass;

    public PCell(Location loc, Velocity vel) {
            this.loc = loc;
            this.vel = vel;
    }

    public Location getLocation() {
        return loc;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
    }

    public Velocity getVelocity() {
        return vel;
    }

    public void setVelocity(Velocity vel) {
        this.vel = vel;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
