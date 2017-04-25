package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.client.entity.Cell;
import in.voidma.classroom.network.client.entity.Player;

/**
 * Created by schan on 4/18/2017.
 */
public class DeathScreen extends Screen {

    Player ourPlayer;
    int finalMass;

    public DeathScreen(Client client) {
        super(client);

        for (int i = 0; i < ourPlayer.getCells().size(); i++) {
            Cell cell = (Cell)ourPlayer.getCells().get(i);

            finalMass += cell.getMass();
        }
    }

    public void update(int i) {

    }

    public void draw() {
        processing.background(0);

        processing.text("You have died: " + ourPlayer.getName(), processing.width /2, processing.height/2);
        processing.text("Final Mass: " + finalMass, processing.width/2, processing.height /2 + (processing.height/ 5));
    }
}
