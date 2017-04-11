package in.voidma.classroom.network.client.gui;

import fisica.FWorld;
import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.client.entity.Player;

/**
 * Created by Zane on 4/4/2017.
 */
public class PlayScreen extends Screen {

    Player ourPlayer;
    FWorld world;

    public PlayScreen(Client client) {
        super(client);
        world = client.getWorld();
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
