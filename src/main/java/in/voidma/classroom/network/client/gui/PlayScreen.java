package in.voidma.classroom.network.client.gui;

import fisica.FWorld;
import fisica.Fisica;
import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.client.entity.Cell;
import in.voidma.classroom.network.client.entity.Player;
import in.voidma.classroom.network.core.gameplay.entity.ICell;

/**
 * Created by Zane on 4/4/2017.
 */
public class PlayScreen extends Screen {

    Player ourPlayer;
    FWorld world;

    public PlayScreen(Client client, FWorld world) {
        super(client);
        this.world = world;
    }


    public PlayScreen(Client client) {
        super(client);

        Fisica.init(client);
        this.world = new FWorld();
    }

    @Override
    public void update() {
        world.step(); //TODO: Update with dynamic time increment
    }

    @Override
    public void draw() {
        float averageMass = 0;
        float averageLocationX = 0;
        float averageLocationY = 0;

        for (ICell c : ourPlayer.getCells()) {
            averageMass += c.getMass();
            averageLocationX += c.getLocation().getX();
            averageLocationY += c.getLocation().getY();
        }

        averageMass = averageMass / ourPlayer.getCells().size();
        averageLocationX = averageLocationX / ourPlayer.getCells().size();
        averageLocationY = averageLocationY / ourPlayer.getCells().size();

        processing.pushMatrix();
        
        world.draw(processing);
        processing.popMatrix();
    }
}
