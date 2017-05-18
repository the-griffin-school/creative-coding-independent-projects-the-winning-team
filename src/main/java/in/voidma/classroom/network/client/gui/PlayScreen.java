package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.entity.ClientPlayer;
import in.voidma.classroom.network.core.entity.EntityStore;
import in.voidma.classroom.network.core.util.Location;

/**
 * Created by Zane on 4/4/2017.
 */
public class PlayScreen extends Screen {

    private ClientPlayer ourPlayer;

    public PlayScreen(Client processing, ClientPlayer ourPlayer) {

        super(processing);
        this.ourPlayer = ourPlayer;
    }

    @Override
    public void update(int seconds) {
        //Step world here
    }

    @Override
    public void draw() {

        // Translate to focus on selected cell.
        Location average = ourPlayer.calculateCenterPoint();

        processing.pushMatrix();
        processing.translate(-1 * average.getX(), -1 * average.getX());
        processing.scale(10);
        processing.scale(-2 * ourPlayer.totalMass());

        EntityStore.instance().drawAll(processing);

        processing.popMatrix();
    }
}
