package in.voidma.classroom.network.core.gameplay.entity;

import in.voidma.classroom.network.core.gameplay.Location;
import in.voidma.classroom.network.core.gameplay.Velocity;

import java.util.UUID;

public class ICell extends Entity {

    protected Location loc;
    protected Velocity vel;
    protected int mass;

    public ICell(Location loc, Velocity vel) {
        super(UUID.randomUUID());
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
