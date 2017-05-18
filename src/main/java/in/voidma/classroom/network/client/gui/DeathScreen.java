package in.voidma.classroom.network.client.gui;

//import fisica.FBody;
//import fisica.FCompound;
import in.voidma.classroom.network.client.Client;

import java.util.ArrayList;

/**
 * Created by schan on 4/18/2017.
 */
public class DeathScreen extends Screen {

    int finalMass = 0;
    //private FCompound ourPlayer;

    public DeathScreen(Client client) {
        super(client);

       /* for (FBody body : (ArrayList<FBody>) ourPlayer.getBodies()) {
            finalMass += body.getMass();
        }*/
    }

    public void update(int seconds) {

    }

    public void draw() {
        processing.background(0);

        processing.text("You have died: ", processing.width /2, processing.height/2);
        processing.text("Final Mass: " + finalMass, processing.width/2, processing.height /2 + (processing.height/ 5));
    }
}
