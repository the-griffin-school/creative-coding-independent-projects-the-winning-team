package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.entity.ClientPlayer;

/**
 * Created by Zane on 4/4/2017.
 */
public class PlayScreen extends Screen {

    private ClientPlayer ourPlayer;

    private float averageMass = 0;
    private float averageX = 0;
    private float averageY = 0;

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
        processing.pushMatrix();
        processing.translate(-1 * averageX, -1 * averageY);
        processing.scale(10);
        processing.scale(-2 * averageMass);
        //Draw world here
        processing.popMatrix();
    }
}
